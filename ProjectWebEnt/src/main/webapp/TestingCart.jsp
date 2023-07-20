<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
    <h2>Shopping Cart</h2>

    <table border="1">
        <tr>
            <th>Product Name</th>
            <th>Size</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Subtotal</th>
        </tr>
        <% 
            // Replace this with the actual product ID for which you want to display cart items

            // Format for displaying currency values
            java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");

            // Database connection parameters
            String dbUrl = "jdbc:mysql://localhost:3306/users_register";
            String dbUser = "root";
            String dbPassword = "root";
			int productID = 1004;
            try {
                // Establish database connection
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

                // Retrieve cart items from the database
                String sql = "SELECT * FROM cartItems WHERE productID = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                
                pstmt.setInt(1, productID);
                ResultSet rs = pstmt.executeQuery();

                // Iterate through the cart items and display them in the table
                while (rs.next()) {
                	productID = rs.getInt("productID");
                    int cartID = rs.getInt("cartID");
                    String size = rs.getString("size");
                    int quantity = rs.getInt("quantity");
                    double subTotal = rs.getDouble("subTotal");
        %>
        <tr>
        	<td><%= productID %></td>
            <td><%= cartID %></td>
            <td><%= size %></td>
            <td><%= quantity %></td>
            <td>$<%= df.format(subTotal) %></td>
        </tr>
        <% 
                }
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </table>

    <!-- Add other content as needed -->
</body>
</html>
