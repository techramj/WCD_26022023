package com.seed.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection connection;

	public static Connection getConnection(String driver, String url, String username, String password) {
		System.out.println("driver: "+driver+"   url: "+url+"  username: "+username+"   password: "+password);
		// Class.forName("com.seed.Emp");
		if (connection != null) {
			return connection;
		}

		try {
			// step 1: load the driver
			Class.forName(driver);
			System.out.println("driver loaded successfully");

			// step 2: get the connection object
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Db connected successfully");
			System.out.println(connection.getClass().getName());

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

}
