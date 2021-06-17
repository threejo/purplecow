package com.purplecow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.purplecow.dto.Reservations;

@Mapper
public interface CarsMapper {

	List<Reservations> getCars();

}
