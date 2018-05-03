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
	<jsp:include page="/WEB-INF/views/header.html" />
	<%
		User user = (User) session.getAttribute("user");
		String password = user.getPassword();
		if (user == null) {
	%>
	<h3>No user logged in.</h3>
	<%
		}
	%>
	<h1>Reset password</h1>
	<form action="${pageContext.request.contextPath}/passwordReset"
		method="get">
		<table>
			<tr>
				<td>New Password</td>
				<td><<input type="text" class="form-control" name="password"
					value="${user.password}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit"
					value="submit"></td>
			</tr>
		</table>
	</form>
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>