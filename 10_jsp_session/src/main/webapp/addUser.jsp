<%@page import="com.seed.entity.User"%>
<%@page import="com.seed.service.UserServiceImpl"%>
<%@page import="com.seed.service.UserService"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.seed.service.EmpServiceImpl"%>
<%@page import="com.seed.service.EmpService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" %>
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
	
	//EmpService empService = new EmpServiceImpl((Connection)application.getAttribute("connection"));
	UserService userService = new UserServiceImpl((Connection)application.getAttribute("connection"));
	userService.addUser(user);
%>

<%= "User added successfully!!!" %>
</body>
</html>