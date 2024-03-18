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

	public EmployeeDaoImpl(Connection con) {
		this.connection = con;
	}

	@Override
	public Employee findById(int id) throws SQLException {

		Employee emp = new Employee();
		try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					emp = getEmployee(rs);
				}
			}
		}
		return emp;
	}

	@Override
	public List<Employee> findAll() throws SQLException {
		List<Employee> employees = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(ALL_EMP)) {
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					employees.add(getEmployee(rs));
				}
			}
		}
		return employees;
	}

	@Override
	public List<Employee> findByFirstName(String firstName) throws SQLException {
		List<Employee> employees = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(ALL_EMP)) {
			ps.setString(1, firstName);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					employees.add(getEmployee(rs));
				}
			}
		}
		return employees;
	}

	@Override
	public void save(Employee employee) throws SQLException {
		try (PreparedStatement ps = connection.prepareStatement(ADD_EMP)) {
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setDouble(3, employee.getSalary());
			ps.setString(4, employee.getDepartment());
			int rowCount = ps.executeUpdate();

			System.out.println(rowCount + " row inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) throws SQLException {
		try (PreparedStatement ps = connection.prepareStatement(ADD_EMP)) {
			ps.setInt(1, id);
			int rowCount = ps.executeUpdate();
			System.out.println(rowCount + " row deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(int id, Employee employee) throws SQLException {
		try (PreparedStatement ps = connection.prepareStatement(UPDATE_EMP)) {
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setDouble(3, employee.getSalary());
			ps.setString(4, employee.getDepartment());
			ps.setInt(5, id);
			int rowCount = ps.executeUpdate();
		
			System.out.println(rowCount + " row updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
	


}
