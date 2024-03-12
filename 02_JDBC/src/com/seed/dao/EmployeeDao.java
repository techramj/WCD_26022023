package com.seed.dao;

import java.sql.SQLException;
import java.util.List;

import com.seed.entity.Employee;

public interface EmployeeDao {
	
	String EMP_DELETE ="delete from emp where id =?";
	String EMP_UPDATE = "update emp set first_name = ?, last_name = ?, salary =?, department =? where id =?";
	String EMP_FIND_BY_ID = "select * from emp where id = ?";
	String EMP_ADD = "insert into emp(id, first_name,last_name,salary,department) values (seq_emp_id.nextval,?,?,?,?)";
	String EMP_FIND_BY_NAME ="select * from emp where first_name =? ";
	String EMP_FIND_ALL = "select * from emp";
	
	void save(Employee emp) throws SQLException;
	int update(int id, Employee emp)  throws SQLException;
	void delete(int id)  throws SQLException;
	Employee findById(int id)  throws SQLException;
	List<Employee> findByName(String firstName)  throws SQLException;
	List<Employee> findAll()  throws SQLException;
}
