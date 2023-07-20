package Servlet;

import EntPackage.*;
import DaoPackage.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productID"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String productName = request.getParameter("productName");
        String size = request.getParameter("size");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        

        // Fetch the product details from the database using ProductDAO (if needed)
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductById(productId);
        
        double subTotal = productPrice * quantity;
        
        // Create a CartItem object
        CartItem cartItem = new CartItem();
        cartItem.setProductID(productId);
        cartItem.setProductName(productName);
        cartItem.setSize(size);
        cartItem.setQuantity(quantity);
        cartItem.setProductPrice(productPrice);
        cartItem.setSubTotal(subTotal);

        // Store the cart item in the database using CartItemDAO
        CartItemDAO cartItemDAO = new CartItemDAO();
        cartItemDAO.insertCartItem(cartItem);

        // Redirect back to the showProduct.jsp to continue shopping or view the cart
        response.sendRedirect("cart.jsp?productId=" + productId);
    }
}
