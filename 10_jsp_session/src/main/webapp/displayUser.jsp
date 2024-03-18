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
  User user = (User)request.getAttribute("user");
  //out.println("<p>First Name: "+user.getFirstName()+"</p>");
  out.println("User Details: ");
%>
<p>First Name: <%= user.getFirstName() %></p>
<p>Last Name: <%= user.getLastName() %></p>
<p>User Name: <%= user.getUsername() %></p>
<p>Password: <%= user.getPassword() %></p>
<p>Email: <%= user.getEmail() %></p>

</body>
</html>