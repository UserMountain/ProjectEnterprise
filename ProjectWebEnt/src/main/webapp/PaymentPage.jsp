<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>

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
                    <input type="text" name="fullName" placeholder="john deo" required>
                </div>
                <div class="inputBox">
                    <span>email :</span>
                    <input type="email" name="emailReceive" placeholder="example@example.com" required>
                </div>
                <div class="inputBox">
                    <span>address :</span>
                    <input type="text" name="address" placeholder="room - street - locality" required>
                </div>
                <div class="inputBox">
                    <span>city :</span>
                    <input type="text" name="city" placeholder="Balik Pulau" required>
                </div>

                <div class="flex">
                    <div class="inputBox">
                        <span>state :</span>
                        <input type="text" name="state" placeholder="Penang" required>
                    </div>
                    <div class="inputBox">
                        <span>post code :</span>
                        <input type="text" name="postCode" placeholder="11000" required>
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
                    <input type="text" name="cardName" placeholder="mr. john deo" required>
                </div>
                <div class="inputBox">
                    <span>credit card number :</span>
                    <input type="number" name="cardNumber" placeholder="1111-2222-3333-4444" required pattern="[0-9]{16}" title="Card Number must have exactly 16 digits" maxlength="16">
                </div>
                <div class="inputBox">
                    <span>exp month :</span>
                    <input type="text" name="cardMonth" placeholder="january" required>
                </div>

                <div class="flex">
                    <div class="inputBox">
                        <span>exp year :</span>
                        <input type="number" name="cardYear" placeholder="2022" required pattern="[0-9]{4}">
                    </div>
                    <div class="inputBox">
                        <span>CVV :</span>
                        <input type="text" name="cvv" placeholder="123" required pattern="[0-9]{3}" title="CVV must have 3 digits">
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