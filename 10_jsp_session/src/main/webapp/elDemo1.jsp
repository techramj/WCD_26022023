<%@page import="com.seed.entity.LandMark"%>
<%@page import="com.seed.entity.Address"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
 request.setAttribute("a", "apple");
 Address address = new Address();
 address.setCity("Pune");
 request.setAttribute("address", address);
%>

<p> A: <%= request.getAttribute("a") %> </p>
<p> B: <%= request.getAttribute("b") == null?"":request.getAttribute("b") %> </p>
<p> City: 
<%
  Address add = (Address)request.getAttribute("address");
  String city = add.getCity();
  LandMark lm = add.getLandmark();
  out.println(city);
  if(lm!= null){
  	out.println(lm.getLane());
  }
%>
</p>

<hr>
<p> A: ${a } </p>
<p> B: ${b } </p>
<p> City: ${address.city }
<p> Lane: ${address.landmark.lane }</p>
</body>
</html>