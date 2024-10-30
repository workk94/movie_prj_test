package model;

public class User {

	String user_id;		//사용자 id
	String name;		//이름
	String pw; 			//비밀번호 4자리이상 영어,숫자,특수기호 하나이상 포함
	String birth;		//생년월일
	String adult_child;	//생년월일 에서 현재시점 성인여부 판별해서 성인 또는 미성년 지정
	String best_movie;	//최고영화
	String worst_movie;	//최악영화
						// 이정보들로 비밀번호 힌트를 줄까
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String user_id, String name, String pw, String birth, String adult_child, String best_movie,
			String worst_movie) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.pw = pw;
		this.birth = birth;
		this.adult_child = adult_child;
		this.best_movie = best_movie;
		this.worst_movie = worst_movie;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", pw=" + pw + ", birth=" + birth + ", adult_child="
				+ adult_child + ", best_movie=" + best_movie + ", worst_movie=" + worst_movie + "]";
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAdult_child() {
		return adult_child;
	}

	public void setAdult_child(String adult_child) {
		this.adult_child = adult_child;
	}

	public String getBest_movie() {
		return best_movie;
	}

	public void setBest_movie(String best_movie) {
		this.best_movie = best_movie;
	}

	public String getWorst_movie() {
		return worst_movie;
	}

	public void setWorst_movie(String worst_movie) {
		this.worst_movie = worst_movie;
	}

	
	
	
	
	
	
	
	
}
