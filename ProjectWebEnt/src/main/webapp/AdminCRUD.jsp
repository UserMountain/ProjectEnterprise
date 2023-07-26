<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <title>Shop Clothing Entry Form</title>
    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="Adcrud.css" />
  </head>
  <body>
  


	    <section class="container">
	      
	      <header class="header">
		  <nav class="navbar">
	  	  <a href="Admin Page.html" class="home-button">Home</a>
	 	  <a href="loginRegister.jsp" class="logout-button">Log out</a>
		  </nav>
		  </header>
	      
	      <header class="header">Hip Strike's Exclusive Admin</header>
	      
	      
	      <form action="addProduct" class="form" method="post">
	        <!-- For updating existing clothing data -->
	        <div class="input-box">
	          <label class="label">Clothing ID:</label>
	          <input type="text" name="productID" placeholder="Enter clothing ID (if updating)" class="input" />
	        </div>
	            <!-- For creating or updating clothing data -->
	    <div class="input-box">
	      <label class="label">Clothing Name:</label>
	      <input type="text" name="productName" placeholder="Enter clothing name" required class="input" />
	    </div>
	
	    <div class="input-box">
	      <label class="label">Clothing Type:</label>
	      <input type="text" name="productCategory" placeholder="Enter clothing type (e.g. shirt, pants, etc.)" required class="input" />
	    </div>
	
	    <div class="column">
	      <div class="input-box">
	        <label class="label">Price:</label>
	        <input type="number" name="productPrice" placeholder="Enter price in MYR" required class="input" />
	      </div>
	      <div class="input-box">
	        <label class="label">Stock Quantity:</label>
	        <input type="number" name="stock_quantity" placeholder="Enter stock quantity" required class="input" />
	      </div>
	    </div>
	
	    <div class="input-box">
	      <label class="label">Description:</label>
	      <textarea name="productDesc" placeholder="Enter clothing description (maximum 80 words)" rows="4" style="max-width:100%; width:100%;" class="textarea"></textarea>
	    </div>
	
	    <div class="input-box">
	      <label class="label">Image URL:</label>
	      <input type="text" name="productImage" placeholder="Enter image URL" required class="input" />
	    </div>
	
	    <!-- Buttons for Create and Update operations -->
	    <div class="buttons">
	      <button type="submit" name="addProduct" class="button">Add Clothing to Shop</button>
	      <button type="submit" name="update" class="button">Update Clothing in Shop</button>
	    </div>
	  </form>
	  <div class="col-15 mt-5">
	      <table class="table table-striped table-red">
	        <thead>
	          <tr>
	            <th>ID</th>
	            <th>Cloth's name</th>
	            <th>Type</th>
	            <th>Price</th>
	            <th>Qtty</th>
	            <th>Actions</th>
	          </tr>
	        </thead>
	        <tbody class="student-list">
	          <tr>
	            <td>001</td>
	            <td>Black Flora</td>
	            <td>Shirt</td>
	            <td>RM60</td>
	            <td>4</td>
	            <td>
	              <a href="" class="btn btn-warning btn-sm edit">Edit</a>
	              <a href="" class="btn btn-danger btn-sm delete">Delete</a>
	            </td>
	          </tr>
	          <tr>
	            <td>002</td>
	            <td>Hoodie Black</td>
	            <td>Shirt</td>
	            <td>RM110</td>
	            <td>2</td>
	            <td>
	              <a href="" class="btn btn-warning btn-sm edit">Edit</a>
	              <a href="" class="btn btn-danger btn-sm delete">Delete</a>
	            </td>
	          </tr>
	
	      </table>
	 	 </div>
	</section>
  </body>
</html>