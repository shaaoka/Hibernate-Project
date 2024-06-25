package com.team6.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Promotions")
public class PromotionsBean {

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "Promotions_id")
	private String promotions_id;

	@Column(name = "Promotions_name")
	private String promotions_name;

	@Column(name = "Promotions_content")
	private String promotions_content;

	@Column(name = "Promotions_picture")
	private String promotions_picture;

	@Column(name = "Promotions_discount")
	private String promotions_discount;

	@Column(name = "Promotions_discountCode")
	private String promotions_discountCode;

	@Column(name = "Promotions_startDate")
	private String promotions_startDate;

	@Column(name = "Promotions_endDate")
	private String promotions_endDate;

//	----------------------
	

	public PromotionsBean() {
	}
//	----------------------

	public String getPromotions_id() {
		return promotions_id;
	}

	public void setPromotions_id(String promotions_id) {
		this.promotions_id = promotions_id;
	}

	public String getPromotions_name() {
		return promotions_name;
	}

	public void setPromotions_name(String promotions_name) {
		this.promotions_name = promotions_name;
	}

	public String getPromotions_content() {
		return promotions_content;
	}

	public void setPromotions_content(String promotions_content) {
		this.promotions_content = promotions_content;
	}

	public String getPromotions_picture() {
		return promotions_picture;
	}

	public void setPromotions_picture(String promotions_picture) {
		this.promotions_picture = promotions_picture;
	}

	public String getPromotions_discount() {
		return promotions_discount;
	}

	public void setPromotions_discount(String promotions_discount) {
		this.promotions_discount = promotions_discount;
	}

	public String getPromotions_discountCode() {
		return promotions_discountCode;
	}

	public void setPromotions_discountCode(String promotions_discountCode) {
		this.promotions_discountCode = promotions_discountCode;
	}

	public String getPromotions_startDate() {
		return promotions_startDate;
	}

	public void setPromotions_startDate(String promotions_startDate) {
		this.promotions_startDate = promotions_startDate;
	}

	public String getPromotions_endDate() {
		return promotions_endDate;
	}

	public void setPromotions_endDate(String promotions_endDate) {
		this.promotions_endDate = promotions_endDate;
	}

	@Override
	public String toString() {
		return "PromotionsBean [promotions_id=" + promotions_id + ", promotions_name=" + promotions_name
				+ ", promotions_content=" + promotions_content + ", promotions_picture=" + promotions_picture
				+ ", promotions_discount=" + promotions_discount + ", promotions_discountCode="
				+ promotions_discountCode + ", promotions_startDate=" + promotions_startDate + ", promotions_endDate="
				+ promotions_endDate + "]";
	}

	

}
