<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Hello Friend</p>
	<br>
	<table border="1">
	<%
		for(int i=0;i<=10;i++){
			out.println("<tr><td>"+i+"</td></tr>");
		}
	%>
	</table>
	
	<hr>
	<table border="1">
		<%for(int i=0;i<=10;i++){ %>
		<tr><td><%=i %></td></tr>
		<%} %>
	</table>
</body>
</html>