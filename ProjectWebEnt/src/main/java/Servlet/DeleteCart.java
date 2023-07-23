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

@WebServlet("/DeleteCart")
public class DeleteCart extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the cartID to delete from the request parameter
        int cartID = Integer.parseInt(request.getParameter("cartID"));
        int userID = Integer.parseInt(request.getParameter("userID"));

        try {
            String dbURL = "jdbc:mysql://localhost:3306/enterprise";
            String dbUser = "root";
            String dbPassword = "root";

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM cartItems WHERE cartID = ?");
            stmt.setInt(1, cartID);

            // Execute the delete operation
            stmt.executeUpdate();

            stmt.close();
            conn.close();

            // Redirect back to the cart.jsp after successful deletion
            response.sendRedirect("cart.jsp?userID=" + userID);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }
}
