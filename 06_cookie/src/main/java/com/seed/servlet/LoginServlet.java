package com.seed.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seed.entity.User;
import com.seed.service.UserService;
import com.seed.service.UserServiceImpl;
import com.seed.util.ConnectionUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		String driver = context.getInitParameter("jdbc.driverClass");
		String url = context.getInitParameter("jdbc.url");
		String username = context.getInitParameter("jdbc.username");
		String password = context.getInitParameter("jdbc.password");
		
		Connection con = ConnectionUtil.getConnection(driver, url, username, password);
		context.setAttribute("connection", con);
		userService  = new UserServiceImpl(con);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ServletContext context = getServletContext();
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");

		if(userService.isValidUser(username, password)) {
			User user = userService.getUser(username);
			
			Cookie usernameCookie = new Cookie("username", username);
			Cookie fnameCookie = new Cookie("firstName", user.getFirstName());
			Cookie lnameCookie = new Cookie("lname", user.getFirstName());
			
			response.addCookie(usernameCookie);
			response.addCookie(fnameCookie);
			response.addCookie(lnameCookie);
			
			
			out.println("<h3>Welcome "+user.getFirstName()+" "+user.getLastName()+"</h3>");
			out.println("<form action='friend' method='get'>");
			out.println("<button type='submit'>Show Friend List</button>");
			out.println("</form>");
		}else {
			out.println("Invalid username and password.");
			out.println("<p><a href='login.html'>Go to login page</a></p>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
