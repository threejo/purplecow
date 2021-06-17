package com.purplecow.dto;

/**
 * @author miho7724
 *
 */

enum OilTypes {	휘발유,경유,LPG,전기 }
enum CarScales {경형, 소형, 준중형, 중형, 준대형, 대형, 소형SUV, 준중형SUV, 중형SUV, 승합, RV, 수입, 전기차 }


public class Cars {
	
	/*차량 정보 테이블
	 * 차량 색상, 일일 대여요금, km당 주행요금,
	 * 사용가능 여부,현재 위치한 존 정보,유종,차급*/
	
	private int id;
	private String name;
	private String number;

	private String model_color;
	private int daily_rental_fee;
	private int driving_fee_per_km;
	private Boolean available;
	private int zones_id;
	private OilTypes oil_type;
	private CarScales scale;
	
	/*Getter & Setter*/
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel_color() {
		return model_color;
	}
	public void setModel_color(String model_color) {
		this.model_color = model_color;
	}
	public int getDriving_fee_per_km() {
		return driving_fee_per_km;
	}
	public void setDriving_fee_per_km(int driving_fee_per_km) {
		this.driving_fee_per_km = driving_fee_per_km;
	}
	public int getDaily_rental_fee() {
		return daily_rental_fee;
	}
	public void setDaily_rental_fee(int daily_rental_fee) {
		this.daily_rental_fee = daily_rental_fee;
	}	
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public int getZones_id() {
		return zones_id;
	}
	public void setZones_id(int zones_id) {
		this.zones_id = zones_id;
	}
	public OilTypes getOil_type() {
		return oil_type;
	}
	public void setOil_type(OilTypes oil_type) {
		this.oil_type = oil_type;
	}
	public CarScales getScale() {
		return scale;
	}
	public void setScale(CarScales scale) {
		this.scale = scale;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCar_number() {
		return number;
	}
	public void setCar_number(String car_number) {
		this.number = car_number;
	}
	public String getCar_name() {
		return name;
	}
	public void setCar_name(String car_name) {
		this.name = car_name;
	}
	
	
	
	/*constructor*/
	
	

}
