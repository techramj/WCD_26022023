<%@page import="com.seed.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String username =request.getParameter("username");
	String password =request.getParameter("password");
	String fname =request.getParameter("firstName");
	String lname =request.getParameter("lastName");
	String email =request.getParameter("email");
	
	User user = new User();
	user.setFirstName(fname);
	user.setLastName(lname);
	user.setPassword(password);
	user.setEmail(email);
	user.setUsername(username);
	
	request.setAttribute("user", user);
	
	RequestDispatcher rd = request.getRequestDispatcher("displayUser.jsp");
	rd.forward(request, response);

%>

</body>
</html>