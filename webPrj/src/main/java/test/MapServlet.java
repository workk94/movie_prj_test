package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/getLocations")
public class MapServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String latitude = req.getParameter("latitude");
	    String longitude = req.getParameter("longitude");

	    System.out.println("GET latitude: " + latitude);
	    System.out.println("GET longitude: " + longitude);

	    String urlStr = String.format(
	        "https://dapi.kakao.com/v2/local/search/keyword.json?x=%s&y=%s&radius=2000&query=%s",
	        longitude, latitude, URLEncoder.encode("영화관", "UTF-8")
	    );
	    URL url = new URL(urlStr);
	    System.out.println("Request URL: " + urlStr);

	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Authorization", "KakaoAK 5bea60374e0f1e3a2fe81e81ace6fa35");

	    BufferedReader rd = new BufferedReader(new InputStreamReader(
	        conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300 ? conn.getInputStream() : conn.getErrorStream()
	    ));
	    StringBuilder sb = new StringBuilder();
	    String line;
	    while ((line = rd.readLine()) != null) {
	        sb.append(line);
	    }
	    rd.close();
	    conn.disconnect();

	    resp.setContentType("application/json; charset=UTF-8");
	    resp.getWriter().write(sb.toString());
	}



}
