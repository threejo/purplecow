package com.purplecow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purplecow.dto.Cars;
import com.purplecow.mapper.CarsMapper;
import com.sun.javafx.collections.MappingChange.Map;

@Service("CarService")
public class CarServiceImpl implements CarService {
	
	@Autowired
	CarsMapper carsMapper;

	@Override
	public Cars getCarByZoneId(int zones_id) {
		//Map<K, V> cars = new Cars();
		//cars.getCar_name();
		
		return carsMapper.getCarByZoneId(zones_id);
	}

}
