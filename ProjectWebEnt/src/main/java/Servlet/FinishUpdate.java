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

@WebServlet("/FinishUpdate")
public class FinishUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productID = Integer.parseInt(request.getParameter("productID"));
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        String productCategory = request.getParameter("productCategory");
        String productDesc = request.getParameter("productDesc");
        String productImage = request.getParameter("productImage");
        // Update the cart item in the database
        try {
            String dbURL = "jdbc:mysql://localhost:3306/enterprise";
            String dbUser = "root";
            String dbPassword = "root";
            
            
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
                PreparedStatement stmt = conn.prepareStatement("UPDATE product SET productName = ?, productPrice = ?, productCategory = ? , productDesc = ?, productImage = ? WHERE productID = ?");
                stmt.setString(1, productName);
                stmt.setDouble(2, productPrice);
                stmt.setString(3, productCategory);
                stmt.setString(4, productDesc);
                stmt.setString(5, productImage);
                stmt.setInt(6, productID);

                // Execute the update operation
                stmt.executeUpdate();

                stmt.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately and provide user feedback if necessary
        }

        // Perform any other necessary actions, e.g., updating the cart total, displaying a success message, etc.
        response.sendRedirect("AdminCRUD.jsp");
	}

}
