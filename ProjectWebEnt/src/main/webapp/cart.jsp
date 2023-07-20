<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="DaoPackage.CartItemDAO" %>
<%@ page import="EntPackage.Cart" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard Project</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">

    <link rel="stylesheet"href="cast.css">
</head>

<body>
    <section id="header">
        <a href="#"><img src="picture/logo3.png" class="logo" alt=""></a>

        <div>
            <ul id="navbar">
                <li><a href="Nav_bar.html">Home</a></li>
                <li><a href="shop.html">Shop</a></li>
                <li><a href="blog.html">Blog</a></li>
                <li><a href="about.html">About</a></li>
                <li><a href="contact.html">Contact</a></li>
                <li id="lg-bag"><a class="active"href="cart.html"><i class="bx bx-cart-alt"></i></a></li>
            </ul>
        </div>
    </section>

    <section id="page-header" class="about-header">
        
        <h2>#let's talk</h2>

        <p>LEAVE A MESSAGE, We love to hear from you! </p>
        
    </section>

    <section id="cart" class="section-p1">
        <table width="100%">
            <thead>
                <tr>
                    <td>Remove</td>
                    <td>Image</td>
                    <td>Product</td>
                    <td>Price</td>
                    <td>Quantity</td>
                    <td>Subtotal</td>
                </tr>
            </thead>
            <tbody>
            <% CartItemDAO cartItemDAO = new CartItemDAO();
           List<Cart> cartItems = cartItemDAO.getAllCartItems();
           for (Cart cartItem : cartItems) { %>
           
                <tr>
                     <td><a href="#" class="delete-btn"><i class="far fa-times-circle"></i></a></td>
                    <td><img src="picture/Product_1.png" alt=""></td>
                    <td><%= cartItem.getProductName() %></td>
                    <td><%= cartItem.getProductID() %></td>
                    <td><input type="number" value="1" min="1"></td>
                    <td>RM110.00</td>
                </tr>
                <% } %>
                <tr>
                     <td><a href="#" class="delete-btn"><i class="far fa-times-circle"></i></a></td>
                    <td><img src="picture/Product_5.png" alt=""></td>
                    <td>Red Dark Beam Shirt</td>
                    <td>RM50.00</td>
                    <td><input type="number" value="1" min="1"></td>
                    <td>RM50.00</td>
                </tr>
                <tr>
                     <td><a href="#" class="delete-btn"><i class="far fa-times-circle"></i></a></td>
                    <td><img src="picture/Product_6.png" alt=""></td>
                    <td>Black Flower T-shirt</td>
                    <td>RM60.00</td>
                    <td><input type="number" value="1" min="1"></td>
                    <td>RM60.00</td>
                </tr>
                <tr>
                     <td><a href="#" class="delete-btn"><i class="far fa-times-circle"></i></a></td>
                    <td><img src="picture/Product_7.png" alt=""></td>
                    <td>Long Sleeve Purple UITM</td>
                    <td>RM65.00</td>
                    <td><input type="number" value="1" min="1"></td>
                    <td>RM65.00</td>
                </tr>
      
            </tbody>
            
        </table>
    </section>

    <section id="cart-add" class="section-p1">
        <div id="coupon">
            <h3>Apply Coupon</h3>
            <div>
                <input type="text" placeholder="Enter Your Coupon">
                <button class="normal">Apply</button>
            </div>
        </div>

        <div id="subtotal">
            <h3>Cart Totals</h3>
            <table>
                <tr>
                    <td>Cart Subtotal</td>
                    <td>RM285</td>
                </tr>
                <tr>
                    <td>Shipping</td>
                    <td>Free</td>
                </tr>
                <tr>
                    <td><strong>Total</strong></td>
                    <td><strong>RM 285</strong></td>
                </tr>
            </table>
            <button class="normal">Proceed to checkout</button>
        </div>
    </section>

    <footer class="section-p1">
        <div class="col">
            <img src="picture/logo2.jpg" alt="">
            <h4>Contact</h4>
            <p><strong>Address: </strong>No 5 Jalan Genting Emas, Taman Genting Emas, Balik Pulau</p>
            <p><strong>Phone: </strong>013-4833847</p>
            <p><strong>Hours: </strong>10.00 - 18.00, Mon - Sat</p>
            <div class="follow">
                <h4>Follow Us!</h4>
                <div class="icon">
                    <i class='bx bxl-facebook' ></i>
                    <i class='bx bxl-google'></i>
                    <i class='bx bxl-instagram' ></i>
                    <i class='bx bxl-twitter' ></i>
                </div>
            </div>
        </div>

        <div class="col">
            <h4>Company</h4>
            <a href="about.html">About Us</a>
           	<a href="blog.html">Blog</a>
            <a href="#">Privacy Policy</a>
            <a href="contact.html">Contact Us</a>
        </div>

        <div class="col install">
            <p>Secured Payment Gateways</p>
            <div class="icom">
                <i class='bx bxl-visa' ></i>
                <i class='bx bx-credit-card-alt' ></i>
                <i class='bx bxl-mastercard' ></i>
            </div>
        </div>

        <div class="copyright">
            <p>@ 2023, Enterprise - HTML CSS Website</p>
        </div>

    </footer>

 
	<script>
    // Get all the delete buttons
    var deleteButtons = document.querySelectorAll('.delete-btn');

    // Attach event listener to each delete button
    deleteButtons.forEach(function (button) {
        button.addEventListener('click', function () {
            var row = button.parentNode.parentNode; // Get the parent row
            row.remove(); // Remove the row from the table
        });
    });
	</script>
    <script src="cast.css"></script>
    
</body>
</html>
