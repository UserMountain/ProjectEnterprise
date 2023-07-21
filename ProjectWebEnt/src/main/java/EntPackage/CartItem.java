package EntPackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartItem {
	private int productID;
	private int cartID;
	private String size;
    private int quantity;
    private double subTotal;
	
	public CartItem() {
	}
	
	public CartItem(int productID, int cartID, String size, int quantity, double subTotal) {
        this.productID = productID;
        this.cartID = cartID;
        this.size = size;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }
	
	public int getProductID() {
		return productID;
	}
	public int getCartID() {
		return cartID;
	}
	public String getSize() {
		return size;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getSubTotal() {
		return subTotal;
	}

	
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	
	public List<Integer> getProductIDs() {
        List<Integer> productIDs = new ArrayList<>();

        // Java code to connect to the database and retrieve staff IDs
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_register", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT productID FROM cartItems ORDER BY productID");
            while (rs.next()) {
            	productIDs.add(rs.getInt("productID"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productIDs;
    }
    
	public List<Integer> getCartIDs() {
        List<Integer> cartIDs = new ArrayList<>();

        // Java code to connect to the database and retrieve staff IDs
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_register", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT cartID FROM cartItems ORDER BY productID");
            while (rs.next()) {
            	cartIDs.add(rs.getInt("cartID"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cartIDs;
    }
    
	public List<String> getSizes() {
        List<String> sizes = new ArrayList<>();

        // Java code to connect to the database and retrieve staff IDs
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_register", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT size FROM cartItems ORDER BY productID");
            while (rs.next()) {
            	sizes.add(rs.getString("size"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sizes;
    }
    
	public List<Integer> getQuantitys() {
        List<Integer> quantitys = new ArrayList<>();

        // Java code to connect to the database and retrieve staff IDs
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_register", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT quantity FROM cartItems ORDER BY productID");
            while (rs.next()) {
            	quantitys.add(rs.getInt("quantity"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return quantitys;
    }
    
	public List<Double> getSubTotals() {
        List<Double> subTotals = new ArrayList<>();

        // Java code to connect to the database and retrieve staff IDs
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_register", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT subTotal FROM cartItems ORDER BY productID");
            while (rs.next()) {
            	subTotals.add(rs.getDouble("subTotal"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return subTotals;
    }
    
   
}
