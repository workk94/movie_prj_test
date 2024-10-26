package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

	public static Connection dbCon() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "scott";
		String password = "tiger";
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
//			if (con != null)
//				System.out.println("db connected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static void dbClose(AutoCloseable... a) {
		for (AutoCloseable item : a) {
			if (item != null) {
				try {
					item.close(); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("오류");
			}
		}
	}

}
