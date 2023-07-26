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
 * Servlet implementation class addProduct
 */
@WebServlet("/addProduct")
public class addProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String addProdName = request.getParameter("productName");
		double addProdPrice = Double.parseDouble(request.getParameter("productPrice"));
		String addProdCat = request.getParameter("productCategory");
		String addProdDesc = request.getParameter("productDesc");
		String addProdImage = request.getParameter("productImage");       
        
        try {
            // Assuming you have already established a database connection using JDBC
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprise", "root", "root");
            

            // Insert data into cartDetails table
            String insertQuery = "INSERT INTO product (productName, productPrice, productCategory, productDesc, productImage) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setString(1, addProdName);
            insertStmt.setDouble(2, addProdPrice); // Replace 'productId' with the actual product ID
            insertStmt.setString(3, addProdCat);
            insertStmt.setString(4, addProdDesc);
            insertStmt.setString(5, addProdImage);
            //insertStmt.setString(6, statusPay);
            insertStmt.executeUpdate();

            insertStmt.close();
            conn.close();

            // Redirect the user to a confirmation page or cart summary page.
            response.sendRedirect("staffDashboard.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors
        }
	}

}
