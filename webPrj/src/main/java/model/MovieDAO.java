package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import util.DBManager;

public class MovieDAO {

	public Movie selectOne(String title) {
		String sql = "SELECT * FROM movie WHERE LOWER(title) = LOWER(?)";
		Connection con = null;
		Movie movie = null;

		try {
			con = DBManager.dbCon(); 
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, title.trim()); 

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				String id = rs.getString("id");
				String movieTitle = rs.getString("title").trim();
				String plot = rs.getString("plot");
				String imgUrl = rs.getString("img_url");
				String rlsDate = rs.getString("rls_date");
				String rating = rs.getString("rating");
				int runtime = rs.getInt("runtime");
				String genre = rs.getString("genre");

				movie = new Movie(id, movieTitle, plot, imgUrl, rlsDate, rating, runtime, genre);
			}

			rs.close();
			pst.close();

		} catch (SQLException e) {
			System.err.println("영화 정보를 찾을 수 없습니다 : " + title);
			e.printStackTrace();
		} finally {
			try {
				if (con != null && !con.isClosed()) {
					con.close(); 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return movie; 
	}

	public void insertMovies(List<Movie> movies) {
		String sql = "INSERT INTO MOVIE (ID, TITLE, PLOT, IMG_URL, RLS_DATE, RATING, RUNTIME, GENRE) "
				+ "VALUES (?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?)";

		try (Connection conn = DBManager.dbCon(); PreparedStatement pst = conn.prepareStatement(sql)) {
			for (Movie movie : movies) {
				pst.setString(1, movie.getId());
				pst.setString(2, movie.getTitle().trim());
				pst.setString(3, movie.getPlot());
				pst.setString(4, movie.getImg_url());
				pst.setString(5, movie.getRlsDate());
				pst.setString(6, movie.getRating());
				pst.setInt(7, movie.getRuntime());
				pst.setString(8, movie.getGenre());

				pst.addBatch(); // Batch에 추가
			}
			pst.executeBatch(); // Batch 실행

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
