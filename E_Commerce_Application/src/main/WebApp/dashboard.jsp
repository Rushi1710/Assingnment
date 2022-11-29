<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	String name = (String) session.getAttribute("name");
	%>
	<h1>
		Welcome
		<%=name%>
		Your order is placed Successfully
	</h1>
	<h1>
		<a href="home">Home Page</a>
	</h1>

</body>
</html>