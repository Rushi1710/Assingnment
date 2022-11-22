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
	%>

	<section class="h-100 h-custom" style="background-color: #eee;">
		<div class="container h-100 py-5">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col">
					<div class="card shopping-cart" style="border-radius: 15px;">
						<div class="card-body text-black">

							<div class="row">
								<div class="col-lg-6 px-5 py-4">

									<h3 class="mb-5 pt-2 text-center fw-bold text-uppercase">Your
										products</h3>

									<div class="d-flex align-items-center mb-5">
										<div class="flex-shrink-0">

											<!-- Product Image  -->

											<img src="../productimages/<%=productItems.getImage()%>" class="img-fluid"
												style="width: 150px;" alt="Generic placeholder image">
										</div>
										<div class="flex-grow-1 ms-3">
											<a href="#!" class="float-end text-black"><em
												class="fas fa-times"></em></a>

											<!-- Product Name -->

											<h5 class="text-primary"><%=productItems.getProductName()%></h5>

											<!-- Product Discription -->

											<h6 style="color: #9e9e9e;"><%=productItems.getDescription()%></h6>
											<div class="d-flex align-items-center">

												<!-- Product Price -->

												<p class="fw-bold mb-0 me-5 pe-3"><%=productItems.getPrice()%></p>
												<div class="def-number-input number-input safari_only">

													<input class="quantity fw-bold text-black" min="0"
														name="quantity" value="1" type="number"
														onclick="totalBill(<%=productItems.getPrice()%>,value)">

												</div>
											</div>
										</div>
									</div>



									<hr class="mb-4"
										style="height: 2px; background-color: #1266f1; opacity: 1;">


									<!-- Total price  -->

									<div class="d-flex justify-content-between p-2 mb-2"
										style="background-color: #e1f5fe;">
										<h5 class="fw-bold mb-0">Total:</h5>
										<h5 class="fw-bold mb-0" id="itemPrice"><%=productItems.getPrice()%></h5>
									</div>

								</div>
								<div class="col-lg-6 px-5 py-4">

									<h3 class="mb-5 pt-2 text-center fw-bold text-uppercase">Payment</h3>

									<form class="mb-5" action="/dashboard" method="post">

										<div class="form-outline mb-5">
											<input type="text" id="typeText"
												class="form-control form-control-lg" siez="17"
												minlength="12" maxlength="12" required /> <label
												class="form-label" for="typeText">Card Number</label>
										</div>

										<div class="form-outline mb-5">
											<input type="text" id="typeName"
												class="form-control form-control-lg" siez="17" required />
											<label class="form-label" for="typeName">Name on card</label>
										</div>

										<div class="row">
											<div class="col-md-6 mb-5">
												<div class="form-outline">
													<input type="month" id="typeExp"
														class="form-control form-control-lg" size="7" id="exp"
														minlength="4" maxlength="7" required /> <label
														class="form-label" for="typeExp">Expiration</label>
												</div>
											</div>
											<div class="col-md-6 mb-5">
												<div class="form-outline">
													<input type="password" id="typeText"
														class="form-control form-control-lg" size="1"
														minlength="3" maxlength="3" required /> <label
														class="form-label" for="typeText">Cvv</label>
												</div>
											</div>
										</div>

										<p class="mb-5">
											Lorem ipsum dolor sit amet consectetur, adipisicing elit <a
												href="#!">obcaecati sapiente</a>.
										</p>

										<button type="submit" class="btn btn-primary btn-block btn-lg">
											Buy now</button>

										<h5 class="fw-bold mb-5"
											style="position: absolute; bottom: 0;">
											<a href="home"><em class="fas fa-angle-left me-2"></em>Back
												to shopping</a>
										</h5>

									</form>

								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
	 function totalBill(price,quantity){
		 console.log("1 product price : "+price)
		 console.log(quantity)
		  let total = price*quantity;
		 document.getElementById('itemPrice').innerHTML=total;
		 console.log(total);
	 }
	</script>

</body>

</html>