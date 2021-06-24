package com.purplecow.dto;

import lombok.Data;

/**
 * @author miho7724
 *
 */

enum OilTypes {	휘발유,경유,LPG,전기 }
enum CarScales {경형, 소형, 준중형, 중형, 준대형, 대형, 소형SUV, 준중형SUV, 중형SUV, 승합, RV, 수입, 전기차 }

@Data
public class Cars {
	
	/*차량 정보 테이블
	 * 차량 색상, 이름, 번호판, 일일 대여요금, km당 주행요금,
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
	
	/*constructor*/
	
	

}
