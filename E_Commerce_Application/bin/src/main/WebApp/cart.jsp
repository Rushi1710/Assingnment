<%@page import="com.boot.application.entity.ProductItems"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Buy products</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<%
	ProductItems productItems = (ProductItems) request.getAttribute("product");
	if (productItems != null) {
	%>
	<div class="w3-container">
		<h2
			style="color: red; font-style: italic; align-content: center; text-align: center;">Cart
			Iteams</h2>
		<div class="w3-responsive">
			<table class="w3-table-all">
			<caption>This is cart jsp file . In this File i have to perform Buy and AddCart opration</caption>
				<tr>
					<th>Image</th>
					<th>Product Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Edit</th>
				</tr>
				<tr>
					<td><img class=""
						src="../productimages/<%=productItems.getImage()%>"
						alt="Card image cap" width="200px" height="200px"></td>
					<td><%=productItems.getProductName()%></td>
					<td><%=productItems.getDescription()%></td>
					<td><%=productItems.getPrice()%></td>


					<td><button onclick="deleteIteam()" style="color: red;">Delete
							Iteam</button>
						<button class="btn btn-primary" type="submit">
							<a style="color: white"
								onclick="buyNow(<%=productItems.getProductId()%>,'<%=productItems.getProductName()%>')">Buy
								Now</a>
						</button>
					<td></td>

				</tr>

			</table>

		</div>
	</div>
	<%
	} else {
	String error = "empty cart";
	%>
	<h1><%=error%></h1>
	<%
	}
	%>


	<script type="text/javascript">
		function buyNow(pid, name1) {

			console.log("name is :" + name1)
			if (name1 != "null" && name1 != "") {
				var url = new URL(
						"http://localhost:8082/customer/buy?product_id=");
				url.searchParams.set('product_id', pid);
				window.location.href = url;
			} else {

				window.location.replace("http://localhost:8082/customer/login")
			}

		}
	
</script>
	</ body>
</html>

