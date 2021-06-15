package com.purplecow.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.purplecow.dto.Reservations;

@Service
public class TimeService {
	
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
	Reservations resv = new Reservations(start_time, end_time);

	/* 현재 시간 구하기 */
	public SimpleDateFormat timeNow() {
				
		df.format(cal.getTime());
		//cal.getTime();
		
		return df;	
	}
	
	
	public void startTime(TimeService timeNow) {
		
		
		TimeService st = timeNow;
		
		switch (min) {
		case value:
			
			break;

		default:
			break;
		}
		
	}
	
	/* 예약시간 구하기, end_time - start_time */
	public SimpleDateFormat reservationTime(Date start_time, Date end_time) {
		
		cal.setTime(end_time);
		
		Date resvTime = end_time - start_time;
		
		
		return null;
	}
	
	
}
