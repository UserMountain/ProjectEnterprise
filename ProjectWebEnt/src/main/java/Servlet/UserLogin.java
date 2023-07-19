package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginRegister")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email-login");
		String password = request.getParameter("password-login");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Enterprise", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * from users where email = ? and password = ?");
            ps.setString(1, email);
            ps.setString(2, password);
			
            ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				session.setAttribute("name", rs.getString("name"));
				dispatcher = request.getRequestDispatcher("shop.jsp");
			} else {
				request.setAttribute("status","fail");
				dispatcher = request.getRequestDispatcher("loginRegister.jsp");
			}
			dispatcher.forward(request, response);

		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		} 

	}
}