package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="AddCart", urlPatterns= {"/AddCart"})
public class AddCart extends HttpServlet {

    /**
   * 
   */
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get size and quantity from the form
        String selectedSize = request.getParameter("size");
        int selectedQuantity = Integer.parseInt(request.getParameter("quantity"));
        int selectedProductID = Integer.parseInt(request.getParameter("productID"));

        // Get the custID from the session or authentication mechanism
        int userID = Integer.parseInt(request.getParameter("userID")); // Replace with the actual custID retrieval

        try {
            // Assuming you have already established a database connection using JDBC
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprise", "root", "root");

            // Assuming you have a product table to get product details by productID and size
            String getProductPriceQuery = "SELECT productPrice FROM product WHERE productID = ?";
            PreparedStatement getProductPriceStmt = conn.prepareStatement(getProductPriceQuery);
            getProductPriceStmt.setInt(1, selectedProductID); // Replace 'productId' with the actual product ID
            // Execute the query and get the price of the product
            // For simplicity, let's assume 'price' is a double value.
            
            double price = 0;
            try (ResultSet rs = getProductPriceStmt.executeQuery()) {
                if (rs.next()) {
                    price = rs.getDouble("productPrice");
                }
            }

            // Calculate subTotal
            double subTotal = price * selectedQuantity;

            // Insert data into cartDetails table
            String insertQuery = "INSERT INTO cartItems (productID, userID, size, quantity, subTotal) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setInt(1, selectedProductID);
            insertStmt.setInt(2, userID); // Replace 'productId' with the actual product ID
            insertStmt.setString(3, selectedSize);
            insertStmt.setInt(4, selectedQuantity);
            insertStmt.setDouble(5, subTotal);
            insertStmt.executeUpdate();

            insertStmt.close();
            getProductPriceStmt.close();
            conn.close();

            // Redirect the user to a confirmation page or cart summary page.
            response.sendRedirect("cart.jsp?userID=" + userID);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors
        }
    }
}