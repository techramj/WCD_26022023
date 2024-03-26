package com.seed.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seed.entity.Employee;
import com.seed.service.EmpService;
import com.seed.service.EmpServiceImpl;

/**
 * Servlet implementation class AddEmployeeController
 */
@WebServlet("/add-emp")
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpService empService;

	@Override
	public void init() throws ServletException {
		Connection con = (Connection) getServletContext().getAttribute("connection");
		empService = new EmpServiceImpl(con);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page = "WEB-INF/views/addEmpForm.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		List<String> depts = empService.getDepartments();
		request.setAttribute("departments", depts);
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String salary = request.getParameter("salary");
		String department = request.getParameter("department");

		Employee emp = new Employee();
		emp.setFirstName(fname);
		emp.setLastName(lname);
		emp.setSalary(Double.parseDouble(salary));
		emp.setDepartment(department);
		
		empService.addEmp(emp);
		response.sendRedirect("login");	

	}

}
