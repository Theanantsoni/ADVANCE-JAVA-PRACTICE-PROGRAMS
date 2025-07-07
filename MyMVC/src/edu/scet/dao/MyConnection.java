package edu.scet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private static Connection con = null;
	public static Connection getConnection() {
		if (con == null) {
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/corejava","root","");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	public static void close() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
