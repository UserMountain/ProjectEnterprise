package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            // Update the database connection details accordingly
            String dbURL = "jdbc:mysql://localhost:3306/users_register";
            String dbUser = "root";
            String dbPassword = "root";

            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);

            // Prepare the SQL statement
            String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);

            // Execute the statement
            int rowsInserted = statement.executeUpdate();
            statement.close();
            conn.close();

            // Redirect to a success page after successful registration
            if (rowsInserted > 0) {
                response.sendRedirect("shop.jsp");
            } else {
                response.sendRedirect("loginRegister.jsp");
            }
    
            
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("loginRegister.jsp");
        }
    }
}