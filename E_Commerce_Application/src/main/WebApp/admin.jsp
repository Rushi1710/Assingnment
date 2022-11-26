<%@page import="com.boot.application.entity.ProductItems"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link href="../css/style.css" rel="stylesheet">

<%
List<ProductItems> products = (List<ProductItems>) request.getAttribute("products");
%>
</head>
<body>

	<div class="container-fluid my-3">

		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#add-product-modal">Add Product</button>

		<!--Add Modal -->
		<div class="modal fade" id="add-product-modal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Add Product</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form id="add_Post_form" action="addproduct" method="POST"
							enctype="multipart/form-data">

							<br>
							<div class="form-group">
								Product Title : <input name="productName" type="text"
									placeholder="Enter Post Title" class="form-control">
							</div>
							<br>
							<div class="form-group">
								Product Description :
								<textarea name="description"
									placeholder="Enter Product Description" class="form-control"
									style="height: 200px"></textarea>
							</div>
							<br>
							<div class="form-group">
								Product Price: <input type="text" name="price"
									placeholder="Enter Product Price" class="form-control" />
							</div>

							<div class="form-group">
								Product Quantity: <input type="number" name="quantity"
									placeholder="Enter Product Quantity" class="form-control" />
							</div>
							<br>
							<div class="form-group">

								<label id="1st" class="btn custom-input-btn" style="color: blue">
									<em class="fa fa-cloud-upload" style="color: blue"></em> <input
									type="file" name="img" multiple>
								</label>

							</div>
							<br>
							<div class="container text-end">
								<button type="submit" class="btn btn-outline-dark btn-lg">Add
									Product</button>
							</div>

						</form>


					</div>

				</div>
			</div>
		</div>
	</div>

	<table class="table table-primary table-hover my-3 table-bordered"
		style="border-color: black;">
		<caption>This is admin jsp file . In this file i have to
			perfornm update ,insert and delete products</caption>
		<thead>
			<tr class="text-center">
				<th scope="col">Table Id</th>
				<th scope="col">Product Id</th>
				<th scope="col">Title</th>
				<th scope="col">Description</th>
				<th scope="col">Price</th>
				<th scope="col">Quantity</th>
				<th scope="col">Image</th>
				<th scope="col"></th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<%
			int count = 1;
			for (ProductItems p : products) {
			%>
			<tr>
				<th scope="row"><%=count%></th>
				<td><%=p.getProductId()%></td>
				<td><%=p.getProductName()%></td>
				<td><%=p.getDescription()%></td>
				<td><%=p.getPrice()%></td>
				<td><%=p.getQuantity()%></td>

				<td><img src="../productimages/<%=p.getImage()%>"
					style="height: 60px" width="60px" class="img-fluid img-thumbnail"
					alt="Sheep"></td>
				<td><button type="button" class="btn btn-success"
						data-bs-toggle="modal" data-bs-target="#update-product-modal"
						onclick="getUpdateData(<%=p.getProductId()%>)">Update</button></td>
				<td><button type="button" class="btn btn-danger"
						onclick="deleteProductbyId(<%=p.getProductId()%>)">Delete</button></td>
			</tr>



			<%
			count++;
			}
			%>
		</tbody>
	</table>


	<!-- Update Modal -->
	<div class="modal fade" id="update-product-modal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Update Product</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body" id="modal-body">
					<form id="update_Post_form" action="/updateproduct" method="POST"
						enctype="multipart/form-data">

						<br>
						<div class="form-group">
							Product Title : <input name="productName" id="title" type="text"
								placeholder="Enter Post Title" class="form-control">
						</div>
						<br>
						<div class="form-group">
							Product Description :
							<textarea name="description" id="description"
								placeholder="Enter Product Description" class="form-control"
								style="height: 200px"></textarea>
						</div>
						<br>
						<div class="form-group">
							Product Price: <input type="text" name="price" id="price"
								placeholder="Enter Product Price" class="form-control" />
						</div>

						<div class="form-group">
							Product Quantity: <input type="number" name="quantity"
								id="quantity" placeholder="Enter Product Quantity"
								class="form-control" />
						</div>
						<br>
						<div class="form-group" id="image"
							style="border: 2px solid black; display: inline-block;"></div>
						<div class="form-group">

							<label id="1st" class="btn custom-input-btn" style="color: blue"
								onchange="changepro(event)"> <em
								class="fa fa-cloud-upload" style="color: blue"></em> <input
								type="file" name="img" multiple>
							</label>


						</div>
						<br>
						<div class="container text-end">
							<button type="submit" class="btn btn-outline-dark btn-lg">Update
								Product</button>
						</div>
					</form>
				</div>

			</div>
		</div>
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
	
	
	

	$('#add_Post_form').on('submit',function(event){
		
		event.preventDefault();
		let form=new FormData(this);
		
		console.log("add form submit clicked")
		$.ajax({
			url : "addproduct",
			type : "POST",
			data : form,
			success : function(data, textStatus, jqXHR) {
				console.log(data)
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(errorThrown)
			},
			processData : false,
			contentType : false
		})
		
	})
	
	
	function deleteProductbyId(pid){
		console.log(pid);
		var url = new URL("http://localhost:8082/delete?product_id=");
		url.searchParams.set('product_id',pid);
		window.location.href=url;
	}

	
	
var productId="";
	
	function getUpdateData(pid){
		console.log(pid)
		productId=pid;
		let prodId={
				"productId":pid
		}
		
		$.ajax({
			type:"POST",
			contentType : 'application/json; charset=utf-8',
			 dataType : 'json',
			url:'getproductbyid',  
			 data:JSON.stringify(prodId),
			 success:function(result){
				 console.log(result)
			console.log( $('#title').val(result.t.productName));
				 $('#description').val(result.t.description)
				 $('#price').val(result.t.price)
				 $('#quantity').val(result.t.quantity)
			let htmlvar='<img src="../productimages/'+result.t.image+'" id="output" class="img-fluid" style="height: 155px; width: 150px" /><br>'
				 
				 $('#image').html(htmlvar)
			 },
			 error(xhr, status, error){
				 console.log(error)
			 },
			
		});
	
	}
	
	
	$('#update_Post_form').on('submit',function(event){
			event.preventDefault();
           let form=new FormData(this);
          
           console.log("pid");
           form.set("productId",productId)
		 	$.ajax({
				url : "updateproduct",
				type : "POST",
				data : form,
				success : function(data, textStatus, jqXHR) {
					swal("Updated Succesfully")
					 .then((value)=>{
						 window.location="http://localhost:8082/admin";
					 })
				},
				error : function(jqXHR, textStatus, errorThrown) {
					console.log(errorThrown)
				},
				processData : false,
				contentType : false
			})  
	})
	
	var changepro = function(event) {
		var output = document.getElementById('output');
		output.src = URL.createObjectURL(event.target.files[0]);
		output.onload = function() {
			URL.revokeObjectURL(output.src)
		}
	};
	
	</script>
</body>
</html>

