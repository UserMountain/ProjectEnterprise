package DaoPackage;

import java.sql.*;
import java.util.*;
import EntPackage.Product;

public class ProductDAO {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/enterprise";
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
                double productPrice = rs.getDouble("productPrice");
                String productCategory = rs.getString("productCategory");
                String productDesc = rs.getString("productDesc");
                String productImage = rs.getString("productImage"); // Assuming the image filename is stored in the database.

                Product product = new Product(productID, productName, productPrice, productCategory, productDesc, productImage);
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
                double prodPrice = rs.getDouble("productPrice");
                String prodCategory = rs.getString("productCategory");
                String prodDesc = rs.getString("productDesc");
                String prodImage = rs.getString("productImage");

                return new Product(prodID, prodName, prodPrice, prodCategory, prodDesc, prodImage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Product not found
    }
}
