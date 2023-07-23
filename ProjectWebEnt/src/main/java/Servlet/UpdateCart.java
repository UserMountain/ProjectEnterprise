package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateCart")
public class UpdateCart extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the cartID and updated quantity from the request parameters
        int cartID = Integer.parseInt(request.getParameter("cartID"));
        int updatedQuantity = Integer.parseInt(request.getParameter("quantity"));
        int userID = Integer.parseInt(request.getParameter("userID"));
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        double subTotal = Double.parseDouble(request.getParameter("subTotal"));
        // Update the cart item in the database
        try {
            String dbURL = "jdbc:mysql://localhost:3306/enterprise";
            String dbUser = "root";
            String dbPassword = "root";
            
            subTotal = productPrice*updatedQuantity;
            

            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
                PreparedStatement stmt = conn.prepareStatement("UPDATE cartItems SET quantity = ?, subTotal = ? WHERE cartID = ?");
                stmt.setInt(1, updatedQuantity);
                stmt.setDouble(2, subTotal);
                stmt.setInt(3, cartID);

                // Execute the update operation
                stmt.executeUpdate();

                stmt.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately and provide user feedback if necessary
        }

        // Perform any other necessary actions, e.g., updating the cart total, displaying a success message, etc.
        response.sendRedirect("cart.jsp?userID=" + userID);
    }
}
