package com.seed.dao;

import java.sql.SQLException;
import java.util.List;

import com.seed.entity.Employee;

public interface EmployeeDao {
	void save(Employee emp) throws SQLException;
	int update(int id, Employee emp)  throws SQLException;
	void delete(int id)  throws SQLException;
	Employee findById(int id)  throws SQLException;
	List<Employee> findByName(String firstName)  throws SQLException;
	List<Employee> findAll()  throws SQLException;
}
