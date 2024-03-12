package com.seed.main;

import java.sql.SQLException;
import java.util.List;

import com.seed.ConnectionUtil;
import com.seed.dao.EmployeeDao;
import com.seed.dao.EmployeeDaoImpl;
import com.seed.entity.Employee;

public class Test {
	
	public static void main(String[] args)  {
		Employee emp = new Employee();
		emp.setFirstName("Sam");
		emp.setLastName("shina");
		emp.setSalary(1000);
		emp.setDepartment("HR");
		
		EmployeeDao dao = new EmployeeDaoImpl(ConnectionUtil.getConnection());
		//adding
		try {
			//insert
			dao.save(emp);
			System.out.println("emp added successfully");
			
			//delete
			dao.delete(110);
			System.out.println("deleted id 110");
			
			//update
			Employee emp1 = new Employee();
			emp1.setFirstName("Jessica");
			emp1.setLastName("A");
			emp1.setSalary(8000);
			emp1.setDepartment("IT");
			dao.update(115,emp1 );
			
			Employee emp115 = dao.findById(115);
			System.out.println(emp115);
			
			System.out.println("details of all employee");
			List<Employee> employees = dao.findAll();
			for(Employee e: employees) {
				System.out.println(e);
			}
			
			System.out.println("\ndetails of all employees with name sam");
			List<Employee> samEmployees = dao.findByName("Sam");
			for(Employee e: samEmployees) {
				System.out.println(e);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		//update
		
		
	}

}
