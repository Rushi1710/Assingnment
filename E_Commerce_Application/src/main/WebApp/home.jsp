<!DOCTYPE html>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.boot.application.entity.ProductItems"%>
<%@page import="java.util.List"%>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link href="../css/style.css" rel="stylesheet">

<title>Document</title>
<style>
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #e9e9e9;
}

.topnav a {
	float: left;
	display: block;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #2196F3;
	color: white;
}

.topnav .login-container {
	float: right;
}

.topnav input[type=text] {
	padding: 6px;
	margin-top: 8px;
	font-size: 17px;
	border: none;
	width: 120px;
}

.topnav .login-container button {
	float: right;
	padding: 6px 10px;
	margin-top: 8px;
	margin-right: 16px;
	background-color: #555;
	color: white;
	font-size: 17px;
	border: none;
	cursor: pointer;
}

.topnav .login-container button:hover {
	background-color: green;
}

@media screen and (max-width: 600px) {
	.topnav .login-container {
		float: none;
	}
	.topnav a, .topnav input[type=text], .topnav .login-container button {
		float: none;
		display: block;
		text-align: left;
		width: 100%;
		margin: 0;
		padding: 14px;
	}
	.topnav input[type=text] {
		border: 1px solid #ccc;
	}
}
</style>
</head>

<body>
	<%
	String name = (String) session.getAttribute("name");

	List<ProductItems> product = (List<ProductItems>) request.getAttribute("productList");
	%>

	<div class="topnav">

		<div>
			<a class="active" >Home</a> <a
				class="active">About</a> <a class="active" href="contact">Contact</a>
			<a class="active" href="cart1">Cart</a>
		</div>


		<form action="SearchProduct" method="POST" id="search-form">
			<input type="search" id="input-search" placeholder="Search.."
				name="search">
			<button type="submit" id="search-product">search</button>
		</form>
		<%
		if (name == null) {
		%>

		<div class="login-container">
			<a class="nav-link active " href="login"><span
				class="fa fa-user-circle"></span> Login</a> <a class="nav-link active "
				href="registration"><span class="fa fa-user-circle"></span>
				registration</a>

		</div>
		<%
		} else {
		%>
		<div class="login-container">
			<h3 id="username">
				Welcome
				<%=name%></h3>
			<a class="nav-link active " href="logout"><span
				class="fa fa-user-circle"></span>Log Out</a>

		</div>
		<%
		}
		%>
	</div>


	<div class="container-fluid" id="product-container">
		<div class="row">
			<%
			for (ProductItems iteam : product) {
			%>
			<div class="col-12">

				<div class="card mt-3">
					<div class="card-horizontal">
						<div class="img-square-wrapper">
							<img class="" src="../productimages/<%=iteam.getImage()%>"
								alt="Card image cap" width="200px" height="200px">
						</div>
						<div class="card-body">
							<h4>
								<%=iteam.getProductName()%>
							</h4>
							<small class="card-title"> <%=iteam.getDescription()%></small>

							<h4 class="card-text">
								price:<%=iteam.getPrice()%>
							</h4>
							<div>
								<button class="btn btn-primary" type="submit">
									<a style="color: white"
										onclick="addCart(<%=iteam.getProductId()%>)">Add To
										Cart</a>
								</button>


								<button class="btn btn-primary" type="submit">
									<a style="color: white"
										onclick="buynow(<%=iteam.getProductId()%>)">Buy Now</a>
								</button>
							</div>
						</div>
					</div>

				</div>

			</div>

			<%
			}
			%>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<script>
	
		$('#search-form').on('submit',function(event){
			console.log("Submit button clicked");
			event.preventDefault();
			let prodname=$('#input-search').val();	
			let searchval={
			"productName":prodname
			}
		 	$.ajax({
				type:"POST",
				contentType : 'application/json; charset=utf-8',
				 dataType : 'json',
				url:'search',  
				 data:JSON.stringify(searchval),
				 success:function(result){
					 console.log(result);
					   $('#product-container').html('');
					 $.each(result,function(index,item){
						 let htmlVar ='<div class="card shadow  mb-2 bg-white rounded h-8">'+
							'<div class="row no-gutters">'+
							'<div class="col-sm-3" style="border-right: 2px solid blue;">'+
								'<img class="card-img-top img-fluid my-2" src="../productimages/'+item.image+'" alt="Suresh Dasari Card" style="height: 200px; width: 350px;"/>'+
							'</div>'+
						'<div class="col-sm-9">'+
								'<div class="card-body" style="height: 180px">'+
									'<h5 class="card-title">'+item.productName+'</h5>'+
									'<p class="card-text">'+item.description +'</p>'+
									'<h3 class="card-text">'+item.price +'</h3>'+
							'</div>'+
								'<div class="card-footer" style="border: 0;">'+
								'<div class="text-right">'+
								
								
								'<a  class="btn btn-primary" id="addCart" onclick="addCart('+item.productId+')">Add to Cart</a>'+ 
										'<a " class="btn btn-danger mx-2"   onclick="buynow('+item.productId+')" >Buy Now</a>'+
									'</div>'+
								'</div>'+
							'</div>'+
						'</div>'+
					'</div>'
					;
						 $('#product-container').append(htmlVar);
					 })	   
				 },
				 error: function(xhr, status, error) {
					console.log(error)
					
				   },	
			}) 
			
		})
		

	
	
	function buynow(pid){
		let name=$('#username').text();
		console.log(name);
		if(name!= "null" && name != ""){
			var url = new URL("http://localhost:8082/customer/buy?product_id=");
			url.searchParams.set('product_id',pid);
			window.location.href=url;
		}else{
			 alert("Without login you Can not Buy any product !");
			window.location.replace("http://localhost:8082/customer/login")
		}
		
    }
	
	
	 function addCart(pid){	
		 let name=$('#username').text();
		console.log(name);
		if(name != "null" && name != ""){
		var url = new URL("http://localhost:8082/customer/cart?product_id=");
		url.searchParams.set('product_id',pid);
		window.location.href=url;
		alert("product added succesfully in cart");
		}else{
			alert("Without login you Can not Add product to Cart!");
			 window.location.replace("http://localhost:8082/customer/login") 
		} 
    } 
</script>

</body>
</html>