package com.seed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.seed.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private Connection connection;
	
	public EmployeeDaoImpl() {}
	
	public EmployeeDaoImpl(Connection con) {
		this.connection = con;
	}

	@Override
	public void save(Employee emp)   throws SQLException{
		String sql = "insert into emp(id, first_name,last_name,salary,department) values (seq_emp_id.nextval,?,?,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setDouble(3, emp.getSalary());
			ps.setString(4, emp.getDepartment());
			ps.executeUpdate();
		}

	}

	@Override
	public int update(int id, Employee emp)  throws SQLException{
		String sql ="update emp set first_name = ?, last_name = ?, salary =?, department =? where id =?";
		return 0;
	}

	@Override
	public void delete(int id)  throws SQLException{
		String sql ="delete from emp where id = ?";
		
	}

	@Override
	public Employee findById(int id)  throws SQLException {
		String sql ="select * from emp where id = ?";
		return null;
	}

	@Override
	public List<Employee> findByName(String firstName)   throws SQLException{
		String sql ="select * from emp where first_name =? ";
		return null;
	}

	@Override
	public List<Employee> findAll()  throws SQLException{
		String sql ="select * from emp";
		return null;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
