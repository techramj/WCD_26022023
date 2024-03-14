package com.seed.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seed.entity.User;
import com.seed.util.ConnectionUtil;

public class RegisterServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		String driver = context.getInitParameter("jdbc.driverClass");
		String url = context.getInitParameter("jdbc.url");
		String username = context.getInitParameter("jdbc.username");
		String password = context.getInitParameter("jdbc.password");
		
		Connection con = ConnectionUtil.getConnection(driver, url, username, password);
		context.setAttribute("connection", con);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId =Integer.parseInt(request.getParameter("userId"));
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		String fname =request.getParameter("firstName");
		String lname =request.getParameter("lastName");
		String email =request.getParameter("email");
		
		User user = new User();
		user.setUserId(userId);
		user.setFirstName(fname);
		user.setLastName(lname);
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		try {
			addUser(user);
			
			out.println("<h3>User added successfully!!!!!");
			out.println("<h4>User Details</h4>");
			out.println("<p>Username: "+username+"</p>");
			out.println("<p>First Name: "+fname+"</p>");
			out.println("<p>Last Name: "+lname+"</p>");
			out.println("<p>Email: "+email+"</p>");
			out.println("<br><a href='login.html'>Click here for Login</a>");
			
		} catch (SQLException e) {
			out.println("<p>Something gone wrong, please try again</p>");
			out.println("<br><a href='registration.html'>Click here for Register</a>");
			e.printStackTrace();
		}
		
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
	
	public void addUser(User user) throws SQLException{
		Connection con = (Connection) getServletContext().getAttribute("connection");
		String sql = "insert into users(user_id, first_name, last_name, email, username, password) values(?,?,?,?,?,?)";
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getUsername());
			ps.setString(6, user.getPassword());
			ps.executeUpdate();
		}
		
	}

}
