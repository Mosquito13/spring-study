package com.mosquito.springstudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String[] args) {
		String uri = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(uri, "hbstudent", "hbstudent");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
