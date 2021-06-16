package com.purplecow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purplecow.dto.Reservations;
import com.purplecow.mapper.CarsMapper;

/**
 * @author miho7724
 *
 */
@Service
public class CarsService {
	
	@Autowired CarsMapper carsMapper;

	public List<Reservations> getCars() {
		return carsMapper.getCars();
	}

}
