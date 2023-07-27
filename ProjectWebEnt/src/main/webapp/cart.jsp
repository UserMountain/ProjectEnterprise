<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="DaoPackage.CartItemDAO" %>
<%@page import="java.util.List"%>
<%@ page import="EntPackage.*" %>


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
    
    <style>
	    .center-quantity {
	        text-align: center;
	    }
	    .quantity-input {
        width: 30px; /* Adjust the width as desired */
        height: 30px;
    	}
	    
	</style>
    
</head>

<body>
	<jsp:useBean id="CartItem" class="EntPackage.CartItem"></jsp:useBean>
    <section id="header">
        <a href="#"><img src="picture/logo3.png" class="logo" alt=""></a>

        <div>
            <ul id="navbar">
                <li><a href="Nav_bar.jsp?userID=<%=request.getParameter("userID") %>">Home</a></li>
                <li><a href="showProducts.jsp?userID=<%=request.getParameter("userID") %>">Shop</a></li>
                <li><a href="blog.jsp?userID=<%=request.getParameter("userID") %>">Blog</a></li>
                <li><a href="about.jsp?userID=<%=request.getParameter("userID") %>">About</a></li>
                <li><a href="contact.jsp?userID=<%=request.getParameter("userID") %>">Contact</a></li>
                <li><a class="active" href="cart.jsp?userID=<%=request.getParameter("userID") %>"><i class='bx bx-cart-alt'></i></a></li>
            	<li><a class="full" href="loginRegister.jsp">Log Out</a></li>
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
                <td>Size</td>
                <td>Price</td>
                <td>Quantity</td>
                <td>Subtotal</td>
                <td></td>
                <td>Update</td>
            </tr>
        </thead>
        <tbody>
        
        
        <% 
        double totalPrice = 0.00;
        try {
            String dbURL = "jdbc:mysql://localhost:3306/enterprise";
            String dbUser = "root";
            String dbPassword = "root";
			
            int userID = Integer.parseInt(request.getParameter("userID"));
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cartItems WHERE userID = ?");
            stmt.setInt(1, userID); // Replace 123 with the desired userID
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {
                int cartID = rs.getInt("cartID");
                int productID = rs.getInt("productID");
                userID = rs.getInt("userID");
                String size = rs.getString("size");
                int quantity = rs.getInt("quantity");
                double subTotal = rs.getInt("subTotal");
                
                PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM product WHERE productID = ?");
                stmt2.setInt(1, productID);
                ResultSet rs2 = stmt2.executeQuery();
                
                totalPrice = totalPrice + subTotal;
                
                while (rs2.next()){
                	productID = rs2.getInt("productID");
                    String productName = rs2.getString("productName");
                    double productPrice = rs2.getInt("productPrice");
                    String productCategory = rs2.getString("productCategory");
                    String productDesc = rs2.getString("productDesc");
                    String productImage = rs2.getString("productImage");
                
                %>
                <tr>
               		<td>
				        <form action="DeleteCart" method="get">
				            <a href="DeleteCart?cartID=<%= cartID %>&userID=<%=userID%>" class="delete-btn">
				                <i class="far fa-times-circle"></i>
				            </a>
				        </form>
				    	</td>
				    	<td><img src="picture/<%= productImage %>" alt=""></td>
				    	<td><%= productName %></td>
				    	
				    <form action="UpdateCart" method="post">
				    
				    	<td>
				    	<select name="size">
				    			<option><%=size %></option>
				    		<% if (!size.equals("XS")) { %>
						        <option value="XS">XS</option>
						    <% } %>
						    <% if (!size.equals("S")) { %>
						        <option value="S">S</option>
						    <% } %>
						    <% if (!size.equals("M")) { %>
						        <option value="M">M</option>
						    <% } %>
						    <% if (!size.equals("L")) { %>
						        <option value="L">L</option>
						    <% } %>
						    <% if (!size.equals("XL")) { %>
						        <option value="XL">XL</option>
						    <% } %>
				    	</select>
				    	</td>
				    	<td>RM <%= productPrice %>0</td>
				    	<td class="center-quantity">
					        	<input type="hidden" name="size" value="<%= size %>">
					            <input class="quantity-input" type="number" name="quantity" value="<%= quantity %>" min="1">
					            <input type="hidden" name="cartID" value="<%= cartID %>">
					            <input type="hidden" name="userID" value="<%= userID %>">
					            <input type="hidden" name="productPrice" value="<%= productPrice %>">
					            <input type="hidden" name="subTotal" value="<%= subTotal %>">
					        
				    	</td>
				    	<td>RM <%= subTotal %>0</td>
				    	<td></td>
				    	<td><input type="submit" value="Update"></td>
				    </form>
				
			    	<td>

                </tr>
                <% 
                }
                rs2.close();
                stmt2.close();
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
        %>
        
        
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
                    <td>RM <%= totalPrice %>0</td>
                </tr>
                <tr>
                    <td>Shipping</td>
                    <td>Free</td>
                </tr>
                <tr>
                    <td><strong>Total</strong></td>
                    <td><strong>RM <%= totalPrice %>0</strong></td>
                </tr>
            </table>
            <form action="PaymentPage.jsp" method="post">
            	<input type="hidden" name="userID" value="<%= request.getParameter("userID") %>">
            	<input type="hidden" name="totalPrice" value="<%= totalPrice %>">
            	<button type="submit" class="normal" name="AddCart">Proceed to checkout</button>
            </form>
        
            
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
	