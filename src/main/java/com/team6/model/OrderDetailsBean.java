package com.team6.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="orderDetails")
public class OrderDetailsBean {
	

	@Column(name="detailsId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer detailsId;
	
	@Column(name="orderId")
	private String orderId;
	
	@Column(name="productId")
	private String productId;
	
	@Column(name="product")
	private String product;
	
	@Column(name="unitPrice")
	private String unitPrice;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="subtotal")
	private String subtotal;
	
	@Column(name="note")
	private String note;
	
	@JoinColumn(name="orderId", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private OrderBean orderBean;

	public OrderDetailsBean() {
		
	}
	
	public Integer getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(Integer detailsId) {
		this.detailsId = detailsId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public OrderBean getOrderBean() {
		return orderBean;
	}

	public void setOrderBean(OrderBean orderBean) {
		this.orderBean = orderBean;
	}

	@Override
	public String toString() {
		return "OrderDetailsBean [detailsId=" + detailsId + ", orderId=" + orderId + ", productId=" + productId
				+ ", product=" + product + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", subtotal="
				+ subtotal + ", note=" + note + ", orderBean=" + orderBean + "]";
	}

	

}
