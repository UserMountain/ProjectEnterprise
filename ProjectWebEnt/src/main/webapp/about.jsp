<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard Project</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

    <link rel="stylesheet"href="bout.css">
</head>
<body>
    <section id="header">
       <a href="#"><img src="picture/logo3.png" class="logo" alt=""></a>

        <div>
            <ul id="navbar">
                <li><a href="Nav_bar.jsp?userID=<%=request.getParameter("userID") %>">Home</a></li>
                <li><a href="showProducts.jsp?userID=<%=request.getParameter("userID") %>">Shop</a></li>
                <li><a href="blog.jsp?userID=<%=request.getParameter("userID") %>">Blog</a></li>
                <li><a class="active" href="about.jsp?userID=<%=request.getParameter("userID") %>">About</a></li>
                <li><a href="contact.jsp?userID=<%=request.getParameter("userID") %>">Contact</a></li>
                <li><a href="cart.jsp?userID=<%=request.getParameter("userID") %>"><i class='bx bx-cart-alt'></i></a></li>
             	<li><a class="full" href="loginRegister.jsp">Log Out</a></li>
            </ul>
        </div>
    </section>

    <section id="page-header" class="about-header">
        
        <h2>#About Us</h2>

        <p>Read all case studies about our product!</p>
        
    </section>
    
	<section class="cool-marquee">
    <div class="marquee-container">
        <p>
            <span>SUBLIMATION EXPERT</span>
            <span>CUSTOM BAJU SETARAF BAJU BRANDED</span>
            <span>HIPSTRIKE OFFICIAL HQ</span>
        </p>
    </div>
	</section>

	<section id="about-head" class="section-p1">
	    <div class="about-content">
	        <h2>Welcome to Our Website</h2>
	        <p>Welcome to Hipstrike Official HQ - Your go-to destination for trendy and unique clothing! We are experts in sublimation, bringing you vibrant and eye-catching designs like no other.</p>
	        <p>Discover our custom baju sets that rival branded apparel, ensuring you look and feel amazing. From streetwear to athleisure, we have a diverse range of styles to suit your fashion preferences.</p>
	        <p>Express yourself with our option for custom orders. If you have a design in mind, our talented team will bring it to life, making you stand out in any crowd.</p>
	        <p>Shopping is a breeze - just click the link below to explore our collections and place your order.</p>
	        <p>Join us now and be a part of the fashion revolution with Hipstrike Apparel!</p>
	        <abbr title="">Click Link To Purchase</abbr>
	         <h3>linktr.ee/HipstrikeApparel</h3>
	        <br><br>
	    </div>
	    <div class="about-image">
	        <img src="picture/about.jpg" alt="">
	    </div>
	</section>


	<!-- ------Service Start--------- -->
	 <section class="services" id="service">
	    <div class="heading">
	        <span>Services</span>
	        <h2>We Provide Best Quality Clothing</h2>
	    </div>
	
	    <div class="service-container">
	        <div class="s-box">
	            <img src="picture/Order.png" alt="Service 1">
	            <h3>Order</h3>
	            <p>Browse our fabulous collection of trendy clothing and accessories, and easily place your order with just a few clicks. We've made the shopping process quick and hassle-free for your convenience.</p>
	        </div>
	        <div class="s-box">
	            <img src="picture/Deliver.png" alt="Service 2">
	            <h3>Shipping</h3>
	            <p>Once your order is confirmed, our dedicated team works diligently to prepare your items for shipping. We take pride in our fast and reliable delivery service, ensuring your fashion finds reach you in no time.</p>
	        </div>
	        <div class="s-box">
	            <img src="picture/Delivered.png" alt="Service 3">
	            <h3>Delivery</h3>
	            <p>Sit back and relax as we bring the latest fashion right to your doorstep. No need to step out  we've got you covered! Experience the joy of unboxing your new wardrobe additions from the comfort of your home.</p>
	        </div>
	    </div>
	</section>

    <section id="newsletter" class="section-p1 section-m1">
        <div class="newstext">
            <h4>Sign Up For Newsletter</h4>
            <p>Get E-mail updates about our latest shop and <span>special offers.</span></p>
        </div>
        <div class="form">
            <input type="text" placeholder="Your email address">
            <button class="normal">Sign Up</button>
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
            <a href="#">About Us</a>
           	<a href="#">Blog</a>
            <a href="#">Privacy Policy</a>
            <a href="#">Contact Us</a>
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

    <script src="bout.css"></script>
    
</body>
</html>