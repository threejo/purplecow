package com.purplecow.dto;

import com.google.cloud.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DriverLisence {

	private String name;
	private String type;
	private Date date_start;
	private Date date_end;
	private Date date_valid;
	private String SocialNumber;
	private String LicenseNumber;
	
	

	/*constructor*/
	public DriverLisence(String name, String type, Date date_start, Date date_end, Date date_valid, String SocialNumber, String LicenseNumber) {
		super();
		this.name = name;
		this.type = type;
		this.date_start = date_start;
		this.date_end = date_end;
		this.date_valid = date_valid;
		this.SocialNumber = SocialNumber;
		this.LicenseNumber = LicenseNumber;
		
	}






}