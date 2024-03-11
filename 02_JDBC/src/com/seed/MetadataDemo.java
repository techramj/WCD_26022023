package com.seed;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class MetadataDemo {
	
	public static void displayDbInfo() throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		DatabaseMetaData md = con.getMetaData();
		System.out.println("Version: "+md.getDatabaseProductVersion());
		System.out.println("column max lenght: " +md.getMaxColumnNameLength());
		System.out.println("max row size: "+md.getMaxRowSize());
	}
	
	public static void main(String[] args) {
		try {
			displayDbInfo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
