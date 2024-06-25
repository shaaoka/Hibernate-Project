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
@Table(name = "ProductCategory")
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryId")
	private Integer CategoryId;
	
	@Column(name = "CategoryName")
	private String CategoryName;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "productCategory", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Set<ProductBean> pBeans = new LinkedHashSet<>();
	
//	--------------------------
	public ProductCategory() {
	}
//	--------------------------

	public Integer getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(Integer categoryId) {
		CategoryId = categoryId;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public Set<ProductBean> getpBeans() {
		return pBeans;
	}

	public void setpBeans(Set<ProductBean> pBeans) {
		this.pBeans = pBeans;
	}


	
	
}
