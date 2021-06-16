package com.purplecow.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.purplecow.dto.Cars;

@Mapper
public interface CarsMapper {
	
	Cars getCarByZoneId(int zones_id);

}
