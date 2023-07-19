package EntPackage;

public class Product {
	private int productID;
	private String productName;
	private String productCat;
	private double productPrice;
	private String description;
	private String image;
	
	public Product() {
	}

	
	public Product(int productID, String productName, String productCat, double productPrice, String description, String image) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productCat = productCat;
		this.productPrice = productPrice;
		this.description = description;
		this.image = image;
	}
	
	public int getProductID() {
		return productID;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductCat() {
		return productCat;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public String getDescription() {
		return description;
	}
	public String getImage() {
		return image;
	}
	
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductCat(String productCat) {
		this.productCat = productCat;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setImage(String image) {
		this.image = image;
	}

	
}