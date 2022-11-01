<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Register</h1>
	<% String error = (String)request.getAttribute("errormsg"); %>
	<% if(error != null){
	%>	<h1><%=error %></h1>
	<%
	}
	%>
	<form action="register" method="post">
		<input name="userId" type="text" placeholder="UserName"> 
		<input name="userEmail" type="email" placeholder="E-mail"> 
		<input name="userPassword" type="password" placeholder="password"> 
		<input type="submit" value="Submit">
	</form>

</body>
</html>