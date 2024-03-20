<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<p> Welcome</p>

<c:import  var="footer" url="footer.jsp"></c:import>
<c:out value="${footer }"/>

<% request.setAttribute("a", 5000); %>
<c:set var="a" scope="request" value="4000"/>

<c:forEach var="i" begin="1"  end="10">
	<p>${i }</p>
</c:forEach>
<hr/>
<% for(int i =1;i<=10; i++) { %>
	<p><%=i %></p>
<%} %>

<%
	
List<String> friends = new ArrayList<>();
friends.add("jack");
friends.add("john");
friends.add("sam");

request.setAttribute("friends", friends);
%>

<c:forEach var="friend" items="${friends }" >
	<ol>${friend }</ol>
</c:forEach>



<p>${friends.size() >2 }</p>

<c:if test="${friends.size() >3 }">
	<p>Hello</p>
</c:if>

</body>
</html>