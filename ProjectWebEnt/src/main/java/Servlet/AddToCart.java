package Servlet;

import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String dbUrl = "jdbc:mysql://localhost:3306/users_register";
        String dbUser = "root";
        String dbPassword = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            
            String sql = "SELECT * FROM cart ORDER BY cartID";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            String sql2 = "SELECT * FROM product BY productID";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(sql2);
            
            int cartID = 0;
            int userID = Integer.parseInt(request.getParameter("userID"));
            double zero = 0;
            
            while(rs.next()) {
            	cartID = rs.getInt("cartID");
            }
            
            cartID += 1;
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO cart VALUE(?,?,?)");
            ps.setInt(1, cartID);
            ps.setDouble(2, zero);
            ps.setInt(3, userID);
            ps.executeUpdate();
            
            double totalPrice = 0.00;
            
            while(rs2.next()) {
            	int productID = rs2.getInt("productID");
            	double productPrice = rs2.getDouble("productPrice");
            	
            	String checkPID = request.getParameter("productID" + productID);
            	if(checkPID != null) {
            		int checkProductID = Integer.parseInt(checkPID);
            		
            		if(checkProductID == productID) {
            			String checkSize = request.getParameter("size" + productID);
            			String checkQuantity = request.getParameter("quantity" + productID);
            			int quantity = Integer.parseInt(checkQuantity);
            			
            			double subTotal = quantity*productPrice;
            			totalPrice += subTotal;
            			
            			PreparedStatement ps2 = conn.prepareStatement("INSERT INTO cartItems VALUE(?,?,?,?,?)");
            			
            			ps2.setInt(1, productID);
            			ps2.setInt(2, cartID);
            			ps2.setString(3, checkSize);
            			ps2.setInt(4, quantity);
            			ps2.setDouble(5, subTotal);
            			ps2.executeUpdate();
            			
            		}
            	}
            }
            
            String sql3 = "UPDATE cart SET totalPrice = " + totalPrice + "WHERE cartID = " + cartID;
            PreparedStatement ps3 = conn.prepareStatement(sql3);
            ps3.executeUpdate();
            response.sendRedirect("cart.jsp?userID=" + userID + "&cartID=" + cartID);
    
        } catch (SQLException e2) {
           System.out.println(e2);
        }
        out.close();
        
    }
}
