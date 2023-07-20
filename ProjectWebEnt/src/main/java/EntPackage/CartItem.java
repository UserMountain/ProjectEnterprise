package EntPackage;

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
}
