package com.team6.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class ProductBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductId")
	private Integer productId;

	@Column(name = "categoryId")
	private Integer CategoryId;

	@Column(name = "ProductName")
	private String productName;

	@Column(name = "ProductDesc")
	private String productDesc;

	@Column(name = "ProductImg_url")
	private String productImg_url;

	@Column(name = "ProductPrice")
	private String productPrice;

	@Column(name = "productStateId")
	private Integer ProductStateId;

	@JoinColumn(name = "CategoryId", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private ProductCategory productCategory;

	@JoinColumn(name = "productStateId", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private ProductState productState;

//	----------------------
	public ProductBean() {
	}
//	----------------------

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(Integer categoryId) {
		CategoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductImg_url() {
		return productImg_url;
	}

	public void setProductImg_url(String productImg_url) {
		this.productImg_url = productImg_url;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductStateId() {
		return ProductStateId;
	}

	public void setProductStateId(Integer productStateId) {
		ProductStateId = productStateId;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public ProductState getProductState() {
		return productState;
	}

	public void setProductState(ProductState productState) {
		this.productState = productState;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductBean [productId=");
		builder.append(productId);
		builder.append(", CategoryId=");
		builder.append(CategoryId);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", productDesc=");
		builder.append(productDesc);
		builder.append(", productImg_url=");
		builder.append(productImg_url);
		builder.append(", productPrice=");
		builder.append(productPrice);
		builder.append(", ProductStateId=");
		builder.append(ProductStateId);
		builder.append(", productCategory=");
		builder.append(productCategory);
		builder.append(", productState=");
		builder.append(productState);
		builder.append("]");
		return builder.toString();
	}

}
