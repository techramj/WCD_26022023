package com.seed;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDemo {
	
	public static void example1() {
		String sql ="select * from emp";
		Connection con = ConnectionUtil.getConnection();
		try(Statement st = con.createStatement(); 
				ResultSet rs = st.executeQuery(sql);){
			while(rs.next()) {
				int id = rs.getInt("id");
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				double sal = rs.getDouble("salary");
				String department = rs.getString("department");
				System.out.println(id+"   "+fname+"   "+lname+"  "+sal+"   "+department);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void example2() {
		String sql ="select * from emp";
		Connection con = ConnectionUtil.getConnection();
		try(Statement st = con.createStatement(); 
				ResultSet rs = st.executeQuery(sql);){
			while(rs.next()) {
				int id = rs.getInt(1); //1 is column index
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				double sal = rs.getDouble(5);
				String department = rs.getString(4);
				System.out.println(id+"   "+fname+"   "+lname+"  "+sal+"   "+department);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void fetchEmployeeByDepartment(String departmentName) {
		String sql = "select * from emp where department = ?";
		
		Connection con = ConnectionUtil.getConnection();
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, departmentName);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt(1); //1 is column index
					String fname = rs.getString(2);
					String lname = rs.getString(3);
					double sal = rs.getDouble(5);
					String department = rs.getString(4);
					System.out.println(id+"   "+fname+"   "+lname+"  "+sal+"   "+department);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		fetchEmployeeByDepartment("IT");
	}

}
