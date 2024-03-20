<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%
    	pageContext.setAttribute("driver","mysql driver");
    	request.setAttribute("driver", "postgre driver");
    %>
	UserName: <%= request.getParameter("username") %><br>
	Name: <%= request.getParameter("name") %><br>
	Driver: <%= session.getAttribute("driver") %>
	<%
		Cookie[] carr= request.getCookies();
	    for(Cookie c:carr){
	    	if(c.getName().equals("hostname")){
	    		out.println("<p>Host Name:"+ c.getValue()+" </p>");
	    	}
	    }
	    
	    int a =10;
	
	%>
	<hr>
	User name: ${param.username } <br>
	Name : ${param.name } <br>
	Driver: ${sessionScope.driver } <br>
	Driver: ${driver }  <!-- pageContext -> request -> session -> application -->
	<p>Driver from request: ${requestScope.driver }</p>
	<p>Host Name: ${cookie.hostname.value }
	<p>Sum = ${10 +20 }</p>
	<p>${10>20 }</p>
</body>
</html>