package com.seed;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateApiExample {
	
	public static void example1(String sql) {
		Connection con = ConnectionUtil.getConnection();
		try (Statement st = con.createStatement()) {
			if(st.execute(sql)) {
				//select query
				try(ResultSet rs = st.getResultSet()){
					ResultSetMetaData md = rs.getMetaData();
					int columnCount = md.getColumnCount();
					System.out.println("no of columns ="+columnCount);
					for(int i=1;i<=columnCount;i++) {
						System.out.print(md.getColumnName(i)+"\t");
					}
					System.out.println("\n");
					while(rs.next()) {
						for(int i=1;i<=columnCount;i++) {
							System.out.print(rs.getObject(i)+"\t");
						}
						System.out.println();
					}
					System.out.println();
				}
			}else {
				int rowAffected = st.getUpdateCount();
				System.out.println(rowAffected+" rows affected!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//example1("select * from employees");
		//example1("update emp set salary = salary +100");
		example1("delete emp where salary>25000");
	}

}
