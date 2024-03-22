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
 * Servlet implementation class EmpEditController
 */
@WebServlet("/delete")
public class EmpDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpService empService;

	@Override
	public void init() throws ServletException {
		Connection con = (Connection)getServletContext().getAttribute("connection");
		empService = new EmpServiceImpl(con);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		empService.deleteEmp(id);
		
		/*String page ="WEB-INF/views/home.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		List<Employee> list = empService.getAllEmployeeDetails();
		request.setAttribute("employees", list);
		rd.forward(request, response);
		*/
		
		response.sendRedirect("login");
	}

}
