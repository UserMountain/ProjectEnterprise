package Servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="staffLoginServlet", urlPatterns= {"/staffLoginServlet"})
public class staffLoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String checkEmail = request.getParameter("staffEmail");
  String checkPassword = request.getParameter("staffPassword");
  int stafID = 0;
  boolean check = false;
  String errorMessage = "";
  
  RequestDispatcher dispatcher = null;
  try {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprise", "root", "root");
	    
	    Statement stmt = con.createStatement();
	    String sql = "SELECT * FROM staff";
	    ResultSet rs = stmt.executeQuery(sql);
	    
	    while(rs.next()) {
		      String email = rs.getString("staffEmail");
		      String password = rs.getString("staffPassword");
		      stafID = rs.getInt("stafID");
      
		      if(email.equalsIgnoreCase(checkEmail) && password.equalsIgnoreCase(checkPassword)){
			      check = true;
			      break;
			      }
	    }
    
	    if (check == true)
	    	response.sendRedirect( "Admin Page.html?stafID=" + stafID);
    
	    else if (check == false) {
	    	request.setAttribute("status", "failed");
	    	dispatcher = request.getRequestDispatcher("staffLogin.jsp");
	    }
	    dispatcher.forward(request, response);

	  }catch(Exception e2) {
		  System.out.println(e2);
	  	}
  	out.close();
  	
  }  
  
}