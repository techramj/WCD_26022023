<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%! int a= 10;  %>

<p><%= "Hello world" %></p>
<p>${"hello world" }</p>
<p><c:out value="${'hello world' }" /> </p>
<p>a= <%=a %></p>
<p>a= ${a }</p>
<!--<p>a= <c1:out value='a' /> </p>  need to check-->

</body>
</html>