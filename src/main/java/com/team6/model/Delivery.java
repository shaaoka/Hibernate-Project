package com.team6.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "delivery")
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "cname")
	private String  cname;
	
	@Column(name = "phone" ,unique = true)
	private String  phone;
	
	@Column(name = "product")
	private String  product;
	
	@Column(name = "num")
	private Integer num;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "ename")
	private String  ename;
	
	@Column(name = "address")
	private String  address;
	
	@Column(name = "time")
	private Integer time;
	
	
	public Delivery() {
	}
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}


	public Integer getNum() {
		return num;
	}


	public void setNum(Integer num) {
		this.num = num;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Integer getTime() {
		return time;
	}


	public void setTime(Integer time) {
		this.time = time;
	}

	
	
}
