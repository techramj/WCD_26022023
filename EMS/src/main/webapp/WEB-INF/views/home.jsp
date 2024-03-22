<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
	<h5 align="right"><a href="logout">Logout</a></h5>
	<h3 align="center">Employee Details</h3>

	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Salary</th>
				<th scope="col">Department</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${employees }">
				<tr>
					<td>${emp.firstName }</td>
					<td>${emp.lastName }</td>
					<td>${emp.salary }</td>
					<td>${emp.department }</td>
					<td><a href="edit?id=<c:out value = '${emp.id }' />">Edit</a> <a href="delete?id=<c:out value = '${emp.id }' />">Delete</a> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>