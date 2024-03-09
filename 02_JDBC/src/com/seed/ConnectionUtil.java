package com.seed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection connection;
	
	static {
		/*String driver ="oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1522:XE";
		String username ="hr";
		String password = "hr";
		
		try {
			//Class.forName("com.seed.Emp");
			//step 1: load the driver
			Class.forName(driver);
			System.out.println("driver loaded successfully");		
			
			//step 2: get the connection object
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Db connected successfully");
			System.out.println(connection.getClass().getName());
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		*/
	}
	
	public static synchronized Connection getConnection(String driver, String url, String username, String password) {
		
		// Class.forName("com.seed.Emp");
		if (connection != null) {
			return connection;
		}

		try {
			System.out.println("driver: "+driver+"   url: "+url+"  username: "+username+"   password: "+password);
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
	
	
	public static Connection getConnection() {
		return connection;
	}

}
