package DaoPackage;

import java.sql.*;
import java.util.*;
import EntPackage.Product;

public class ProductDAO {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/users_register";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM product";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int productID = rs.getInt("productID");
                String productName = rs.getString("productName");
                String productCat = rs.getString("productCat");
                double productPrice = rs.getDouble("productPrice");
                String description = rs.getString("description");
                String image = rs.getString("image"); // Assuming the image filename is stored in the database.

                Product product = new Product(productID, productName, productCat, productPrice, description, image);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
    
    public Product getProductById(int productID) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM product WHERE productID = ?")) {

            stmt.setInt(1, productID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int prodID = rs.getInt("productID");
                String prodName = rs.getString("productName");
                String prodCat = rs.getString("productCat");
                double prodPrice = rs.getDouble("productPrice");
                String desc = rs.getString("description");
                String imag = rs.getString("image");

                return new Product(prodID, prodName, prodCat, prodPrice, desc, imag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Product not found
    }
}
