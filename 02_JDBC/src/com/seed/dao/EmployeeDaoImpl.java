package com.seed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		try(PreparedStatement ps = connection.prepareStatement(EMP_ADD)){
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setDouble(3, emp.getSalary());
			ps.setString(4, emp.getDepartment());
			ps.executeUpdate();
		}

	}

	@Override
	public int update(int id, Employee emp)  throws SQLException{
		try(PreparedStatement ps = connection.prepareStatement(EMP_UPDATE)){
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setDouble(3, emp.getSalary());
			ps.setString(4, emp.getDepartment());
			ps.setInt(5, id);
			return ps.executeUpdate();
		}
	}

	@Override
	public void delete(int id)  throws SQLException{
		try(PreparedStatement ps = connection.prepareStatement(EMP_DELETE)){
			ps.setInt(1, id);
			ps.executeUpdate();
		}
	}

	@Override
	public Employee findById(int id) throws SQLException {
		try (PreparedStatement ps = connection.prepareStatement(EMP_FIND_BY_ID)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return getEmployee(rs);
				}
			}
		}
		return null;
	}

	@Override
	public List<Employee> findByName(String firstName)   throws SQLException{
		List<Employee> list = new ArrayList<Employee>();
		try (PreparedStatement ps = connection.prepareStatement(EMP_FIND_BY_NAME)) {
			ps.setString(1, firstName);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					 Employee emp = getEmployee(rs);
					 list.add(emp);
				}
			}
		}
		return list;
	}

	@Override
	public List<Employee> findAll()  throws SQLException{
		List<Employee> list = new ArrayList<Employee>();
		try (PreparedStatement ps = connection.prepareStatement(EMP_FIND_ALL)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					 Employee emp = getEmployee(rs);
					 list.add(emp);
				}
			}
		}
		return list;
	}
	
	private Employee getEmployee(ResultSet rs) throws SQLException {
		Employee emp = new Employee();
		emp.setId(rs.getInt("id"));
		emp.setFirstName(rs.getString("first_name"));
		emp.setLastName(rs.getString("last_name"));
		emp.setSalary(rs.getDouble("salary"));
		emp.setDepartment(rs.getString("department"));
		return emp;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
