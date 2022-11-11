<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Login</h1>
	<%
	String error = (String) request.getAttribute("errormsg");
	%>
	<%
	if (error != null) {
	%>
	<h1 class="error"><%=error%></h1>
	<%
	}
	%>
	<form action="login" method="post">
		<input name="username" type="text" placeholder="username"> <input
			name="password" type="password" placeholder="password"> <input
			type="submit">
	</form>

</body>
</html>