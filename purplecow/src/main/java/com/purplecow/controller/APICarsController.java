package com.purplecow.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.purplecow.dto.Cars;
import com.purplecow.dto.Reservations;
import com.purplecow.dto.Users;
import com.purplecow.service.CarsService;

@RestController
public class APICarsController {
	
	private static final Logger log = LogManager.getLogger(APICarsController.class);

	@Autowired 
	private CarsService carsService;
	
	
	/*SELECT*/
	/*user_id로 특정 사용자의 예약 전체 조회*/
	/*예약 전체 목록 조회*/
	@GetMapping("/cars/list")
	public List<Cars> getReservations() {
		return carsService.getCars();
	}
	
	/*
	 * SELECT 
	 * 존 아이디에 해당되는 차 리스트를 가져온다
	 */
	@GetMapping("/cars/{zones_id}")
	public List<Cars> getCarByZoneId(@PathVariable("zones_id") int zones_id) {
		log.info("잘 왔니?");
		log.debug(zones_id);
		return carsService.getCarByZoneId(zones_id);
	}
	
	
	@GetMapping("/cars/cars_id/{cars_id}")
	public Cars getCarByCarId(@PathVariable("cars_id") int cars_id) {
		//System.out.println(carsService.getCarbyId(cars_id));
		return carsService.getCarbyId(cars_id);
	}
	
	
}
