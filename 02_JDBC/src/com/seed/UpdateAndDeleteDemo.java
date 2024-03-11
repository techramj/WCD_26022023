package com.seed;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateAndDeleteDemo {
	
	public static void deleteEmployees(double salary) {
		String sql  = "delete from emp where salary = ?";
		Connection con = ConnectionUtil.getConnection();
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setDouble(1, salary);
			int rowAffected = ps.executeUpdate();
			System.out.println(rowAffected + " row(s) deleted!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} 
	
	public static void updateSalary(int id,double salary) {
		String sql  = "update emp set salary =? where id = ?";
		Connection con = ConnectionUtil.getConnection();
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setDouble(1, salary);
			ps.setInt(2, id);
			int rowAffected = ps.executeUpdate();
			System.out.println(rowAffected + " row(s) updated!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} 
	
	public static void main(String[] args) {
		deleteEmployees(4800);
		updateSalary(103, 25000);
	}

}
