package com.purplecow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.purplecow.dto.Cars;
import com.purplecow.service.CarService;

@RestController
public class CarAPIController {

	public CarService carService;
	/*
	 * SELECT id로 특정 예약 조회
	 * 
	 * @GetMapping("/reservations/{id}") 
	 * public Reservations getReservationById(@PathVariable("id") int id) { 
	 * 
	 * return reservationsService.getReservationById(id); }
	 */
	
	@GetMapping("/resv/{zones_id}")
	public Cars getCarByZoneId(@PathVariable("zones_id") int zones_id) {
		
		return carService.getCarByZoneId(zones_id);
		
	}

}
