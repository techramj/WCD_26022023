package com.seed.main;

import java.sql.SQLException;

import com.seed.ConnectionUtil;
import com.seed.dao.EmployeeDao;
import com.seed.dao.EmployeeDaoImpl;
import com.seed.entity.Employee;

public class Test {
	
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setFirstName("Sam");
		emp.setLastName("shina");
		emp.setSalary(1000);
		emp.setDepartment("HR");
		
		EmployeeDao dao = new EmployeeDaoImpl(ConnectionUtil.getConnection());
		try {
			dao.save(emp);
			System.out.println("emp added successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		try