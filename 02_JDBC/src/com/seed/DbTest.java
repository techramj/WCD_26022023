package com.seed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbTest {
	
	public static void main(String[] args) {
		String driver ="oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1522:XE";
		String username ="hr";
		String password = "hr";
		
		try {
			//Class.forName("com.seed.Emp");
			//step 1: load the driver
			Class.forName(driver);
			System.out.println("driver loaded successfully");		
			
			//step 2: get the connection object
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Db connected successfully");
			System.out.println(connection.getClass().getName());
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
