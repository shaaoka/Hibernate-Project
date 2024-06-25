package com.team6.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class ReserveBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reservation_id")
	private String reservation_id;
	@Column(name="account")
	private String account;
	@Column(name="numberOfPeople")
	private String numberOfPeople;
	@Column(name="reservation_name")
	private String reservation_name;
	@Column(name="reservation_date")
	private String reservation_date;
	@Column(name="reservation_time")
	private String reservation_time;
	@Column(name="special_requests")
	private String special_requests;
	@Column(name="phone")
	private String phone;
	@Column(name = "reservation_status")
	private String reservation_status;
	@Column(name="checkIn_status")
	private String checkIn_status;
	
	public ReserveBean() {
		
	}
	
	public String getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(String reservation_id) {
		this.reservation_id = reservation_id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(String numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public String getReservation_date() {
		return reservation_date;
	}
	public void setReservation_date(String reservation_date) {
		this.reservation_date = reservation_date;
	}
	public String getReservation_time() {
		return reservation_time;
	}
	public void setReservation_time(String reservation_time) {
		this.reservation_time = reservation_time;
	}
	public String getSpecial_requests() {
		return special_requests;
	}
	public void setSpecial_requests(String special_requests) {
		this.special_requests = special_requests;
	}
	public String getReservation_name() {
		return reservation_name;
	}
	public void setReservation_name(String reservation_name) {
		this.reservation_name = reservation_name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRservation_status() {
		return reservation_status;
	}
	public void setRservation_status(String rservation_status) {
		this.reservation_status = rservation_status;
	}
	public String getCheckIn_status() {
		return checkIn_status;
	}
	public void setCheckIn_status(String checkIn_status) {
		this.checkIn_status = checkIn_status;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReserveBean [reservation_id=");
		builder.append(reservation_id);
		builder.append(", account=");
		builder.append(account);
		builder.append(", numberOfPeople=");
		builder.append(numberOfPeople);
		builder.append(", reservation_name=");
		builder.append(reservation_name);
		builder.append(", reservation_date=");
		builder.append(reservation_date);
		builder.append(", reservation_time=");
		builder.append(reservation_time);
		builder.append(", special_requests=");
		builder.append(special_requests);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", reservation_status=");
		builder.append(reservation_status);
		builder.append(", checkIn_status=");
		builder.append(checkIn_status);
		builder.append("]");
		return builder.toString();
	}

	
}