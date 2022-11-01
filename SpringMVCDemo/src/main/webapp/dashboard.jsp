<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
  <%--   <%@  %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Dashboard</h1>
<%
String email=(String)request.getAttribute("useremail");
%><h1>Welcome  <%=email %></h1>
</body>
</html>