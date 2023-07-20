package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UsersLogin")
public class UsersLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");

        String dbURL = "jdbc:mysql://localhost:3306/users_register";
        String dbUser = "root";
        String dbPassword = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);

            String sql = "SELECT * FROM customer WHERE userEmail = ? AND userPassword = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, userEmail);
            statement.setString(2, hashedAndSalted(userPassword)); // Replace this with your password hashing logic

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                // Login successful
                response.sendRedirect("TestingShop.jsp");
            } else {
                // Login failed
                response.sendRedirect("loginRegister.jsp");
            }

            statement.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("loginRegister.jsp");
        }
    }

    // Replace this method with your own password hashing and salting logic
    private String hashedAndSalted(String password) {
        // Implement your password hashing logic here
        return password;
    }
}