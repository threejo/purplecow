package com.purplecow.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.purplecow.dto.Cars;
import com.purplecow.dto.Reservations;

@Mapper
public interface CarsMapper {
	
	List<Cars> getCarByZoneId(int zones_id);
	
	List<Reservations> getCars();

}
