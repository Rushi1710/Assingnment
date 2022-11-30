<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
	color: red;
}

/* body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: black;
}

* {
	box-sizing: border-box;
}

/* Add padding to containers */
.container {
	padding: 16px;
	background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
	background-color: #04AA6D;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}

/* Add a blue text color to links */
a {
	color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
	background-color: #f1f1f1;
	text-align: center;
}
*
/
</style>
</head>
<body>

	<%-- <%
	String error = (String) request.getAttribute("error1");
	%>
	<%
	if (error != null) {
	%>
	<h3 style="color: red"><%=error%></h3>
	<%
	}
	%> --%>

	<%
	if ((String) request.getParameter("error") != null) {
		String msg = (String) request.getParameter("error");
	%><h4 style="color: red"><%=msg%></h4>
	<%
	}
	%>


	<%-- <form action="registration" method="post" id="reg-form">
		<div class="container">
			<h1>Register</h1>
			<p>Please fill in this form to create an account.</p>
			<hr>

			<label for="email"><strong>Email</strong></label> <input type="text"
				class="form-control" placeholder="Enter Email" name="email"
				id="email" required onkeyup="return emailValidation()"> <span
				id="email-error"></span> <br> <label for="psw"><strong>Password</strong></label>
			<input type="password" placeholder="Enter Password" name="password"
				id="psw" required> <label for="name"><strong>Full
					Name</strong></label> <input type="text" placeholder="Enter Name" name="name"
				id="psw-repeat" required> <label for="UserName">
				<p id="fullname" style="display: none;" class="error">Only
					Letters allowed</p> <strong>User Name (*)</strong>
			</label> <input type="text" placeholder="Enter UserName" name="userName"
				path="userName" id="psw-repeat">
			<form:errors path="userName" cssClass="error" />


			<label for="contact"><strong>Mobile No</strong></label> <input
				type="text" placeholder="Enter Mobile Number" name="contact"
				id="psw-repeat" pattern="[0-9]{10}"
				title="Ten digit number enter not added etra symbole" required>
			<label for="location"><strong>Location</strong></label> <input
				type="text" placeholder="Enter location" name="location"
				id="psw-repeat" required>

			<hr>
			<button type="submit" class="registerbtn">Register</button>
		</div>

		</form>
 --%>


	<form:form action="registration" id="customer"
		modelAttribute="customerDto" method="POST">

		<h1>Registration</h1>
		<br>
		Email (*): <form:input type="email" path="email" id="email"
			onkeyup="emailValidation()" required="required" />
		<span id="email-error"></span>
		<form:errors path="email" cssClass="error" />
		<br>
		<br>
		
		User Name (*): <form:input type="text" path="userName" id="userName"
			required="required" />
		<form:errors path="userName" cssClass="error" />

		<br>
		<br>
		
		Phone number (*): <form:input type="text" path="contact" id="contact"
			onkeyup="mobileNumber_Validation()" required="required" />
		<span id="contact-error"></span>
		<form:errors path="contact" cssClass="error" />

		<br>
		<br>
		
		Full name (*): <form:input type="text" path="name" id="name"
			onkeyup="name_Validation()" required="required" />
		<span id="name-error"></span>
		<form:errors path="name" cssClass="error" />

		<br>
		<br>
		
		Password (*): <form:input type="text" path="password"
			required="required" />
		<form:errors path="password" cssClass="error" />

		<br>
		<br>
		
		
		Address (*): <form:input type="text" path="location"
			required="required" />
		<form:errors path="location" cssClass="error" />

		<br>
		<br>

		<input type="submit" value="Submit" />

	</form:form>

	<script>
	
	function emailValidation()
	{
	  value = document.getElementById('email').value;
	  apos=value.indexOf("@"); console.log("@ = "+apos);
	  dotpos=value.lastIndexOf("."); console.log("lastIndexOfdot = "+dotpos);
	  lastpos=value.length-1;console.log("lastpos"+lastpos);
	  if (apos < 1 || dotpos-apos < 2 || lastpos-dotpos > 3 || lastpos-dotpos < 2){
		  document.getElementById("email-error").style.color = "red";
	      document.getElementById("email-error").innerHTML = "Invalid Email Address";
	      return false;
	    } else {
	    	  document.getElementById("email-error").style.color = "green";
	          document.getElementById("email-error").innerHTML = "Valid Email Address";
	      return true;
	  }
	}

	
	
	function name_Validation(){
		
	    var regName = /^[a-zA-Z]+ [a-zA-Z]+$/; 
	    var regName1=/^[A-Za-z]+/;
	    var name = document.getElementById('name').value;
	    
	/*     if(!(regName.test(name)||regName1.test(name))|| name==="") */
	    
	    if(onlyLetters(name))
	    {
	    	document.getElementById('name-error').style.color = 'red';
			document.getElementById('name-error').innerHTML = 'Please Enter Your Full Name (first & last name) Without Any Number';
	        return false;
	    }else{
	    	console.log('reg match')
	    	document.getElementById('name-error').style.color = 'green';
			document.getElementById('name-error').innerHTML = 'Your Name Is Matched';
	        return true;
	    }
	}
	
	function onlyLetters(Name) {
		var regx = /^[a-zA-Z][a-zA-Z ]*$/;
		return !regx.test(Name);
	}
	
	function mobileNumber_Validation(){
	    var regName=/^\d{10}$/;
	    var number=document.getElementById('contact').value;
	  
	    if(!(regName.test(number))){
	    	document.getElementById('contact-error').style.color='red';
	    	document.getElementById('contact-error').innerHTML='Please Enter Valid Number';
	    	return false;
	    }else
	    
	    {
	    	document.getElementById('contact-error').style.color='green';
	    	document.getElementById('contact-error').innerHTML='valid number';
	    	return true;
	       }
	}
		
	</script>
</body>
</html>

