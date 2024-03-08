package com.seed;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seed.entity.Employee;

public class InsertDemo {

	public static void example1() {
		String sql = "insert into emp(id,name,salary) values (100, 'jack', 2000)";
		Connection con = ConnectionUtil.getConnection();
		Statement st = null;
		try {
			st = con.createStatement();
			int rowAffected = st.executeUpdate(sql);
			System.out.println(rowAffected + " row(s) inserted!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void example2() {
		String sql = "insert into emp(id,name,salary) values (101, 'jackson', 3000)";
		Connection con = ConnectionUtil.getConnection();
		try (Statement st = con.createStatement()) {
			int rowAffected = st.executeUpdate(sql);
			System.out.println(rowAffected + " row(s) inserted!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void example3(int id, String name, double salary) {
		String sql = "insert into emp(id,name,salary) values (" + id + ",'" + name + "'," + salary + ")";
		System.out.println(sql);
		Connection con = ConnectionUtil.getConnection();
		try (Statement st = con.createStatement()) {
			int rowAffected = st.executeUpdate(sql);
			System.out.println(rowAffected + " row(s) inserted!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void example4(int id, String name, double salary) {
		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into emp(id,name,salary) values (?, ?, ?)"; // parameterized query
		try (PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDouble(3, salary);

			int rowAffected = ps.executeUpdate();
			System.out.println(rowAffected + " row(s) inserted!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// statement
	public static void addEmployees1(List<Employee> employees, Connection con) {

		try (Statement st = con.createStatement()) {
			for (Employee e : employees) {
				String sql = "insert into emp(id,name,salary) values (" + e.getId() + ",'" + e.getName() + "',"
						+ e.getSalary() + ")";
				int x = st.executeUpdate(sql);
				// System.out.println(x + " row(s) inserted!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// preparedstatement
	public static void addEmployees2(List<Employee> employees, Connection con) {
		String sql = "insert into emp(id,name,salary) values (?, ?, ?)";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			for (Employee e : employees) {
				ps.setInt(1, e.getId());
				ps.setString(2, e.getName());
				ps.setDouble(3, e.getSalary());

				int rowAffected = ps.executeUpdate();

				// System.out.println(rowAffected + " row(s) inserted!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void addEmployees1UsingBatch(List<Employee> employees, Connection con) {

		try (Statement st = con.createStatement()) {
			int counter = 0;
			for (Employee e : employees) {
				String sql = "insert into emp(id,name,salary) values (" + e.getId() + ",'" + e.getName() + "',"
						+ e.getSalary() + ")";
				 st.addBatch(sql);
				 counter++;
				 if(counter==1000) {
					 counter =0;
					 st.executeBatch();
					 System.out.println("batch executed");
				 }
				// System.out.println(x + " row(s) inserted!");
			}
			if(counter !=0) {
				st.executeBatch();
				 System.out.println("batch executed");
			}
			System.out.println(employees.size()+" rows inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void differenceBetweenStatementAndPreparedStatement() {
		Connection con = ConnectionUtil.getConnection();

		Employee e1 = new Employee(1001, "Ajay", 4000);
		Employee e2 = new Employee(1002, "Ajay", 4000);
		Employee e3 = new Employee(1003, "Ajay", 4000);

		Employee e4 = new Employee(1004, "Ajay", 4000);
		Employee e5 = new Employee(1005, "Ajay", 4000);
		Employee e6 = new Employee(1006, "Ajay", 4000);

		List<Employee> list1 = new ArrayList<>();
		list1.add(e1);
		list1.add(e2);
		list1.add(e3);

		List<Employee> list2 = new ArrayList<>();
		list2.add(e4);
		list2.add(e5);
		list2.add(e6);

		addEmployees1(list1, con);
		System.out.println("-----------------------------------");
		addEmployees2(list2, con);
	}

	public static void performanceTestBetweenStatementAndPrepatedStatement(String type, int count) {
		// create list of 10000 employee
		Connection con = ConnectionUtil.getConnection();

		List<Employee> list = new ArrayList<>();
		for (int i = 1; i <= count; i++) {
			Employee emp = new Employee(i, "name-" + i, 1000);
			list.add(emp);
		}
		long t1 = System.currentTimeMillis();
		if ("statement".equals(type)) {
			addEmployees1(list, con);
		} else {
			addEmployees2(list, con);
		}
		long t2 = System.currentTimeMillis();
		long time = t2 - t1;
		System.out.println("Time taken: " + time + " ms");
	}

	public static void performanceTestBetweenStatementAndPrepatedStatementUsingBatch(String type, int count) {
		// create list of 10000 employee
		Connection con = ConnectionUtil.getConnection();

		List<Employee> list = new ArrayList<>();
		for (int i = 1; i <= count; i++) {
			Employee emp = new Employee(i, "name-" + i, 1000);
			list.add(emp);
		}
		long t1 = System.currentTimeMillis();
		if ("statement".equals(type)) {
			addEmployees1UsingBatch(list, con);
		} else {
			addEmployees2(list, con);
		}
		long t2 = System.currentTimeMillis();
		long time = t2 - t1;
		System.out.println("Time taken: " + time + " ms");
	}

	public static void main(String[] args) {
		// differenceBetweenStatementAndPreparedStatement();

		//performanceTestBetweenStatementAndPrepatedStatement("statement", 10000);
		performanceTestBetweenStatementAndPrepatedStatementUsingBatch("statement", 10000);

	}

}
