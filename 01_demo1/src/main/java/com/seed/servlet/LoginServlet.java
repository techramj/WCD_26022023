package com.seed.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	public LoginServlet() {
		System.out.println("LoginServlet constructor called....");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("LoginServlet init method called");
		String str = getInitParameter("a");
		System.out.println("a= "+str);
		
		ServletContext context = getServletContext();
		String j = context.getInitParameter("j");
		System.out.println("j= "+j);
	}
	
	//don't ovveride service method
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service method!!!");
		super.service(req, resp);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("get method");
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if("123".equals(password)) {
			out.println("<h3>Welcome "+name+"</h3>");
		}else {
			out.println("<h4>Invalid username & password</h4>");
			out.println("<a href='login.html'>Go to Login Page</a>");
		}
		
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("post method");
	}
	
	@Override
	public void destroy() {
		System.out.println("LoginServlet destroy!!!!");
	}

}
