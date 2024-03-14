package com.seed.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seed.entity.User;

/**
 * Servlet implementation class FriendServlet
 */
@WebServlet("/friend")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String username = request.getParameter("username");
		
		String username = "";
		String firstName = "";
		String lastName = "";
		Cookie[] cookies = request.getCookies();
		for(Cookie c:cookies) {
			if(c.getName().equals("username")) {
				username = c.getValue();
			}
			
			if(c.getName().equals("firstName")) {
				firstName = c.getValue();
			}
			
			if(c.getName().equals("lname")) {
				lastName = c.getValue();
			}
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h4>Friend of "+ firstName +" "+  lastName +" is ");
		out.println("</body>");
		out.println("</html>");
	}

}
