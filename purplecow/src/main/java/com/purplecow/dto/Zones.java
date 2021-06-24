package com.purplecow.dto;

import lombok.Data;

@Data
public class Zones {
	
	private int id; //아이디 식별자
	private String name; //이름 ex)한국소프트웨어저작권협회
	private double latitude; //위도
	private double longitude; //경도
	private String address; //주소 
	
}
