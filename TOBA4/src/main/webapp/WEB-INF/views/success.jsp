<%@page import="com.toba.banking.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error_java.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.html"/>
<% User user = (User) session.getAttribute("user"); %>
	<h1>The account has been successfully created</h1>
	<h2>User Details</h2>
	<table>
		<tr>
			<td>Username</td>
			<td><%= user.getUsername() %>
		</tr>
		<tr>
			<td>Password</td>
			<td><%= user.getPassword() %>
		</tr>
		<tr>
			<td>Firstname</td>
			<td><%= user.getFirstname() %>
		</tr>
		<tr>
			<td>Lastname</td>
			<td><%= user.getLastname() %>
		</tr>
		<tr>
			<td>Phone</td>
			<td><%= user.getPhone() %>
		</tr>
		<tr>
			<td>Address</td>
			<td><%= user.getAddress() %>
		</tr>
		<tr>
			<td>City</td>
			<td><%= user.getCity() %>
		</tr>
		<tr>
			<td>State</td>
			<td><%= user.getState() %>
		</tr>
		<tr>
			<td>Zipcode</td>
			<td><%= user.getZipcode() %>
		</tr>
		<tr>
			<td>Email</td>
			<td><%= user.getEmail() %>
		</tr>
	</table>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>