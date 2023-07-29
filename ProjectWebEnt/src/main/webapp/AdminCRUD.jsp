<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*" %>

<%@page import="java.util.List"%>
<%@ page import="EntPackage.*" %>

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
	 	  <a href="mainPage.html" class="logout-button">Log out</a>
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
	      <label class="label">Clothing Category:</label>
	      <input type="text" name="productCategory" placeholder="Enter clothing type (e.g. jersey, polo etc.)" required class="input" />
	    </div>
	
	    <div class="column">
	      <div class="input-box">
	        <label class="label">Price:</label>
	        <input type="number" name="productPrice" placeholder="Enter price in MYR" required class="input" />
	      </div>
	      
	    </div>
	
	    <div class="input-box">
	      <label class="label">Description:</label>
	      <textarea name="productDesc" placeholder="Enter clothing description (maximum 80 words)" rows="4" style="max-width:100%; width:100%;" class="textarea"></textarea>
	    </div>
	
	    <div class="input-box">
	      <label class="label">Image JPG:</label>
	      <input type="text" name="productImage" placeholder="Enter image JPG" required class="input" />
	    </div>
	
	    <!-- Buttons for Create and Update operations -->
	    <div class="buttons">
	      <button type="submit" name="addProduct" class="button">Add Clothing to Shop</button>
	    </div>
	  </form>
	  
	  
	  
	  <div class="col-15 mt-5">
	      <table class="table table-striped table-red">
	        <thead>
	          <tr>
	            <th>ID</th>
	            <th>Cloth's name</th>
	            <th>Category</th>
	            <th>Price</th>
	            <th>Image(JPG)</th>
	            <th>Actions</th>
	          </tr>
	        </thead>
	        <tbody class="student-list">
	        
	        
	        <%
	        	try {
	        		String dbURL = "jdbc:mysql://localhost:3306/enterprise";
	                String dbUser = "root";
	                String dbPassword = "root";
	                
	                Class.forName("com.mysql.jdbc.Driver");
	                Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
	                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM product");
	               
	                ResultSet rs = stmt.executeQuery();
	                
	                while(rs.next()){
	                	int productID = rs.getInt("productID");
	                    String productName = rs.getString("productName");
	                    double productPrice = rs.getInt("productPrice");
	                    String productCategory = rs.getString("productCategory");
	                    String productDesc = rs.getString("productDesc");
	                    String productImage = rs.getString("productImage");
	                    
	                %>
	                    
	                    <tr>
	    	            <td><%= productID %></td>
	    	            <td><%= productName %></td>
	    	            <td><%= productCategory %></td>
	    	            <td><%= productPrice %></td>
	    	            <td><%= productImage %></td>
	    	            <td>
	    	            	
	    	            <form action="updateProduct" method="post">
	    	              <input type="hidden" name="productID" value="<%= productID %>">
	    	              <input type="submit" value="Edit" name="updateProduct" class="btn btn-danger btn-sm delete">
	    	              
	    	            </form>
	    	              
	    	              <form action="deleteProduct" method="get">
	    	              <a href="deleteProduct?productID=<%= productID %>" class="btn btn-warning btn-sm edit">Delete</a>
	    	            </form>
	    	            </td>
	    	          </tr>
	                    
	                    
	                 <% 
	                	}
	                rs.close();
	                stmt.close();
	       
	        		}catch (SQLException | ClassNotFoundException e) {
	                    e.printStackTrace();
	                    // Handle exceptions appropriately
	                }
	        		%>
	        
	        

	
	      </table>
	 	 </div>
	</section>
  </body>
</html>