package com.seed.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seed.entity.Employee;
import com.seed.service.EmpService;
import com.seed.service.EmpServiceImpl;

/**
 * Servlet implementation class EmpUpdateController
 */
@WebServlet("/edit")
public class EmpUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpService empService;

	@Override
	public void init() throws ServletException {
		Connection con = (Connection)getServletContext().getAttribute("connection");
		empService = new EmpServiceImpl(con);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//check session is active or not
		HttpSession session    = request.getSession(false);
		if(session == null || session.getAttribute("username") == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		
		int id = Integer.parseInt(request.getParameter("id"));

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/empForm.jsp");
		Employee emp = empService.getEmployeeDetails(id);
		request.setAttribute("emp", emp);
		//request.setAttribute("departments", empService.getDepartments());
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//save the update record.
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String salary = request.getParameter("salary");
		String department = request.getParameter("department");
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		Employee emp = new Employee();
		emp.setFirstName(fname);
		emp.setLastName(lname);
		emp.setSalary(Double.parseDouble(salary));
		emp.setDepartment(department);
		emp.setId(id);
		
		empService.updateEmp(id, emp);
		
		response.sendRedirect("login");
	}

}
