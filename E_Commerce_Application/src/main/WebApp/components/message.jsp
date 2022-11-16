<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<%  String msg=(String)request.getParameter("msg");
if(msg!=null){
	%>
	
	
	
	
	
	<div class="alert alert-success alert-dismissible fade show" role="alert">
  <strong><%=msg %>!</strong> 
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
	
	
	
	
	
	
	
	<% 
}
%>
</body>
</html>