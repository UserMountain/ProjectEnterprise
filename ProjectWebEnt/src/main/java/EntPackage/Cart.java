package EntPackage;

public class Cart extends Product{
	private String productName;
    private double productPrice;
    private int quantity;
    private double subTotal;
	
	public Cart() {
	}
	
	public Cart(String productName, double productPrice, int quantity, double subTotal) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }
	
	public String getProductName() {
		return productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getSubTotal() {
		return subTotal;
	}

	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
}