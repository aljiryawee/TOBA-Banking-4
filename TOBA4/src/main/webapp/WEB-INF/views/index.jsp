<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center><h1>TOBA Titan Online Banking Application</h1></center>
<hr>

<%
int status = response.getStatus();
if(status==400)
{
%>
<h3>Username and Password is invalid</h3>
<%
}
%>
<table>
	<tr>
		<td>Login <a href="login">Here</a>
	</tr>
	<tr>
		<td>New Customer <a href="newCustomer">Here</a>
	</tr>
</table>

</body>
</html>