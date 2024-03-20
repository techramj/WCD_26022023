<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%
    
    	//HttpSession session = request.getSession();  //session is implicit object
    	session.setAttribute("driver", "oracle.jdbc.driver.OracleDriver");
    	Cookie cookie1 = new Cookie("hostname", "localhost");
    	response.addCookie(cookie1);
    	
    %>
	<form action="loginSuccess.jsp" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit">Login</button></td>
			</tr>
		</table>
	</form>
</body>
</html>