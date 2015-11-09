package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the PRODUCT database table.
 * 
 */
@Entity
@Table(name="PRODUCT",schema="TESTUSERDB")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCT_PRODUCTID_GENERATOR",sequenceName="SEQ_PRODUCT",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="PRODUCT_PRODUCTID_GENERATOR")
	@Column(name="PRODUCT_ID")
	private long productId;

	@Column(name="PRODUCT_DATE")
	private String productDate;

	@Column(name="PRODUCT_DESCRIPTION")
	private String productDescription;

	@Column(name="PRODUCT_NAME")
	private String productName;

	@Column(name="PRODUCT_PRICE")
	private BigDecimal productPrice;

	public Product() {
	}

	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductDate() {
		return this.productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
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

}