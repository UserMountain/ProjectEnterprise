package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class UserRegistration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    	
    	int userID = 0;
    	String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");

        try {
        	String dbURL = "jdbc:mysql://localhost:3306/users_register";
            String dbUser = "root";
            String dbPassword = "root";
        	 Class.forName("com.mysql.cj.jdbc.Driver");
        	 Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
        	 Statement stmt = conn.createStatement();
        	 String sql = "SELECT userID * FROM customer ORDER BY userID ASC";
        	 ResultSet rs = stmt.executeQuery(sql);
        	 
        	 while(rs.next()) {
        		 userID = rs.getInt("userID");
        	 }
        	 
        	 userID = userID + 1;
        	 
        	 PreparedStatement statement = conn.prepareStatement("INSERT INTO customer VALUES (?, ?, ?, ?)");
        	 statement.setInt(1, userID);
        	 statement.setString(2, userName);
             statement.setString(3, userEmail);
             statement.setString(4, userPassword);
             statement.executeUpdate();
             
             response.sendRedirect("TestingShop.jsp?userID=" + userID);
        	 
        }catch (Exception e2) {
        	System.out.println(e2);
        }
        out.close();

    }
}