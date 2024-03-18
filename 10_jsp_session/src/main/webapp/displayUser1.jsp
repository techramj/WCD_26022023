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
	<h3 align="center">User Details</h3>
	<jsp:useBean id="user" class="com.seed.entity.User"  scope="request">
	</jsp:useBean>
	
	<p>First Name: <jsp:getProperty property="firstName" name="user"/></p>
	<p>Last Name: <jsp:getProperty property="lastName" name="user"/></p>
	<p>User Name: <jsp:getProperty property="username" name="user"/></p>
	<p>Password: <jsp:getProperty property="password" name="user"/></p>
	<p>Email: <jsp:getProperty property="email" name="user"/></p>

</body>
</html>