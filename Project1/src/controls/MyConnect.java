package controls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {
	
	public Connection getConnection() {
		Connection conn = null;
		final String url = "jdbc:mysql://localhost:3306/ql_khachsan?characterEncoding=UTF-8";
		final String user = "root";
		final String password = "";
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					conn = DriverManager.getConnection(url, user, password);
					System.out.println("Thanh Cong!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("That bai!");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("That bai!");
			}
		return conn;
	}
	 public void closeConnection(Connection c) {
	        try {
	            c.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	            // TODO: handle exception
	        }
	    }
	 public static void main(String[] args) {
		
		MyConnect conn = new MyConnect();
		conn.getConnection();
	}
}
