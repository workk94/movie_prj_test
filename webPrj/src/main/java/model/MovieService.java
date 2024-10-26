package model;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public class MovieService {
	MovieDAO dao = new MovieDAO();
	
	public void insertMonthlyMovies() {

		MovieApiService service = new MovieApiService();

		int currentYear = LocalDate.now().getYear();
		int currentMonth = LocalDate.now().getMonthValue();

		for (int month = 1; month <= currentMonth; month++) {
			YearMonth yearMonth = YearMonth.of(currentYear, month);
			String startDate = yearMonth.atDay(1).toString().replace("-", "");
			String endDate = yearMonth.atEndOfMonth().toString().replace("-", "");

			int pageNo = 1;
			boolean hasNext = true;

			while (hasNext) {
				try {
					String jsonResponse = service.fetchKMDBMovieData(startDate, endDate, pageNo);
					List<Movie> movies = service.parseMovieData(jsonResponse);

					if (movies.isEmpty()) {
						hasNext = false;
					} else {
						dao.insertMovies(movies);
						pageNo++; 
					}

				} catch (Exception e) {
					e.printStackTrace();
					hasNext = false; 
				}
			}
		}
	}
}
