package com.purplecow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.purplecow.dto.Reservations;
import com.purplecow.service.CarsService;

@RestController
public class APICarsController {
	
	@Autowired CarsService carsService;
	
	/*SELECT*/
	/*user_id로 특정 사용자의 예약 전체 조회*/
	/*예약 전체 목록 조회*/
	@GetMapping("/cars/list")
	public List<Reservations> getReservations() {
		return carsService.getCars();
	}

}
