package com.purplecow.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
enum CarStates {Good,Soso,Bad}
public class Reservations {

	private int id;
	//최초 예약 페이지에서 필요한 변수
	private int users_id;
	private int zones_id;
	private int cars_id;
	private int cards_id;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
	private Date start_time;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
	private Date end_time;

	private int payments_id;

	//수령 후 필요한 변수
	private String[] images;
	private CarStates outside_state;
	private CarStates inside_state;
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


	public int getusers_id() {
		return users_id;
	}


	public void setusers_id(int users_id) {
		this.users_id = users_id;
	}


	public int getzones_id() {
		return zones_id;
	}


	public void setzones_id(int zones_id) {
		this.zones_id = zones_id;
	}


	public int getCars_id() {
		return cars_id;
	}


	public void setCars_id(int cars_id) {
		this.cars_id = cars_id;
	}


	public int getCards_id() {
		return cards_id;
	}


	public void setCards_id(int cards_id) {
		this.cards_id = cards_id;
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


	public int getpayments_id() {
		return payments_id;
	}


	public void setpayments_id(int payments_id) {
		this.payments_id = payments_id;
	}


	public String[] getImages() {
		return images;
	}


	public void setImages(String[] images) {
		this.images = images;
	}


	public CarStates getOutside_state() {
		return outside_state;
	}


	public void setOutside_state(CarStates outside_state) {
		this.outside_state = outside_state;
	}


	public CarStates getInside_state() {
		return inside_state;
	}


	public void setInside_state(CarStates inside_state) {
		this.inside_state = inside_state;
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
	public Reservations(int users_id, int zones_id, int cars_id,String start_time,String end_time) {
		super();
		this.users_id = users_id;
		this.zones_id = zones_id;
		this.cars_id = cars_id;

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
	}


	


	







}
