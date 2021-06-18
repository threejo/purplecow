package com.purplecow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.purplecow.dto.Cars;
import com.purplecow.dto.Reservations;

@Mapper
public interface CarsMapper {
	
	Cars getCarByZoneId(Cars zones_id);
	
	List<Reservations> getCars();

}