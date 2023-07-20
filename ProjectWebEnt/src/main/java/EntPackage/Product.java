package EntPackage;

public class Product {
	private int productID;
	private String productName;
	private double productPrice;
	private String productCategory;
	private String productDesc;
	private String productImage;
	
	public Product() {
	}

	
	public Product(int productID, String productName, double productPrice, String productCategory, String productDesc, String productImage) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productDesc = productDesc;
		this.productImage = productImage;
	}
	
	public int getProductID() {
		return productID;
	}
	public String getProductName() {
		return productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public String getProductImage() {
		return productImage;
	}
	
	
	
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public void setProductDescription(String prodcutDesc) {
		this.productDesc = prodcutDesc;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	
}