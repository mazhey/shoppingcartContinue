package shoppingCart;

import java.io.Serializable;
import java.util.ArrayList;



public class ProductJB implements Serializable{
	private long productId;
	private String productname;
	private double price;
	private String description;
	private String date;
    private ArrayList<ProductJB> products = new ArrayList<ProductJB>();
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ArrayList<ProductJB> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<ProductJB> products) {
		this.products = products;
	}
	
	

}
