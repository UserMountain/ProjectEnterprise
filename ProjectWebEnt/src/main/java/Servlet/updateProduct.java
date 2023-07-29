package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/updateProduct")
public class updateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productID = Integer.parseInt(request.getParameter("productID"));
        
        // Update the cart item in the database
        try {
        	
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprise", "root", "root");

            // Assuming you have a product table to get product details by productID and size
            String editQuery = "SELECT productName, productPrice, productCategory, productDesc, productImage FROM product WHERE productID = ?";
            PreparedStatement getProduct = conn.prepareStatement(editQuery);
            getProduct.setInt(1, productID);
            
            ResultSet rs2 = getProduct.executeQuery();
                
            while(rs2.next()) {
            	
            String productName = rs2.getString("productName");
            double productPrice = rs2.getDouble("productPrice");
            String productCategory = rs2.getString("productCategory");
            String productDesc = rs2.getString("productDesc");
            String productImage = rs2.getString("productImage");
            
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"ISO-8859-1\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
            out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">");
            out.println("<title>Shop Clothing Entry Form</title>");
            out.println("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">");
            out.println("<link href=\"https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap\" rel=\"stylesheet\">");
            out.println("<link rel=\"stylesheet\" href=\"Adcrud.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<section class=\"container\">");
            
            out.println("<form action=\"FinishUpdate\" class=\"form\" method=\"post\">");
            out.println("    <!-- For updating existing clothing data -->");
            out.println("    <div class=\"input-box\">");
            out.println("        <label class=\"label\">Clothing ID:</label>");
            out.println("        <input type=\"text\" name=\"productID\" placeholder=\"Enter clothing ID (if updating)\" class=\"input\" value=\""+productID+"\" />");
            out.println("    </div>");
            out.println("    <!-- For creating or updating clothing data -->");
            out.println("    <div class=\"input-box\">");
            out.println("        <label class=\"label\">Clothing Name:</label>");
            out.println("        <input type=\"text\" name=\"productName\" placeholder=\"Enter clothing name\" required class=\"input\" value=\""+productName+"\" />");
            out.println("    </div>");
            out.println("    <div class=\"input-box\">");
            out.println("        <label class=\"label\">Clothing Category:</label>");
            out.println("        <input type=\"text\" name=\"productCategory\" placeholder=\"Enter clothing type (e.g. jersey, polo etc.)\" required class=\"input\" value=\"" + productCategory + "\" />");
            out.println("    </div>");
            out.println("    <div class=\"column\">");
            out.println("        <div class=\"input-box\">");
            out.println("            <label class=\"label\">Price:</label>");
            out.println("            <input type=\"number\" name=\"productPrice\" placeholder=\"Enter price in MYR\" required class=\"input\" value=\"" + productPrice + "\" />");
            out.println("        </div>");
            out.println("    </div>");
            out.println("    <div class=\"input-box\">");
            out.println("        <label class=\"label\">Description:</label>");
            out.println("        <textarea name=\"productDesc\" placeholder=\"Enter clothing description (maximum 80 words)\" value=\"" + productDesc + "\" rows=\"4\" style=\"max-width:100%; width:100%;\" class=\"textarea\"></textarea>");
            out.println("    </div>");
            out.println("    <div class=\"input-box\">");
            out.println("        <label class=\"label\">Image JPG:</label>");
            out.println("        <input type=\"text\" name=\"productImage\" placeholder=\"Enter image JPG\" required class=\"input\" value=\"" + productImage + "\" />");
            out.println("    </div>");
            out.println("    <!-- Buttons for Create and Update operations -->");
            out.println("    <div class=\"buttons\">");     
            out.println("        <button type=\"submit\" name=\"FinishUpdate\" class=\"button\">Update Clothing to Shop</button>");
            out.println("    </div>");
            out.println("</form>");
            
            out.println("</section>");
            out.println("</body>");
            out.println("</html>");
            }
            
            getProduct.close();
            rs2.close();
            conn.close();
 
                
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately and provide user feedback if necessary
        } 

        // Perform any other necessary actions, e.g., updating the cart total, displaying a success message, etc.
        //response.sendRedirect("AdminCRUD.jsp");
        
	}

}
