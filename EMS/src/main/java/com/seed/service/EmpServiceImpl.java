package com.seed.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seed.dao.EmployeeDao;
import com.seed.dao.EmployeeDaoImpl;
import com.seed.entity.Employee;

public class EmpServiceImpl implements EmpService{
	
	private EmployeeDao dao;
	
	public EmpServiceImpl(Connection con) {
		dao = new EmployeeDaoImpl(con);
	}

	@Override
	public void addEmp(Employee emp) {
		try {
			dao.save(emp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void deleteEmp(int id) {
		try {
			dao.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateEmp(int id, Employee emp) {
		try {
			dao.update(id, emp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Employee getEmployeeDetails(int id) {
		try {
			return dao.findById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		try {
			return dao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Employee>();
	}

	@Override
	public List<Employee> getEmployeesDetail(String firstName) {
		try {
			return dao.findByFirstName(firstName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteEmp(String id) {
		int empId = Integer.parseInt(id);
		try {
			dao.delete(empId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
