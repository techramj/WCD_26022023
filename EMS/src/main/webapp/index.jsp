<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMS</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form action="login" method="post">
		    <div>
		        <c:if test="${errorMessage != null }">
		        	<span>${errorMessage }</span>
		        </c:if>
		    </div>
			<div class="form-group">
				<label for="username">Username</label> 
				<input type="text" class="form-control" name="username"> 
			</div>
			<div class="form-group">
				<label for="password">Password</label> 
				<input type="password" class="form-control" name="password">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="registration.html">New User</a>
		</form>
	</div>
</body>
</html>