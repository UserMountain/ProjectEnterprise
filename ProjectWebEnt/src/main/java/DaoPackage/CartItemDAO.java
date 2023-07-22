package DaoPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import EntPackage.CartItem;

public class CartItemDAO {
    // Other code remains the same as provided in the previous example

	int selectedProductID = Integer.parseInt(request.getParameter("productID"));
	
    // Get cart items for a specific userID from the database
    public List<CartItem> getCartItemsForUserID(int userID) {
        List<CartItem> cartItems = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT productID, size, quantity, subTotal " +
                     "FROM cartItems WHERE userID = ?")) {

            // Set the userID parameter in the prepared statement
            preparedStatement.setInt(1, userID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    CartItem cartItem = new CartItem();
                    cartItem.setProductImage(resultSet.getString("productImage"));
                    cartItem.setProductPrice(resultSet.getDouble("productPrice"));
                    cartItem.setProductQuantity(resultSet.getInt("productQuantity"));
                    cartItem.setProductName(resultSet.getString("productName"));
                    cartItems.add(cartItem);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
        return cartItems;
    }

	private Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}
