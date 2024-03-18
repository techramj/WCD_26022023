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
	/*
	String password =request.getParameter("password");
	
	String lname =request.getParameter("lastName");
	String email =request.getParameter("email");
	
	//<jsp:useBean id="user" class="com.seed.entity.User"  scope="request">
	User user = new User();
	request.setAttribute("user", user);
	
	//<jsp:setProperty property="username" name="user" param="userName" >
	String username =request.getParameter("username");
	user.setUsername(username);
	
	//<jsp:setProperty property="firstName" name="user" param="firstName" >
	String fname =request.getParameter("firstName");
	user.setFirstName(fname);
	
	user.setLastName(lname);
	user.setPassword(password);
	user.setEmail(email);
	user.setUsername(username);
	
	
	
	RequestDispatcher rd = request.getRequestDispatcher("displayUser.jsp");
	rd.forward(request, response);
	*/

%>

<jsp:useBean id="user" class="com.seed.entity.User"  scope="request">
	<jsp:setProperty property="username" name="user" param="username" />
	<jsp:setProperty property="firstName" name="user" param="firstName" />
	<jsp:setProperty property="lastName" name="user" param="lastName" />
	<jsp:setProperty property="email" name="user" param="email" />
	<jsp:setProperty property="password" name="user" param="password" />
</jsp:useBean>

<jsp:forward page="displayUser1.jsp"></jsp:forward>

</body>
</html>