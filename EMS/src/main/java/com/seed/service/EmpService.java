package com.seed.service;

import java.util.List;

import com.seed.entity.Employee;

public interface EmpService {
	
	public void addEmp(Employee emp);
	public void deleteEmp(int id);
	public void deleteEmp(String id);
	public void updateEmp(int id, Employee emp);
	public Employee getEmployeeDetails(int id);
	public List<Employee> getAllEmployeeDetails();
	public List<Employee> getEmployeesDetail(String firstName);

}
