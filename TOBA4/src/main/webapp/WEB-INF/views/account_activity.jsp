<%@page import="com.toba.banking.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.html"/>
<% User user = (User) session.getAttribute("user"); 
	if(user==null){
%>
<h2>Not Logged In</h2>
<% } else {%>
<table>
	<tr>
		<td>Firstname</td>
		<td><%= user.getFirstname() %></td>
	</tr>
	<tr>
		<td>Lastname</td>
		<td><%= user.getLastname() %></td>
	</tr>
</table>
<% } %>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>