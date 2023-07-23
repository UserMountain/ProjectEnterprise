<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

    <link rel="stylesheet"href="contad.css">
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
            	<li><a class="full" href="loginRegister.jsp">Log Out</a></li>
            </ul>
        </div>
    </section>


    <section id="page-header" class="about-header">
        
        <h2>#let's talk</h2>

        <p>LEAVE A MESSAGE, We love to hear from you! </p>
        
    </section>

    <section id="contact-details" class="section-p1">
        <div class="details">
            <span>GET IN TOUCH WITH US!</span>
            <h2>Visit one of our agency locations or contact us today!</h2>
            <h3>Head Office</h3>
            <div>
                <li>
                    <i class='bx bx-map-alt' ></i>
                    <p>No 5 Jalan Genting Emas, Taman Genting Emas, Balik Pulau</p>
                </li>
                <li>
                    <i class='bx bx-envelope'></i>
                    <p>HipstrikeOfficial@Yahoo.com</p>
                </li>
                <li>
                    <i class='bx bx-phone' ></i>
                    <p>Office: +013-4833847</p>
                </li>
                <li>
                    <i class='bx bx-time' ></i>
                    <p>Monday to Saturday: 10.00am to 6.00pm</p>
                </li>
             </div>
            </div>
            <div class="map">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1986.2671603986983!2d100.2129401388254!3d5.335069719252256!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.
                1!3m3!1m2!1s0x304aeb1de477ad13%3A0x8be747a3f274d35a!2sTaman%20Genting%20Emas%2C%2011000%20Balik%20Pulau%2C%20Penang!5e0!3m2!1sen!2smy!4v1687871387692!5m2!1sen!2smy" 
                width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
        </div>
    </section>

    <section id="form-details">
        <form action="">
            <span>LEAVE A MESSAGE</span>
            <h2>We love to hear from you</h2>
            <input type="text" placeholder="Your Name">
            <input type="text" placeholder="E-mail">
            <input type="text" placeholder="Subject">
            <textarea name="" id="" cols="30" rows="10" placeholder="Your Message"></textarea>
            <button class="normal">Submit</button>
        </form>
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
            <img src="picture/logo2.jpg" alt="logo">
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

    <script src="contad.css"></script>
    
</body>
</html>
