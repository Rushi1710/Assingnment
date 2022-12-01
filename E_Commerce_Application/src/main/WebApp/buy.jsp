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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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

											<img src="../productimages/<%=productItems.getImage()%>"
												class="img-fluid" style="width: 150px;"
												alt="Generic placeholder image">
										</div>
										<div class="flex-grow-1 ms-3">


											<!-- Product Name -->
											<h6 style="color: black;">product name :</h6>
											<h5 class="text-primary"><%=productItems.getProductName()%></h5>

											<!-- Product Discription -->
											<h6 style="color: black;">product Description :</h6>
											<h6 style="color: blue;"><%=productItems.getDescription()%></h6>
											<div class="d-flex align-items-center">

												<!-- Product Price -->

												<h3 class="fw-bold mb-0 me-5 pe-3" style="width: 100px">
													<span style="font-size: 20px" class="fa">&#xf156;</span><%=productItems.getPrice()%></h3>
												<div class="def-number-input number-input safari_only">



													<label for="number">Quantity</label> <input type="number"
														id="number" name="quantity" value="1" min="1"
														<%-- max="<%=productItems.getQuantity()%>" --%>
														onclick="totalBill(<%=productItems.getPrice()%>,value,<%=productItems.getQuantity()%>)" />
													<h6 id="stock"></h6>


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
										<h5 class="fw-bold mb-0" id="itemPrice">
											<%=productItems.getPrice()%></h5>
									</div>
									<br> <label for="cars">Choose a Payment Options:</label> <select
										name="cars" id="cars">
										<option value="saab">Credit/debit card</option>
										<option value="volvo">Cash on Delivery</option>
										<option value="opel">Google Pay</option>
										<option value="audi">Digital wallets.</option>
									</select>

								</div>



								<div class="col-lg-6 px-5 py-4">

									<h3 class="mb-5 pt-2 text-center fw-bold text-uppercase">Payment</h3>

									<form class="mb-5" id="form1">

										<div class="form-outline mb-5">
											<input type="text" id="typeText"
												class="form-control form-control-lg" siez="17"
												placeholder="1234-4567-6789"
												pattern="[0-9]{4}-[0-9]{4}-[0-9]{4}" required /> <label
												class="form-label" for="typeText">Card Number</label>
										</div>

										<div class="form-outline mb-5">
											<input type="text" id="typeName" name="customerName"
												onkeyup="name_Validation()"
												class="form-control form-control-lg" size="17" required /><span
												id="name-error"></span> <label class="form-label"
												for="typeName">Name on card</label>
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
														pattern="[0-9]{3}" required /> <label class="form-label"
														for="typeText">Cvv</label>
												</div>
											</div>
										</div>



										<button type="submit" class="btn btn-primary btn-block btn-lg">
											Buy now</button>
										<p id="outOfStock" style="color: red"></p>

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

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


	<script>

	 function totalBill(price,quantity,qut){
		 console.log("1 product price : "+price)
		 console.log(quantity)
		  let total = price*quantity; 
		 document.getElementById('itemPrice').innerHTML=total;
		  	console.log("price and quantity");
		 	let quantity1 =$('#number').val();
		 	let price1 = $('#itemPrice').val() ;
		 	console.log(quantity1);
		 	if(qut < quantity){
		 		const name = quantity;
		 		const number = " product not available ";
		 		/* console.log(`${name}${number}`); // "Front 242"
		 		const msg = ${name}${number}`; */
		 		document.getElementById('stock').innerHTML=number;
		 	}else{
		 		document.getElementById('stock').innerHTML=" ";
		 	}
		 
		
	 }
	 
		function name_Validation(){
			
		    var regName = /^[a-zA-Z]+ [a-zA-Z]+$/; 
		    var regName1=/^[A-Za-z]+/;
		    var name = document.getElementById('typeName').value;
		    
		    if(onlyLetters(name))
		    {
		    	document.getElementById('name-error').style.color = 'red';
				document.getElementById('name-error').innerHTML = 'Please Enter Your Full Name on card Without Any Number';
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
		
		
	 	   
	 	   $('#form1').on('submit',function(event){
	 		   event.preventDefault();
	 		  console.log("Order"+${product.getProductId()});
		 	   let prodid={
		 			   "productId":${product.getProductId()}
		 	   }
	 		   
		 	   
		 		 $.ajax({
		 		 			type:"POST",
		 		 			contentType : 'application/json; charset=utf-8',
		 		 			 dataType : 'json',
		 		 			url:'/checkoutofstock',                      
		 		 			 data:JSON.stringify(prodid),
		 		 			 success:function(result){
		 		 				 if(result.statusCode==200){
		 		 					 console.log(${product.getProductId()});
		 		 	
		 		 					let quantity1 =$('#number').val();
		 		 					 window.location="http://localhost:8082/customer/order?product_id="+${product.getProductId()}+"&quantity="+quantity1;
		 		 					 
		 		 				 }
		 		 				 else if(result.statusCode==405){
		 		 					swal("You have to login first")
		 							 .then((value)=>{
		 								 window.location="http://localhost:8082/customer/login";
		 							 })
		 		 				 }
		 		 				 else{
		 		 					 $('#outOfStock').html("This Item is currently out of stock")
		 		 				 }
		 		 			 
		 		 			 },
		 		 			 error: function(xhr, status, error) {
		 		 				
		 		 			   },	
		 		 		})
		 		 	   
	 		   
	 	   })
	 	   
	 
	</script>

</body>

</html>
