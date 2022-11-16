<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Login</h1>
	<%
	String error = (String) request.getAttribute("error");
	%>
	<%
	if (error != null) {
	%>
	<h1 class="error"><%=error%></h1>
	<%
	}
	%>
	<form action="login" method="post">
		<input name="userName" type="text" placeholder="username"> <input
			name="password" type="password" placeholder="password"> <input
			type="submit">
	</form>

</body>
</html> --%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Page</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

form {
	border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.imgcontainer {
	text-align: center;
	width: 100px;
	height: 100px;
	text-align: center;
}

img.avatar {
	width: 80%;
	border-radius: 100%;
}

.container {
	padding: 10px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>
<body>

	<h2>Login Form</h2>
	<%
	String error = (String) request.getAttribute("error");
	%>
	<%
	if (error != null) {
	%>
	<h1 class="error"><%=error%></h1>
	<%
	}
	%>
	<form action="login" method="post">
		<div class="imgcontainer">
			<img src="/images/img_avatar2.png" alt="Avatar" class="avatar">
		</div>

		<div class="container">
			<label for="uname"><strong>Username</strong></label> <input type="text"
				placeholder="Enter Username" name="userName" required> <label
				for="psw"><strong>Password</strong></label> <input type="password"
				placeholder="Enter Password" name="password" required>
			<button type="submit">Login</button>
		</div>
		<div class="container" style="background-color:#f1f1f1">
    <a href="registration" class="cancelbtn" >registration</a>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
	</form>

</body>
</html>
