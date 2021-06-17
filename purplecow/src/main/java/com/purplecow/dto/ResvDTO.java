package com.purplecow.dto;

import java.sql.Date;

public class ResvDTO {
	
	//차량 인덱스 번호
	private int car_id;
	
	//예약 시작 시간
	private Date start_time;
	
	//예약 종료 시간
	private Date end_time;
	
	//가격
	private int price;
	
	//후불가격?? 버전 1에서는 필요없을지도 상황봐서 사용하겟음
	private int price2;
	

}
