package Servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsersLogin", urlPatterns = {"/UsersLogin"})
public class UsersLogin extends HttpServlet {
  private static final long serialVersionUID = 1L;
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String checkUsername = request.getParameter("userEmail");
  String checkPassword = request.getParameter("userPassword");
  int userID = 0;
  boolean check = false;
  
  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_register", "root", "root");
    
    Statement stmt = con.createStatement();
    String sql = "SELECT * FROM customer";
    ResultSet rs = stmt.executeQuery(sql);
    
    while(rs.next()) {
      String username = rs.getString("userEmail");
      String password = rs.getString("userEmail");
      userID = rs.getInt("userID");
      
      if(username.equalsIgnoreCase(checkUsername) && password.equalsIgnoreCase(checkPassword)) 
      {
      check = true;
      break;
      }
    }
    
    if (check == true)
      response.sendRedirect( "TestingShop.jsp?userID=" + userID);
    
    else if (check == false)
      response.sendRedirect("loginRegister.jsp");
  }
  catch(Exception e2) {
    System.out.println(e2);
  }
  out.close();
  }  
}