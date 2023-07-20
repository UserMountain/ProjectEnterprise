<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="DaoPackage.CartItemDAO" %>
<%@ page import="EntPackage.Cart" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
    <h2>Shopping Cart</h2>
    <table>
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Price</th>

        </tr>
        <% CartItemDAO cartItemDAO = new CartItemDAO();
           List<Cart> cartItems = cartItemDAO.getAllCartItems();
           for (Cart cartItem : cartItems) { %>
            <tr>
                <td><%= cartItem.getProductID() %></td>
                <td><%= cartItem.getProductName() %></td>
                <td><%= cartItem.getProductName() %></td>

            </tr>
        <% } %>
    </table>
</body>
</html>
