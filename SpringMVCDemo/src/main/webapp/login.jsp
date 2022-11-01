<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <style type="text/css">
.error {
	color: blue;
}
</style> -->
</head>
<body>
	<h1>Login</h1>
	<% String error = (String)request.getAttribute("errormsg"); %>
	<% if(error != null){
	%>	<h1><%=error %></h1>
	<%
	}
	%>
	<form action="login" method="post">
		<input name="userEmail" type="email" placeholder="E-mail"> <input
			name="userPassword" type="password" placeholder="password"> <input
			type="submit">
	</form>

</body>
</html>