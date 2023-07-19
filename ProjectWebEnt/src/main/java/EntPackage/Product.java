package EntPackage;

public class Product {
	private String name;
	private String category;
	private Double price;
	private String size;
	
	
	public Product() {
	}

	
	public Product(String name, String category, Double price, String image) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
	}
	public Double getPrice() {
		return price;
	}
	public String getSize() {
		return size;
	}
	

	
	public void setName(String name) {
		this.name = name;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setSize(String size) {
		this.size = size;
	}

	
}