<%@ page import="ConnectionDB.DbCon" %>
<%@ page import="EntPackage.*" %>
<%@ page import="DaoPackage.ProductDAO" %>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">


    <link rel="stylesheet" href="dash.css">
    <title>Online Shop</title>
</head>
<body>

	<section id="header">
        <a href="#"><img src="picture/logo3.png" class="logo" alt=""></a>

        <div>
            <ul id="navbar">
                <li><a href="Nav_bar.html">Home</a></li>
                <li><a class="active" href="shop.html">Shop</a></li>
                <li><a href="blog.html">Blog</a></li>
                <li><a href="about.html">About</a></li>
                <li><a href="contact.html">Contact</a></li>
                <li><a href="cart.html"><i class='bx bx-cart-alt'></i></a></li>
            </ul>
        </div>
    </section>
    <section id="home">
        <a href="#"><img src="picture/home.jpg" class="logo" alt=""></a>
    </section>
		
		<section id="product1">
        <div class="pro-container">
        
        <%
       	ProductDAO productDAO = new ProductDAO();
         List<Product> products = productDAO.getAllProducts();

         for (Product product : products) {
        %>
        
            <div class="pro" >
                <img src="picture/<%= product.getImage() %>" width="100%" id="MainImg" alt="">
                <div class="des">
                    <span>Superstrike</span>
                    <h5><%= product.getProductName() %></h5>
                    <div class="star">
                        <i class='bx bx-star'></i>
                        <i class='bx bx-star'></i>
                        <i class='bx bx-star'></i>
                        <i class='bx bx-star'></i>
                        <i class='bx bx-star'></i>
                    </div>
                    <h4><%= product.getProductPrice() %></h4>
                </div>
                <form action="TestingDisplayProduct" method="get">
                    <input type="hidden" name="productID" value="<%= product.getProductID() %>">
                    <input type="submit" value="View Details">
                </form>
                <a href="TestingDisplayProduct.jsp?productID=<%= product.getProductID() %>">View Details</a>
            </div>
             <%
            }
        %>
		</div>
        </section>
        

</body>
</html>

