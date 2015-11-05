package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the LINEITEM database table.
 * 
 */
@Entity
@Table (name="LINEITEM", schema="TESTUSERDB")
@NamedQuery(name="Lineitem.findAll", query="SELECT l FROM Lineitem l")
public class Lineitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LINEITEM_ID")
	private long lineitemId;

	@Column(name="PRODUCT_DATE")
	private String productDate;

	@Column(name="PRODUCT_NAME")
	private String productName;

	@Column(name="PRODUCT_PRICE")
	private BigDecimal productPrice;

	@Column(name="PRODUCT_QUANTITY")
	private BigDecimal productQuantity;

	@Column(name="PRODUCT_UNITPRICE")
	private BigDecimal productUnitprice;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;

	public Lineitem() {
	}

	public long getLineitemId() {
		return this.lineitemId;
	}

	public void setLineitemId(long lineitemId) {
		this.lineitemId = lineitemId;
	}

	public String getProductDate() {
		return this.productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public BigDecimal getProductQuantity() {
		return this.productQuantity;
	}

	public void setProductQuantity(BigDecimal productQuantity) {
		this.productQuantity = productQuantity;
	}

	public BigDecimal getProductUnitprice() {
		return this.productUnitprice;
	}

	public void setProductUnitprice(BigDecimal productUnitprice) {
		this.productUnitprice = productUnitprice;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}