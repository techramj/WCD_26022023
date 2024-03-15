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

/**
 * Servlet implementation class FriendServlet
 */
@WebServlet("/friend")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		userService  = new UserServiceImpl((Connection) getServletContext().getAttribute("connection"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession(false);
		User user = (User) session.getAttribute("user");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h5 align='right'><a href='logout'>Logout</a></h5");
		out.println("<h4>Friend of "+user.getFirstName()+" "+user.getLastName()+" is ");
		for(String s:userService.getFriends(user.getUsername())) {
			out.println("<ol>"+s+"</ol>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
