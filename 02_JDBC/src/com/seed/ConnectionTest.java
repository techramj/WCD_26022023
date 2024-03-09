package com.seed;

import java.sql.Connection;

public class ConnectionTest {
	
	public static void main(String[] args) {
		String driver ="oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1522:XE";
		String username ="hr";
		String password = "hr";
		
		//Connection con1 = ConnectionUtil.getConnection(driver, url, username, password);
		//Connection con2 = ConnectionUtil.getConnection(driver, url, username, password);
		//System.out.println(con1 == con2);
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				Connection con1 = ConnectionUtil.getConnection(driver, url, username, password);
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				Connection con2 = ConnectionUtil.getConnection(driver, url, username, password);
			}
		};
		
		t1.start();
		t2.start();
	}

}
