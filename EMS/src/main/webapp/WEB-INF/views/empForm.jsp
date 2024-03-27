<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container">
		<form action="edit" method="post">
			<div>
				<c:if test="${errorMessage != null }">
					<span>${errorMessage }</span>
				</c:if>
			</div>
			<div class="form-group">
				<label for="firstName">First name</label> 
				<input type="text" class="form-control" name="firstName" value="${emp.firstName }">
			</div>
			<div class="form-group">
				<label for="LastName">Last Name</label> 
				<input type="text" class="form-control" name="lastName" value="${emp.lastName }">
			</div>
			<div class="form-group">
				<label for="salary">Salary</label> 
				<input type="number" class="form-control" name="salary" value="${emp.salary }">
			</div>
			<div class="form-group">
				<label for="department">Department</label> 
				<select  class="form-control" name="department">
					<c:forEach var="dept" items="${departments }" >
					    <c:if test="${dept == emp.department }">
					    	<option value="${dept }" selected="selected">${dept }</option>
					    </c:if>
					    <c:if test="${dept != emp.department }">
					    	<option value="${dept }">${dept }</option>
					    </c:if>
					</c:forEach>
				</select>
			</div>
			
			<div>
				<input type="hidden" class="form-control" name="id" value="${emp.id }">
			</div>
			
			<button type="submit" class="btn btn-primary">Update Employee Details</button>
		</form>
	</div>
	
	<%@ include file="footer.jsp" %>
</body>
</html>