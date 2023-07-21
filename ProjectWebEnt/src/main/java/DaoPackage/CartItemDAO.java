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
    
    public List<CartItem> getCartItemsForUser() {
    	List<CartItem> cartItems = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Query to retrieve cart items for the given user (replace 'your-cart-items-table' with your cart items table name)
            String query = "SELECT * FROM cartItems ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);

            // Iterate through the results and create CartItem objects to store the details
            while (resultSet.next()) {
                int productID = resultSet.getInt("productID");
                int cartID = resultSet.getInt("cartID");
                String size = resultSet.getString("size");
                int quantity = resultSet.getInt("quantity");
                double subTotal = resultSet.getDouble("subTotal");
                CartItem cartItem = new CartItem(productID, cartID, size, quantity, subTotal);
                cartItems.add(cartItem);
            }

   
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cartItems;
    }
}
