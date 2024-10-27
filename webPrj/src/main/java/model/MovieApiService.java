package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;
import kr.or.kobis.kobisopenapi.consumer.rest.exception.OpenAPIFault;

public class MovieApiService {

	// KMDB API
	public String fetchKMDBMovieData(String startDate, String endDate, int pageNo) throws IOException {
		String serviceKey = "K631OS1085173586S0M9";
		// 1페이지당 가져올 목록 개수 
		String listCount = "10"; 
		
		StringBuilder urlBuilder = new StringBuilder(
				"http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2");
		urlBuilder
				.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + URLEncoder.encode(serviceKey, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("releaseDts", "UTF-8") + "=" + URLEncoder.encode(startDate, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("releaseDte", "UTF-8") + "=" + URLEncoder.encode(endDate, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("listCount", "UTF-8") + "=" + URLEncoder.encode(listCount, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("startCount", "UTF-8") + "="
				+ URLEncoder.encode(String.valueOf((pageNo - 1) * 10), "UTF-8"));

		URL url = new URL(urlBuilder.toString());
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300 ? conn.getInputStream()
						: conn.getErrorStream()));

		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();

		return sb.toString();
	}

	public List<Movie> parseMovieData(String json) {
		List<Movie> movieList = new ArrayList<>();

		JSONObject jsonObject = new JSONObject(json);
		JSONArray dataArray = jsonObject.getJSONArray("Data");

		for (int i = 0; i < dataArray.length(); i++) {
			JSONObject dataObj = dataArray.getJSONObject(i);
			JSONArray resultArray = dataObj.getJSONArray("Result");

			for (int j = 0; j < resultArray.length(); j++) {
				JSONObject resultObj = resultArray.getJSONObject(j);

				String id = resultObj.getString("DOCID");
				String title = resultObj.getString("title");
				String plot = resultObj.getJSONObject("plots").getJSONArray("plot").getJSONObject(0)
						.getString("plotText");
				String imgUrl = resultObj.getString("posters").split("\\|")[0]; // 첫 번째 이미지 선택
				String rlsDate = resultObj.getString("repRlsDate");
				String rating = resultObj.getString("rating");
				int runtime = resultObj.getInt("runtime");
				String genre = resultObj.getString("genre");

				Movie movie = new Movie(id, title, plot, imgUrl, rlsDate, rating, runtime, genre);
				movieList.add(movie);
			}
		}
		return movieList;
	}

	// Kofic Movie API
	public TreeMap<Integer, Movie> getDailyBoxOffice(String targetDt) {
		System.out.println(targetDt);
		
		String key = "594685878539ec3e7c015ddd87670baa";
		TreeMap<Integer, Movie> map = new TreeMap<>();
		MovieDAO dao = new MovieDAO();

		KobisOpenAPIRestService service = new KobisOpenAPIRestService(key);
		
		String itemPerPage = "";
		String multiMovieYn = "";
		String repNationCd = "";
		String wideAreaCd = "";

		try {
			// isJson (true : json, false : xml)
			String result = service.getDailyBoxOffice(true, targetDt, itemPerPage, multiMovieYn, repNationCd,
					wideAreaCd);

			JSONObject jsonObj = new JSONObject(result);
			JSONObject boxOfficeResult = jsonObj.getJSONObject("boxOfficeResult");
			JSONArray dailyBoxOfficeList = boxOfficeResult.getJSONArray("dailyBoxOfficeList");

			for (int i = 0; i < dailyBoxOfficeList.length(); i++) {
				JSONObject movie = dailyBoxOfficeList.getJSONObject(i);
				int rank = movie.getInt("rank"); 
				String movieNm = movie.getString("movieNm").trim();
				System.out.println("api 출력 : " + movieNm); 
				//불러온 박스오피스를 db에서 영화 이름으로 찾기 
				map.put(rank, dao.selectOne(movieNm));
			}

		} catch (OpenAPIFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return map;
	}
	
	
	//test
	public static void main(String[] args) {
		MovieApiService service = new MovieApiService();
		Map<Integer, Movie> map = service.getDailyBoxOffice("20241025");
		
		map.forEach((t, u) -> System.out.println(t + " " + u));
	}
}
