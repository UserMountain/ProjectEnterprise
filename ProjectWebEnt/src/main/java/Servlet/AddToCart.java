package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Assuming 'userId' is available in the session after login
        //int userId = (int) request.getSession().getAttribute("userId");

        // Get the data from showDisplay.jsp
        int productID = Integer.parseInt(request.getParameter("productID"));
        String productName = request.getParameter("productName");
        String size = request.getParameter("size");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));

        // Calculate subtotal
        double subTotal = productPrice * quantity;
        int userID = 1;
        int cartID = 3;
        double totalPrice = 0.00;
        
        String dbUrl = "jdbc:mysql://localhost:3306/users_register";
        String dbUser = "root";
        String dbPassword = "root";

        try {
            // Establish database connection
         
            // Insert the cart item into the database
            String sql = "INSERT INTO cart (totalPrice, userID) " + "VALUES (?, ?)";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, totalPrice);
            pstmt.setInt(2, userID);
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle any exceptions here and redirect to an error page if necessary
        }
        
        try {
            // Establish database connection
         
            // Insert the cart item into the database
            String sql = "INSERT INTO cartItems (productID, cartID, size, quantity, subTotal) " + "VALUES (?, ?, ?, ?, ?)";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productID);
            pstmt.setInt(2, cartID);
            pstmt.setString(3, size);
            pstmt.setInt(4, quantity);
            pstmt.setDouble(5, subTotal);
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle any exceptions here and redirect to an error page if necessary
        }
        
     // Redirect to the cart.jsp to display the updated cart
        response.sendRedirect("cart.jsp");
    }
}
