<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="EntPackage.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login and Register</title>
    <link rel="stylesheet" href="style.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    
</head>

<body>

    <header class="header">
        <nav class="navbar">
            <a href="#">Home</a>
            <a href="#">About</a>
            <a href="#">Services</a>
            <a href="#">Contact</a>
        </nav>

        <form action="#" class="search-bar">
            <input type="text" placeholder="Search">
            <button type="submit"><i class='bx bx-search'></i></button>

        </form>
    </header>

    <div class="background"></div>
    <div class="container">
        <div class="content">
            <h2 class="logo"><i class='bx bxs-t-shirt'></i>
            Hipstrike</h2>

            <div class="text-sci">
                <h2> Welcome!<br><span> To Hipstrike Brand Website.</span></h2>

                <p>WHERE YOU CAN HAVE ANYTHING YOU WANT
                    IN LIFE IF YOU DRESS FOR IT
                </p>
                
                <div class="social-icons">
                    <a href="#"><i class='bx bxl-linkedin' ></i></a>
                    <a href="#"><i class='bx bxl-facebook' ></i></a>
                    <a href="#"><i class='bx bxl-instagram' ></i></a>
                    <a href="#"><i class='bx bxl-twitter'></i></a>
                </div>
            </div>
        </div>
        
        <%
	User auth = (User) request.getSession().getAttribute("auth");
	if (auth != null) {
		response.sendRedirect("TestingShop.jsp");
	}
	%>
       
        <div class="logreg-box">
            <div class="form-box login">
                <form action="UsersLogin" method="post">
                    <h2>Sign In</h2>

                    <div class="input-box">
                        <span class="icon">
                            <i class='bx bxs-envelope' ></i>
                        </span>
                        <input type="email" id="userEmail" name="userEmail" required>
                        <label>Email</label>
                    </div>

                    <div class="input-box">
                        <span class="icon">
                            <i class='bx bxs-lock-alt' ></i>
                        </span>
                        <input type="password" id="userPassword" name="userPassword" required>
                        <label>Password</label>
                    </div>

                    <div class="remember-forgot">
                        <label><input type="checkbox"> Remember me</label>
                        <a href="#">Forget Password?</a>
                    </div>

                    <button type="submit" class="btn">Sign In</button>

                    <div  class="login-register">
                        <p>Don't have an account?<a href="#" class="register-link">
                            Sign Up</a></p>
                    </div>


                </form>
            </div>

            <div class="form-box register">
                <form action="register" method="post">
                    <h2>Sign Up</h2>

                    <div class="input-box">
                        <span class="icon">
                            <i class='bx bxs-user' ></i>
                        </span>
                        <input type="text" id="userName" name="userName" required>
                        <label>Name</label>
                    </div>

                    <div class="input-box">
                        <span class="icon">
                            <i class='bx bxs-envelope' ></i>
                        </span>
                        <input type="email" id="userEmail" name="userEmail" required>
                        <label>Email</label>
                    </div>

                    <div class="input-box">
                        <span class="icon">
                            <i class='bx bxs-lock-alt' ></i>
                        </span>
                        <input type="password" id="userPassword" name="userPassword" required>
                        <label>Password</label>
                    </div>

                    <div class="remember-forgot">
                        <label><input type="checkbox"> I agree to the terms & conditions</label>
                        
                    </div>

                    <button type="submit" value="Register" class="btn">Sign Up</button>

                    <div  class="login-register">
                        <p>Already have an account?<a href="#" class="login-link">
                            Sign In</a></p>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script src="index.js"></script>
    
</body>
</html>