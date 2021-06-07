package com.purplecow.dto;

public class Account {
	private String account_id;
	private String id;

	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Account(String account_id, String id) {
		super();
		this.account_id = account_id;
		this.id = id;
	}



}
