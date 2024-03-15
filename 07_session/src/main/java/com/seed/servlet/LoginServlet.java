package com.seed.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		userService  = new UserServiceImpl((Connection) getServletContext().getAttribute("connection"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");

		if(userService.isValidUser(username, password)) {
			HttpSession session = request.getSession(); //if session is not created then it will create the new session object else it will use existing one
			//HttpSession session  = request.getSession(true); //if true then create the new session, if false then give the existing session. if existing session is not available then return null
			System.out.println("sessiion: "+session);
			
			User user = userService.getUser(username);
			session.setAttribute("user", user);
			
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
