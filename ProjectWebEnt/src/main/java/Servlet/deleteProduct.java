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

/**
 * Servlet implementation class deleteProduct
 */
@WebServlet("/deleteProduct")
public class deleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productID = Integer.parseInt(request.getParameter("productID"));

        try {
            String dbURL = "jdbc:mysql://localhost:3306/enterprise";
            String dbUser = "root";
            String dbPassword = "root";

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM product WHERE productID = ?");
            stmt.setInt(1, productID);

            // Execute the delete operation
            stmt.executeUpdate();

            stmt.close();
            conn.close();

            // Redirect back to the cart.jsp after successful deletion
            response.sendRedirect("staffDashboard.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
	}

}
