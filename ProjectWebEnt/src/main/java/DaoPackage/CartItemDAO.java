package DaoPackage;

import EntPackage.CartItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import EntPackage.Cart;
import EntPackage.CartItem;

public class CartItemDAO {
    private String DB_URL = "jdbc:mysql://localhost:3306/users_register";
    private String DB_USER = "root";
    private String DB_PASSWORD = "root";

    public void insertCartItem(CartItem cartItem) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO cartItems (productID, cartID, size, quantity, subTotal) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, cartItem.getProductID());
                pstmt.setInt(2, cartItem.getCartID());
                pstmt.setString(3, cartItem.getSize());
                pstmt.setInt(4, cartItem.getQuantity());
                pstmt.setDouble(5, cartItem.getSubTotal());
          

                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<CartItem> getCartItemsByProductID(int productID) {
        List<CartItem> cartItems = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT * FROM cartItems WHERE productID = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, productID);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        int cartID = rs.getInt("cartID");
                        String size = rs.getString("size");
                        int quantity = rs.getInt("quantity");
                        double subTotal = rs.getDouble("subTotal");

                        CartItem cartItem = new CartItem();
                        cartItem.setProductID(productID);
                        cartItem.setCartID(cartID);
                        cartItem.setSize(size);
                        cartItem.setQuantity(quantity);
                        cartItem.setSubTotal(subTotal);

                        cartItems.add(cartItem);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartItems;
    }

}
