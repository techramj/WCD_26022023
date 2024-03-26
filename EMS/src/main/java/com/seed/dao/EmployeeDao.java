package com.seed.dao;

import java.sql.SQLException;
import java.util.List;

import com.seed.entity.Employee;

public interface EmployeeDao {

	String ADD_EMP = "insert into emp(id,first_name,last_name,salary, department) values ( seq_emp_id.nextval, ?,?,?,?)";
	String DELETE_EMP = "delete from emp where id =?";
	String UPDATE_EMP = "update emp set first_name = ?, last_name =?,salary =?,department =? where id =?";
	String FIND_BY_ID = "select * from emp where id =?";
	String ALL_EMP = "select * from emp";
	String FIND_BY_NAME = "select * from emp where first_name = ?";
	String FIND_ALL_DEPT = "select department_name from departments";

	Employee findById(int id) throws SQLException;

	List<Employee> findAll() throws SQLException;

	void save(Employee employee) throws SQLException;

	void delete(int id) throws SQLException;

	void update(int id, Employee emp) throws SQLException;

	List<Employee> findByFirstName(String firstName) throws SQLException;
	
	List<String> findAllDepartments() throws SQLException;
}
