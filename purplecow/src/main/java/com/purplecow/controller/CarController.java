package com.purplecow.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.purplecow.dto.Cars;
import com.purplecow.service.CarService;

@RestController
public class CarController {
	
	@Autowired
	private CarService carService;
	
	
	/* 해당 존에 있는 차량을 가져온다 */
	@ResponseBody
	@GetMapping("cars/{zoneId}")//해댱 존의 아이디를 가져옴
	public void getCarsByZoneId(@PathVariable("id") int id, @RequestBody(required = false) Map<String, Object> rbo) {
	
		Cars cars = carService.getCarsByZoneId;
		
	}

}
