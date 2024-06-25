package com.team6.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ProductState")
public class ProductState {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductStateId")
	private Integer ProductStateId;
	
	@Column(name = "ProductStateName")
	private String ProductStateName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productState", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<ProductBean> pBeans = new LinkedHashSet<>();
	
	
//	------------------------
	public ProductState() {
	}
//	------------------------


	public Integer getProductStateId() {
		return ProductStateId;
	}


	public void setProductStateId(Integer productStateId) {
		ProductStateId = productStateId;
	}


	public String getProductStateName() {
		return ProductStateName;
	}


	public void setProductStateName(String productStateName) {
		ProductStateName = productStateName;
	}


	public Set<ProductBean> getpBeans() {
		return pBeans;
	}


	public void setpBeans(Set<ProductBean> pBeans) {
		this.pBeans = pBeans;
	}



	
	
	
}
