package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {

	public static void main(String[] args) {

		String jdbc = "jdbc:mysql://localhost:3306/one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user = "test";
		String password = "test";
		
		try {

			Connection con = DriverManager.getConnection(jdbc, user, password);
			System.out.println("SUCCESS !");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
