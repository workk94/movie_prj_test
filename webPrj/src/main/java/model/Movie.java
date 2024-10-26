package model;

import java.util.Objects;

public class Movie {
	private String id; // 영화id
	private String title; // 제목
	private String plot; // 줄거리
	private String img_url; // 포스터 이미지
	private String rlsDate; // 개봉일
	private String rating; // 관람등급
	private int runtime; // 상영시간
	private String genre; // 장르
	// private String director;
	// private String actor;

	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * public Movie(String title) { super(); this.title = title; }
	 */
	
	public Movie(String id, String title, String plot, String img_url, String rlsDate, String rating, int runtime,
			String genre) {
		super();
		this.id = id;
		this.title = title;
		this.plot = plot;
		this.img_url = img_url;
		this.rlsDate = rlsDate;
		this.rating = rating;
		this.runtime = runtime;
		this.genre = genre;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getPlot() {
		return plot;
	}

	public String getImg_url() {
		return img_url;
	}

	public String getRlsDate() {
		return rlsDate;
	}

	public String getRating() {
		return rating;
	}

	public int getRuntime() {
		return runtime;
	}

	public String getGenre() {
		return genre;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", plot=" + plot + ", img_url=" + img_url + ", rlsDate="
				+ rlsDate + ", rating=" + rating + ", runtime=" + runtime + ", genre=" + genre + "]";
	}
}
