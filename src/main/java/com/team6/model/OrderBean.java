package com.team6.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="pizzaOrder")
public class OrderBean {
	
	@Id
	@Column(name="orderId")
	private String orderId;
	
	@Column(name="orderTime")
	@Transient
	private String orderTime;
	
	@Column(name="customerName")
	private String customerName;
	
	@Column(name="amount")
	private String amount;
	
	@Column(name="payment")
	private String payment;
	
	@Column(name="pickup")
	private String pickup;
	
	@Column(name="orderStatus")
	private String orderStatus;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderBean", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Set<OrderDetailsBean> detailsBean = new LinkedHashSet<>();
	
	public OrderBean() {
		
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	public Set<OrderDetailsBean> getDetailsBean() {
		return detailsBean;
	}

	public void setDetailsBean(Set<OrderDetailsBean> detailsBean) {
		this.detailsBean = detailsBean;
	}

	@Override
	public String toString() {
		return "OrderBean [orderId=" + orderId + ", orderTime=" + orderTime + ", customerName=" + customerName
				+ ", amount=" + amount + ", payment=" + payment + ", pickup=" + pickup + ", orderStatus=" + orderStatus
				+ ", detailsBean=" + detailsBean + "]";
	}

	

}
