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
	<jsp:setProperty property="*" name="user" />
</jsp:useBean>

<jsp:forward page="displayUser1.jsp"></jsp:forward>

</body>
</html>