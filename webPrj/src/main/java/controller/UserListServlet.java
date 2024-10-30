package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;


@WebServlet("/userList")
public class UserListServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ArrayList<User> users = new ArrayList<>();
		
		users.add(new User("user1", "Alice", "password1", "1990-01-01", "adult", "Inception", "Movie 43"));
	    users.add(new User("user2", "Bob", "password2", "1992-02-02", "adult", "The Shawshank Redemption", "Cats"));
	    users.add(new User("user3", "Charlie", "password3", "1995-03-03", "adult", "The Godfather", "Transformers"));
	    users.add(new User("user4", "David", "password4", "2000-04-04", "child", "Toy Story", "The Emoji Movie"));
	    users.add(new User("user5", "Eve", "password5", "1998-05-05", "adult", "Pulp Fiction", "Fifty Shades of Grey"));
	    users.add(new User("user6", "Frank", "password6", "1985-06-06", "adult", "Forrest Gump", "Battlefield Earth"));
	    users.add(new User("user7", "Grace", "password7", "2003-07-07", "child", "Finding Nemo", "Sharknado"));
	    users.add(new User("user8", "Heidi", "password8", "1996-08-08", "adult", "The Dark Knight", "Gigli"));
	    users.add(new User("user9", "Ivan", "password9", "1991-09-09", "adult", "Fight Club", "The Love Guru"));
	    users.add(new User("user10", "Judy", "password10", "1988-10-10", "adult", "The Matrix", "The Room"));

		
		
		
		req.setAttribute("userList", users);
	    req.getRequestDispatcher("WEB-INF/views/userList.jsp").forward(req, resp);
	    
	
	
	}
	
}
