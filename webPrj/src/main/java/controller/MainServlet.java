package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Movie;
import model.MovieApiService;
import model.MovieService;


@WebServlet("/main")
public class MainServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 하루 전 조회 
		LocalDate date = LocalDate.now().minusDays(1);
		
		MovieApiService apiService = new MovieApiService();
		MovieService service = new MovieService();
		
        String date_ = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.err.println(date_);
        TreeMap<Integer, Movie> map = apiService.getDailyBoxOffice(date_);

   
        map.entrySet().stream()
            .filter(entry -> entry.getValue() != null)  
            .forEach(entry -> 
                System.out.println("순위: " + entry.getKey() + ", 영화제목: " + entry.getValue().getTitle())
            );
		
		req.setCharacterEncoding("utf-8");
		req.setAttribute("boxOffice", map);
		req.getRequestDispatcher("WEB-INF/views/main.jsp").forward(req, resp);
	}
}
