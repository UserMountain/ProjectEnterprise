package Servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="UserRegister", urlPatterns= {"/UserRegister"})
public class UserRegister extends HttpServlet {
 private static final long serialVersionUID = 1L;
 
	private String jdbcURL = "jdbc:mysql://localhost:3306/enterprise";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("userName");
        String email = request.getParameter("userEmail");
        String password = request.getParameter("userPassword");

        // Validate the form data (You can add more validation if needed)

        try {
        	Class.forName("com.mysql.jdbc.Driver");  
            // Establish a database connection
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            // Create a prepared statement to insert data into the users_register table
            String insertQuery = "INSERT INTO customer (userName, userEmail, userPassword) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(insertQuery);

            // Set the values for the prepared statement
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);

            // Execute the query to insert data
            ps.executeUpdate();

            // Close the resources
            ps.close();
            connection.close();

            // Redirect to a success page or show a success message
            response.sendRedirect("loginRegister.jsp"); // Replace "success.jsp" with your desired success page
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database connection or insertion error here
            // Redirect to an error page or show an error message
            response.sendRedirect("loginRegister.jsp"); // Replace "error.jsp" with your desired error page
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
