package com.purplecow.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reservations {

	private int id;
	//최초 예약 페이지에서 필요한 변수
	private int user_id;
	private int zone_id;
	private int car_id;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
	private Date start_time;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
	private Date end_time;

	private int payment_id;

	//수령 후 필요한 변수
	private String[] images= {"1","2","3"};

	//반납시 필요한 변수?

	private double distance;
	private int hipass_count=0;
	private int returned_time;
	private Boolean delayed=false;
	private Boolean accident=false;

	private Boolean park_fixed;


	/*Getter & Setter*/





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getZone_id() {
		return zone_id;
	}


	public void setZone_id(int zone_id) {
		this.zone_id = zone_id;
	}


	public int getCar_id() {
		return car_id;
	}


	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}


	public Date getStart_time() {
		return start_time;
	}


	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}


	public Date getEnd_time() {
		return end_time;
	}


	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}


	public int getPayment_id() {
		return payment_id;
	}


	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}


	public String[] getImages() {
		return images;
	}


	public void setImages(String[] images) {
		this.images = images;
	}


	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}


	public int getHipass_count() {
		return hipass_count;
	}


	public void setHipass_count(int hipass_count) {
		this.hipass_count = hipass_count;
	}


	public int getReturned_time() {
		return returned_time;
	}


	public void setReturned_time(int returned_time) {
		this.returned_time = returned_time;
	}


	public Boolean getDelayed() {
		return delayed;
	}


	public void setDelayed(Boolean delayed) {
		this.delayed = delayed;
	}


	public Boolean getAccident() {
		return accident;
	}


	public void setAccident(Boolean accident) {
		this.accident = accident;
	}


	public Boolean getPark_fixed() {
		return park_fixed;
	}


	public void setPark_fixed(Boolean park_fixed) {
		this.park_fixed = park_fixed;
	}

	/*constructor*/
	public Reservations(int user_id, int zone_id, int car_id,String start_time,String end_time) {
		super();
		this.user_id = user_id;
		this.zone_id = zone_id;
		this.car_id = car_id;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date stime = null;
		try {
			stime = sdf.parse(start_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.start_time = stime;

		Date etime=null;
		try {
			etime = sdf.parse(end_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.end_time = etime;

//		this.hipass_count = hipass_count;
//		this.delayed = delayed;
//		this.accident = accident;


	}








}
