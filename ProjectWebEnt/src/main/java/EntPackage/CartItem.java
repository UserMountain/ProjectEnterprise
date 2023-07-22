package EntPackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartItem {
	private int cartID;
	private int productID;
	private int userID;
	private String size;
    private int quantity;
    private double subTotal;
	
	public CartItem() {
	}
	
	public CartItem(int cartID, int productID, int userID, String size, int quantity, double subTotal) {
		this.cartID = cartID;
		this.productID = productID;
        this.userID = userID;
        this.size = size;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }
	
	
	public int getCartID() {
		return cartID;
	}
	public int getProductID() {
		return productID;
	}
	public int getUserID() {
		return userID;
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

	
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
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
	
}