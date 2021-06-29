package com.purplecow.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purplecow.dto.Cars;
import com.purplecow.dto.Reservations;
import com.purplecow.mapper.CarsMapper;

/**
 * @author miho7724
 *
 */
@Service
public class CarsService {
	
	@Autowired CarsMapper carsMapper;

	public List<Cars> getCars() {
		return carsMapper.getCars(); 
	}
	
	
	public List<Cars> getCarByZoneId(int zones_id) {
		
		return carsMapper.getCarByZoneId(zones_id);
	}
	
	public Cars getCarbyId(int cars_id) {
		return carsMapper.getCarbyId(cars_id); 
	}

}
