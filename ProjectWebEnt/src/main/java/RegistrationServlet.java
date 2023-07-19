

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upwd = request.getParameter("password");
		RequestDispatcher dispatcher = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Enterprise", "root", "root");
            PreparedStatement ps = con.prepareStatement("insert into users(name,email,password) values(?,?,?)");
            ps.setString(1, uname);
            ps.setString(1, uemail);
            ps.setString(2, upwd);
            
            int rowCount = ps.executeUpdate();
            dispatcher = request.getRequestDispatcher("loginRegister.jsp");
            if (rowCount > 0) {
            	request.setAttribute("status", "success");
            }else {
            	request.setAttribute("status", "fail");
            }
            
            dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
