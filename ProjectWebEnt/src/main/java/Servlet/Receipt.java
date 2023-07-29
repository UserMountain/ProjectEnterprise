package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Receipt", urlPatterns= {"/Receipt"})
public class Receipt extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get size and quantity from the form
        int userID = Integer.parseInt(request.getParameter("userID"));
        String fullName = request.getParameter("fullName");
        String emailReceive = request.getParameter("emailReceive");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postCode = request.getParameter("postCode");
        String cardName = request.getParameter("cardName");
        String cardNumber = request.getParameter("cardNumber");
        String cardMonth = request.getParameter("cardMonth");
        String cardYear = request.getParameter("cardYear");
        String cvv = request.getParameter("cvv");
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));

        try {
            // Assuming you have already established a database connection using JDBC
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprise", "root", "root");
            
            PreparedStatement updateCartStmt = conn.prepareStatement("UPDATE cartItems SET statusPay = \"true\" WHERE userID = ?");
            updateCartStmt.setInt(1, userID);
            updateCartStmt.executeUpdate();
            updateCartStmt.close();
            
            // Insert data into cartDetails table
            String insertQuery = "INSERT INTO payment (userID, fullName, emailReceive, address, city, state, postCode, cardName, cardNumber, cardMonth, cardYear, cvv, totalPrice) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setInt(1, userID);
            insertStmt.setString(2, fullName);
            insertStmt.setString(3, emailReceive);
            insertStmt.setString(4, address);
            insertStmt.setString(5, city);
            insertStmt.setString(6, state);
            insertStmt.setString(7, postCode); 
            insertStmt.setString(8, cardName);
            insertStmt.setString(9, cardNumber); 
            insertStmt.setString(10, cardMonth);
            insertStmt.setString(11, cardYear);
            insertStmt.setString(12, cvv);
            insertStmt.setDouble(13, totalPrice);
            
            insertStmt.executeUpdate();
            insertStmt.close();
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("  <meta charset=\"UTF-8\">");
            out.println("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("  <title>Clothing Shop Receipt</title>");
            out.println("  <link rel=\"stylesheet\" href=\"receipt.css\">");
            out.println("  <link href=\"https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap\" rel=\"stylesheet\">");
            out.println("  <link href=\"https://fonts.googleapis.com/css2?family=Pacifico&display=swap\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("  <div class=\"page\">");
            out.println("    <h1 class=\"f\">RECEIPT</h1>");
            out.println("    <img src=\"picture/logo3.png\" class=\"logo\" alt=\"Stamp Image\">");
            out.println("    <div class=\"address\">");
            out.println("      <p><b>HipStrike Inc.</b></p>");
            out.println("      <p> No 5 Jalan Genting Emas</p>");
            out.println("      <p>Balik Pulau, Penang</p>");
            out.println("    </div>");
            out.println("    <div class=\"shipping-info\">");
            out.println("      <div class=\"bill-to\">");
            out.println("        <h6>BILL TO</h6>");
            out.println("        <p>SwiiffStar Remax</p>");
            out.println("        <p>The Summit 1.13A Psn Kewajipan</p>");
            out.println("        <p>Taman Seafield Jaya Petaling Jaya,</p>");
            out.println("        <p>Selangor, 47610<p>");
            out.println("      </div>");
            out.println("      <div class=\"ship-to\">");
            out.println("        <h6>SHIP TO</h6>");
            out.println("        <p>" + fullName + "</p>");
            out.println("        <p>" + address + "</p>");
            out.println("        <p>" + state + ", " + postCode + "</p>");
            out.println("      </div>");
            out.println("      <div class=\"receipt-info\">");
            out.println("        <h6>RECEIPT#</h6>");
            out.println("        <p>US-001</p>");
            out.println("        <h6>RECEIPT DATE</h6>");
            out.println("        <p>11/02/2023</p>");
            out.println("        <h6>P.O.#</h6>");
            out.println("        <p>2023/2019</p>");
            out.println("        <h6>DUE DATE</h6>");
            out.println("        <p>26/2/2023</p>");
            out.println("      </div>");
            out.println("    </div>");
            out.println("    <hr class=\"top\">");
            out.println("    <div class=\"main-strip\">");
            out.println("      <h6>QTY</h6>");
            out.println("      <h6>DESCRIPTION</h6>");
            out.println("      <h6>UNIT PRICE</h6>");
            out.println("      <h6>AMOUNT</h6>");
            out.println("    </div>");
            out.println("    <hr class=\"bottom\">");
                        
            Statement collectStmt = conn.createStatement();
            String sql = "SELECT productID, size, quantity, subTotal FROM cartItems WHERE userID =" + userID;
            ResultSet rs = collectStmt.executeQuery(sql);
            
            while(rs.next()) {
            	//String productName = rs.getString("productName");
            	int productID = rs.getInt("productID");
            	String size = rs.getString("size");
            	int quantity = rs.getInt("quantity");
            	double subTotal = rs.getDouble("subTotal");
            	//double productPrice = rs.getDouble("productPrice");
            	
            	out.println("    <div class=\"shipping-item\">");
                out.println("      <p>" + quantity + "</p>");
   
                Statement collectStmt2 = conn.createStatement();
                String sql2 = "SELECT productName, productPrice FROM product WHERE productID =" + productID;
                ResultSet rs2 = collectStmt2.executeQuery(sql2);
                
                while(rs2.next()) {
                	
                	String productName = rs2.getString("productName");
                	double productPrice = rs2.getDouble("productPrice");
                	
                	out.println("      <p>" + productName + "</p>");
                    out.println("      <p>RM " + productPrice + "</p>");         
      
                }
                rs2.close();
                collectStmt2.close();

                out.println("      <p>RM " + subTotal + "</p>");
                out.println("    </div>");
                               
            }                 
                                             
            out.println("    <div class=\"total\">");
            out.println("      <p>Subtotal</p>");
            out.println("      <p>RM " + totalPrice + "</p>");
            out.println("    </div>");
            out.println("    <div class=\"total\">");
            out.println("      <h6>TOTAL</h6>");
            out.println("      <h6>RM " + totalPrice + "</h6>");
            out.println("    </div>");
            out.println("    <div class=\"theTitle active\">");
            out.println("      <div class=\"left\">");
            out.println("        <h1>Thank You</h1>");
            out.println("      </div>");
            out.println("      <span class=\"separator\"></span>");
            out.println("      <div class=\"right\">");
            out.println("        <p>Have a nice days!</p>");
            out.println("        <a href=\"Nav_bar.jsp?userID=" + userID + "\" class=\"btn-back\">Back to Dashboard</a>");
            out.println("      </div>");
            out.println("    </div>");
            out.println("  </div>");
            out.println("</body>");
            out.println("</html>");
            
            
            rs.close();
            collectStmt.close();

            PreparedStatement deleteCartStmt = conn.prepareStatement("DELETE FROM cartItems WHERE userID = ? AND statusPay = \"true\"");
            deleteCartStmt.setInt(1, userID);
            deleteCartStmt.executeUpdate();
            deleteCartStmt.close();
            
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors
        }
    }
}