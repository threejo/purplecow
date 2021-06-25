package com.purplecow.dto;

public class Users {

	private int id;
	private String name;
	private String email;
	private String password;
	private String phone_no;
	private String card_id;
	private String license_id;
	private String phone_cert;
	private String license_cert;
	private String role;

	/*Getter & Setter*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getLicense_id() {
		return license_id;
	}
	public void setLicense_id(String license_id) {
		this.license_id = license_id;
	}
	public String getPhone_cert() {
		return phone_cert;
	}
	public void setPhone_cert(String phone_cert) {
		this.phone_cert = phone_cert;
	}
	public String getLicense_cert() {
		return license_cert;
	}
	public void setLicense_cert(String license_cert) {
		this.license_cert = license_cert;
	}

	/*constructor*/
	public Users(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getRole() {
		// TODO Auto-generated method stub
		return role;
	}






}
