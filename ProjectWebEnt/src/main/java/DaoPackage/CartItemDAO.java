package DaoPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import EntPackage.Cart;

public class CartItemDAO {
    private String DB_URL = "jdbc:mysql://localhost:3306/users_register";
    private String DB_USER = "root";
    private String DB_PASSWORD = "root";

    public void insertCartItem(Cart cartItem) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO cartItems (productID, productName, productPrice) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, cartItem.getProductID());
                pstmt.setString(2, cartItem.getProductName());
                pstmt.setDouble(3, cartItem.getProductPrice());
          

                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Cart> getAllCartItems() {
        List<Cart> cartItems = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT * FROM cartItems";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                    	int productId = rs.getInt("productID");
                        String productName = rs.getString("productName");
                        double price = rs.getDouble("productPrice");

                        Cart cartItem = new Cart();
                        cartItem.setProductID(productId);
                        cartItem.setProductName(productName);
                        cartItem.setProductPrice(price);
        

                        cartItems.add(cartItem);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartItems;
    }

    // Additional methods (if needed) for retrieving or managing cart items in the future
    // ...
}
