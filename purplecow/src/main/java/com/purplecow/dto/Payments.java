package com.purplecow.dto;

public class Payments {
	
	private int id;
	/** 선결제 관련 목록
	 * 선결제 금액 = 차량대여비용+부름비용+보험비용
	 * 차량대여비용 = 해당 차량의 일일대여비용÷(24*6)*빌린 시간(10분 단위)
	 * 빌린 시간 = 대여 종료 시간 - 대여 시작 시간
	 * */
	private int prepaid_amount;
	private int rental_amount;
	private int calling_fee;
	private int insurance_fee;
	/*후결제 목록
	 * 후결제 금액 = 주행요금 + hipass 요금 + 페널티 비용
	 * 주행요금 = 차량별 주행요금(km당)*주행거리
	 * */
	private int postpaid_amount;
	private int driving_amount;
	private int hipass_fee;
	private int penalty_fee;
	
	/*Getter & Setter*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrepaid_amount() {
		return prepaid_amount;
	}
	public void setPrepaid_amount(int prepaid_amount) {
		this.prepaid_amount = prepaid_amount;
	}	
	public int getRental_amount() {
		return rental_amount;
	}
	public void setRental_amount(int rental_amount) {
		this.rental_amount = rental_amount;
	}
	public int getCalling_fee() {
		return calling_fee;
	}
	public void setCalling_fee(int calling_fee) {
		this.calling_fee = calling_fee;
	}
	public int getInsurance_fee() {
		return insurance_fee;
	}
	public void setInsurance_fee(int insurance_fee) {
		this.insurance_fee = insurance_fee;
	}
	public int getPostpaid_amount() {
		return postpaid_amount;
	}
	public void setPostpaid_amount(int postpaid_amount) {
		this.postpaid_amount = postpaid_amount;
	}
	public int getDriving_amount() {
		return driving_amount;
	}
	public void setDriving_amount(int driving_amount) {
		this.driving_amount = driving_amount;
	}
	public int getHipass_fee() {
		return hipass_fee;
	}
	public void setHipass_fee(int hipass_fee) {
		this.hipass_fee = hipass_fee;
	}
	public int getPenalty_fee() {
		return penalty_fee;
	}
	public void setPenalty_fee(int penalty_fee) {
		this.penalty_fee = penalty_fee;
	}	
	
	/*constructor*/
	public Payments(int rental_amount) {
		super();
		
		this.rental_amount = rental_amount;
		this.calling_fee = 0;
		this.insurance_fee = 0;
		this.prepaid_amount = rental_amount+calling_fee+insurance_fee;
	}
	
	
	

}
