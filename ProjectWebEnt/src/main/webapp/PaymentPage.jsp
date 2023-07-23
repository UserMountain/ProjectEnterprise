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
    
    <link rel="stylesheet" href="PaymentCSS.css">

</head>
<body>

<% 		int userID = Integer.parseInt(request.getParameter("userID"));
		double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
		
      
                %>

<div class="container">

    <form action="Receipt" method = "post">

        <div class="row">

            <div class="col">

                <h3 class="title">Billing address</h3>

                <div class="inputBox">
                    <span>full name :</span>
                    <input type="text" name="fullName" placeholder="john deo">
                </div>
                <div class="inputBox">
                    <span>email :</span>
                    <input type="email" name="emailReceive" placeholder="example@example.com">
                </div>
                <div class="inputBox">
                    <span>address :</span>
                    <input type="text" name="address" placeholder="room - street - locality">
                </div>
                <div class="inputBox">
                    <span>city :</span>
                    <input type="text" name="city" placeholder="Balik Pulau">
                </div>

                <div class="flex">
                    <div class="inputBox">
                        <span>state :</span>
                        <input type="text" name="state" placeholder="Penang">
                    </div>
                    <div class="inputBox">
                        <span>post code :</span>
                        <input type="text" name="postCode" placeholder="11000">
                    </div>
                </div>

            </div>

            <div class="col">

                <h3 class="title">payment</h3>

                <div class="inputBox">
                    <span>cards accepted :</span>
                    <img src="picture/card_img.png" alt="">
                </div>
                <div class="inputBox">
                    <span>name on card :</span>
                    <input type="text" name="cardName" placeholder="mr. john deo">
                </div>
                <div class="inputBox">
                    <span>credit card number :</span>
                    <input type="number" name="cardNumber" placeholder="1111-2222-3333-4444">
                </div>
                <div class="inputBox">
                    <span>exp month :</span>
                    <input type="text" name="cardMonth" placeholder="january">
                </div>

                <div class="flex">
                    <div class="inputBox">
                        <span>exp year :</span>
                        <input type="number" name="cardYear" placeholder="2022">
                    </div>
                    <div class="inputBox">
                        <span>CVV :</span>
                        <input type="text" name="cvv" placeholder="1234">
                    </div>
                </div>

            </div>
    
        </div>

        <input type="submit" value="proceed to checkout" class="submit-btn" name="Receipt">
		<input type="hidden" name="userID" value="<%= userID %>">
		<input type="hidden" name="totalPrice" value="<%= totalPrice %>">
		
    </form>

</div>    


</body>
</html>