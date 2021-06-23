package com.purplecow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purplecow.dto.Cars;
import com.purplecow.dto.Users;
import com.purplecow.mapper.CarsMapper;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthService {
	
	@Autowired CarsMapper carsMapper;

	public List<Cars> findAll() {
		log.info("통과3");
		return carsMapper.getCars();
	}

}
