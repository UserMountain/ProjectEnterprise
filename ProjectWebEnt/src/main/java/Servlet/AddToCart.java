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

        // Fetch the product details from the database using ProductDAO (if needed)
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductById(productId);

        // Create a CartItem object
        Cart cartItem = new Cart();
        cartItem.setProductID(productId);
        cartItem.setProductName(product.getProductName());
        cartItem.setProductPrice(product.getProductPrice());
        cartItem.setQuantity(quantity);
        cartItem.setSubTotal(product.getProductPrice() * quantity);

        // Store the cart item in the database using CartItemDAO
        CartItemDAO cartItemDAO = new CartItemDAO();
        cartItemDAO.insertCartItem(cartItem);

        // Redirect back to the showProduct.jsp to continue shopping or view the cart
        response.sendRedirect("TestingCart.jsp?productId=" + productId);
    }
}
