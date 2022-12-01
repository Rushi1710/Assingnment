<%@page import="com.boot.application.entity.Order"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Order Page</title>
<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous" />
<!-- Our Custom CSS -->
<link rel="stylesheet" href="/css/style1.css">
<link rel="text/javascript" href="/js/index.js">

<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
	integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
	integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
	crossorigin="anonymous"></script>
<style>
.card-img-top {
	object-fit: contain;
}

/* style for order details */
.card-stepper {
	z-index: 0
}

#progressbar-2 {
	color: #455A64;
}

#progressbar-2 li {
	list-style-type: none;
	font-size: 13px;
	width: 33.33%;
	float: left;
	position: relative;
}

#progressbar-2 #step1:before {
	content: '\f058';
	font-family: "Font Awesome 5 Free";
	color: #fff;
	width: 37px;
	margin-left: 0px;
	padding-left: 0px;
}

#progressbar-2 #step2:before {
	content: '\f058';
	font-family: "Font Awesome 5 Free";
	color: #fff;
	width: 37px;
}

#progressbar-2 #step3:before {
	content: '\f058';
	font-family: "Font Awesome 5 Free";
	color: #fff;
	width: 37px;
	margin-right: 0;
	text-align: center;
}

#progressbar-2 #step4:before {
	content: '\f111';
	font-family: "Font Awesome 5 Free";
	color: #fff;
	width: 37px;
	margin-right: 0;
	text-align: center;
}

#progressbar-2 li:before {
	line-height: 37px;
	display: block;
	font-size: 12px;
	background: #c5cae9;
	border-radius: 50%;
}

#progressbar-2 li:after {
	content: '';
	width: 100%;
	height: 10px;
	background: #c5cae9;
	position: absolute;
	left: 0%;
	right: 0%;
	top: 15px;
	z-index: -1;
}

#progressbar-2 li:nth-child(1):after {
	left: 1%;
	width: 100%
}

#progressbar-2 li:nth-child(2):after {
	left: 1%;
	width: 100%;
}

#progressbar-2 li:nth-child(3):after {
	left: 1%;
	width: 100%;
	background: #c5cae9 !important;
}

#progressbar-2 li:nth-child(4) {
	left: 0;
	width: 37px;
}

#progressbar-2 li:nth-child(4):after {
	left: 0;
	width: 0;
}

#progressbar-2 li.active:before, #progressbar-2 li.active:after {
	background: #6520ff;
}
</style>
</head>

<body>
	<div class="wrapper">

		<nav id="sidebar" aria-labelledby="sidebar-header">
			<div class="sidebar-header">
				<h3>Ecommerce Application</h3>
			</div>

			<ul class="list-unstyled components">
				<p class="font-weight-normal">Main Menu</p>
				<li><a href="http://localhost:8082/customer/home">Home</a></li>
				<li><a href="#">About</a></li>
				<li><a href="/customer/profile">profile</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
		</nav>

		<div class="content">
			<%
			List<Order> order = (List<Order>) request.getAttribute("orders");
			String userName = (String) session.getAttribute("name");
			if (order == null) {
			%>

			<h2>No Order Placed</h2>
			<%
			} else {
			%>

			<div class="container" id="product-container">
				<%
				for (Order o : order) {
					if (userName.equals(o.getCustomer().getUserName())) {
				%>
				<div class="card shadow  mb-2 bg-white rounded h-8">
					<div class="row no-gutters">
						<div class="col-sm-3" style="border-right: 2px solid blue;">
							<img class="card-img-top img-fluid my-2"
								src="../productimages/<%=o.getProductItems().getImage()%>"
								alt="Suresh Dasari Card" style="height: 200px; width: 350px;">
						</div>

						<div class="col-sm-9">
							<div class="card-body" style="height: 200px">
								<h6 style="color: blue;">Product Name :</h6>
								<h5 class="card-title"><%=o.getProductItems().getProductName()%></h5>
								<h6 style="color: blue;">Description :</h6>

								<%
								int descriptionsize = o.getProductItems().getDescription().length();
								if (descriptionsize > 150) {
								%>

								<p class="card-text"><%=o.getProductItems().getDescription().substring(0, 200)%>...
								</p>
								<%
								} else {
								%>
								<p class="card-text"><%=o.getProductItems().getDescription()%>...
								</p>
								<%
								}
								%>
								<div style="border: 0;">
									<div class="text-right">
										<h5>
											quantity:
											<%=o.getQuantiy()%>
										</h5>
									</div>
								</div>

								
							</div>
							<div class="card-footer" style="border: 0;">
							<div class="row">
							<div class="col-4">
							
							
							<h3 class="card-text">
						
								<span style="color: blue;">Price:</span>	<span style="font-size: 20px" class="fa">&#xf156;</span>
									<span><%=o.getPrice()%></span>
								</h3>
							</div>
							<div class="col-5 offset-3">
							<div class="text-right">
									<h5>
										Order Placed on:
										<%=DateFormat.getDateInstance().format(o.getOrderDate())%></h5>
								</div>
							</div>
							</div>
							
							
								


							</div>
						</div>
					</div>
				</div>
				<!-- order delivary -->

				
					<div class="container py-5 h-50">
						<div
							class="row d-flex justify-content-center align-items-center h-100">
							<div class="col-12">
								<div class="card card-stepper text-black"
									style="border-radius: 16px;">

									<div class="card-body p-4">

										<div
											class="d-flex justify-content-between align-items-center mb-5">
											<div>
												<h5 class="mb-0">
													ORDER ID :<span class="text-primary font-weight-bold"><%=o.getOrderId() %></span>
												</h5>
											
												<h5 class="mb-0">
													PRODUCT ID :<span class="text-primary font-weight-bold"><%=o.getProductItems().getProductId() %></span>
												</h5>
											</div>
											<div class="text-end">
												<p class="mb-0">
													Expected Arrival <span>01/12/19</span>
												</p>
												<p class="mb-0">
													Delivery Address :<span class="font-weight-bold"><%=o.getAddress() %></span>
												</p>
											</div>
										</div>

										<ul id="progressbar-2"
											class="d-flex justify-content-between mx-0 mt-0 mb-5 px-0 pt-0 pb-2">
											<li class="step0 active text-center" id="step1"></li>
											<li class="step0 active text-center" id="step2"></li>
											<li class="step0 active text-center" id="step3"></li>
											<li class="step0 text-muted text-end" id="step4"></li>
										</ul>

										<div class="d-flex justify-content-between">
											<div class="d-lg-flex align-items-center">
												<em class="fas fa-clipboard-list fa-3x me-lg-4 mb-3 mb-lg-0"></em>
												<div>
													<p class="fw-bold mb-1">Order</p>
													<p class="fw-bold mb-0">Processed</p>
												</div>
											</div>
											<div class="d-lg-flex align-items-center">
												<em class="fas fa-box-open fa-3x me-lg-4 mb-3 mb-lg-0"></em>
												<div>
													<p class="fw-bold mb-1">Order</p>
													<p class="fw-bold mb-0">Shipped</p>
												</div>
											</div>
											<div class="d-lg-flex align-items-center">
												<em class="fas fa-shipping-fast fa-3x me-lg-4 mb-3 mb-lg-0"></em>
												<div>
													<p class="fw-bold mb-1">Order</p>
													<p class="fw-bold mb-0">En Route</p>
												</div>
											</div>
											<div class="d-lg-flex align-items-center">
												<em class="fas fa-home fa-3x me-lg-4 mb-3 mb-lg-0"></em>
												<div>
													<p class="fw-bold mb-1">Order</p>
													<p class="fw-bold mb-0">Arrived</p>
												</div>
											</div>
										</div>

									</div>

								</div>
							</div>
						</div>
					</div>
			

				<%
				}
				}
				%>
			</div>
		</div>
	</div>
	<%
	}
	%>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>



</body>
</html>