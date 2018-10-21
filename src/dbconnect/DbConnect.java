package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	Connection conn = null;
	
	String username = "sa";
	String password = "1234";
	String url = "jdbc:sqlserver://localhost:1433; instance=DUNGCD-HPT;databaseName=DB_Final_Exam";
	
	/**
	 * Method create new connect to database
	 */
	public Connection getConnect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Load driver khong thanh cong");
		} catch (SQLException e) {
			System.out.println("Ket noi that bai");
		}
		return conn;
	}
	public static void main(String[] args) {
		DbConnect connect= new DbConnect();
		System.out.println(connect.getConnect());
	}
}