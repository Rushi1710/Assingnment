<%@page import="com.boot.application.entity.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<title>profile page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

/* Style inputs */
input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=submit] {
	background-color: #04AA6D;
	color: white;
	padding: 12px 20px;
	border: none;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

/* Style the container/contact section */
.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 10px;
}

/* Create two columns that float next to eachother */
.column {
	float: left;
	width: 50%;
	margin-top: 6px;
	padding: 20px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
	.column, input[type=submit] {
		width: 100%;
		margin-top: 0;
	}
}
</style>
</head>
<body>

	<%
	Customer customer = (Customer) request.getAttribute("customer");
	%>
	<h1></h1>

	<%-- 
	<div class="container">
		<div style="text-align: center">
			<h2>Customer Info</h2>

		</div>
		<div class="row">
			<div class="column">
				<img src="/images/img_avatar2.png" alt="profile symbol"
					style="width: 50%;">
			</div>
			<div class="column">
				<form action="/action_page.php">
					<label for="fname">Full Name</label> <input type="text" id="fname"
						name="firstname" value="<%=customer.getName()%>"> <label
						for="email">Email</label> <input type="email" id="email"
						name="lastname" value="<%=customer.getEmail()%>"> <br>
					<br> <label for="usernName">User Name </label> <input
						type="text" id="userName" name="UserName"
						value="<%=customer.getUserName()%>"> <br> <br> <label
						for="address">Address</label><input type="text" id="location"
						name="lastname" value="<%=customer.getLocation()%>"> <br>
					<br> <label for="contact">Phone No</label> <input type="text"
						id="contact" name="contact" value="<%=customer.getContact()%>">

					<input type="submit" value="Edit">
				</form>
			</div>
		</div>
	</div> --%>

	<h3 style="color: black; text-align: center;">Customer Profile ..</h3>
	<form action="update" method="post" id="reg-form">
		<div class="container">
			<hr>

			<label for="email"><strong>Email</strong></label> <input type="text"
				class="form-control" value="<%=customer.getEmail()%>" name="email"
				id="email" required onkeyup="return emailValidation()"> <span
				id="email-error"></span> <br> <label for="name"><strong>Full
					Name</strong></label> <input type="text" value="<%=customer.getName()%>" name="name"
				id="psw-repeat" required> <label for="UserName"> <strong>User
					Name </strong>
			</label> <input type="text" value="<%=customer.getUserName()%>"
				readonly="readonly" name="userName" id="psw-repeat"> <label
				for="contact"><strong>Mobile No</strong></label> <input type="text"
				value="<%=customer.getContact()%>" name="contact" id="psw-repeat"
				pattern="[0-9]{10}"
				title="Ten digit number enter not added etra symbole" required>

			<label for="location"><strong>Location</strong></label> <input
				type="text" value="<%=customer.getLocation()%>" name="location"
				id="psw-repeat" required> <label for="password"><strong>Password</strong></label>
			<input type="text" value="<%=customer.getPassword()%>"
				name="password" id="psw-repeat" required>

			<hr>
			<button type="submit" class="registerbtn">Edit</button>
		</div>

	</form>



</body>
</html>