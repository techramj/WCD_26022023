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
import javax.servlet.http.HttpSession;

import com.seed.entity.Employee;
import com.seed.service.EmpService;
import com.seed.service.EmpServiceImpl;
import com.seed.service.UserService;
import com.seed.service.UserServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;
	private EmpService empService;

	@Override
	public void init() throws ServletException {
		Connection con = (Connection)getServletContext().getAttribute("connection");
		userService = new UserServiceImpl(con);
		empService = new EmpServiceImpl(con);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username: "+username+"  password: "+password);
		String page;  //view
		if(userService.isValidUser(username, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			page = "WEB-INF/views/home.jsp";
			//model => list of employees
			List<Employee> employees = empService.getAllEmployeeDetails(); //model
			request.setAttribute("employees", employees);
		}else {
			System.out.println("Invalid Username and Password! username="+username);
			request.setAttribute("errorMessage", "Invalid Username and Password!!");  //model
			page = "index.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String page;  //view
		if(session != null && session.getAttribute("username") != null) {
			page = "WEB-INF/views/home.jsp";
			//model => list of employees
			List<Employee> employees = empService.getAllEmployeeDetails(); //model
			request.setAttribute("employees", employees);
		}else {
			request.setAttribute("errorMessage", "You have not logged in");  //model
			page = "index.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);	
	}
	
	
}
