package com.seed.dao;

import java.sql.SQLException;
import java.util.List;

import com.seed.entity.Employee;

public class EmployeeDaoFileImpl implements EmployeeDao{

	@Override
	public void save(Employee emp) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(int id, Employee emp) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findByName(String firstName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
