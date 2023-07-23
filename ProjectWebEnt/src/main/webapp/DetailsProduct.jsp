<%@ page import="ConnectionDB.DbCon" %>
<%@ page import="EntPackage.*" %>
<%@ page import="DaoPackage.ProductDAO" %>
<%@page import="java.util.List"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


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
    <title>Display Product</title>
</head>
<body>
  <section id="header">
        <a href="#"><img src="picture/logo3.png" class="logo" alt=""></a>

        <div>
            <ul id="navbar">
                <li><a href="Nav_bar.jsp?userID=<%=request.getParameter("userID") %>">Home</a></li>
                <li><a class="active" href="showProducts.jsp?userID=<%=request.getParameter("userID") %>">Shop</a></li>
                <li><a href="blog.jsp?userID=<%=request.getParameter("userID") %>">Blog</a></li>
                <li><a href="about.jsp?userID=<%=request.getParameter("userID") %>">About</a></li>
                <li><a href="contact.jsp?userID=<%=request.getParameter("userID") %>">Contact</a></li>
                <li><a href="cart.jsp?userID=<%=request.getParameter("userID") %>"><i class='bx bx-cart-alt'></i></a></li>
            </ul>
        </div>
    </section>
    <section id="home">
        <a href="#"><img src="picture/home.jpg" class="logo" alt=""></a>
    </section>
    <h2>Product Details</h2>
    <%

        int selectedProductId = Integer.parseInt(request.getParameter("productID"));

        ProductDAO productDAO = new ProductDAO();
        Product selectedProduct = productDAO.getProductById(selectedProductId);

        if (selectedProduct != null) {
    %>
    
    <section id="prodetails" class="section-p1">
      <br>
        <div class="single-pro-image">
            <img src="picture/<%= selectedProduct.getProductImage() %>" width="100%" id="MainImg" alt="">
        </div>
        <div class="single-pro-details">
        
        <form action="AddCart" method="post">
        
            <h6>Home/T-Shirt</h6>
            <h4><%= selectedProduct.getProductName() %></h4>
            <h2>RM<%= selectedProduct.getProductPrice() %></h2>
            <h6>Size: </h6><select name="size">
                <option>XS</option>
                <option>S</option>
                <option>M</option>
                <option>L</option>
                <option>XL</option>
            </select>
           <h6>Quantity: </h6><select name="quantity">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select>
            
                    <input type="text" name="productID" value="<%= selectedProduct.getProductID() %>">
                    <input type="text" name="productImage" value="<%= selectedProduct.getProductImage() %>">
                    <input type="text" name="productPrice" value="<%= selectedProduct.getProductPrice() %>">
                    <input type="text" name="userID" value="<%= request.getParameter("userID") %>">
                    <button type="submit" class="normal" name="AddCart" >Add To Cart</button>
                </form>
            <h4>Product Details</h4>
            <span><%= selectedProduct.getProductDesc() %></span>
        </div>
    </section>
   
    <%
        } else {
    %>
    <p>Product not found.</p>
    <%
        }
    %>
</body>
</html>