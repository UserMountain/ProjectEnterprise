package EntPackage;

public class Cart extends Product{
	private int cartID;
    private double totalPrice;
    private int userID;
	
	public Cart() {
	}
	
	public Cart(int cartID, double totalPrice, int quantity, int userID) {
        this.cartID = cartID;
        this.totalPrice = totalPrice;
        this.userID = userID;
    }
	
	public int getCartID() {
		return cartID;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public int getUserID() {
		return userID;
	}

	
	public void getCartID(int cartID) {
		this.cartID = cartID;
	}
	public void getTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void getUserID(int userID) {
		this.userID = userID;
	}
}