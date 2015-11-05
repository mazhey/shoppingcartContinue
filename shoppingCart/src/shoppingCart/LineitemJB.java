package shoppingCart;

import java.io.Serializable;

public class LineitemJB implements Serializable{
	private long lineitemId;
	private long productId;
	private String productname;
	private double price;
	private int  quantity;
	private double unitPrice;
	public long getLineitemId() {
		return lineitemId;
	}
	public void setLineitemId(long lineitemId) {
		this.lineitemId = lineitemId;
	}
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private String date;

}
