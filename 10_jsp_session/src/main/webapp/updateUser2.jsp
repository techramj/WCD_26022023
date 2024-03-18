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


<jsp:useBean id="user" class="com.seed.entity.User"  scope="request">
	<jsp:setProperty property="username" name="user" />
	<jsp:setProperty property="firstName" name="user"  />
	<jsp:setProperty property="lastName" name="user"  />
	<jsp:setProperty property="email" name="user"  />
	<jsp:setProperty property="password" name="user" />
</jsp:useBean>

<jsp:forward page="displayUser1.jsp"></jsp:forward>

</body>
</html>