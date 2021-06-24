package com.purplecow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purplecow.dto.Zones;
import com.purplecow.service.ZonesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class APIZonesController {

	
	@Autowired
	ZonesService zonesService;
	
	@GetMapping("/zones")
	public List<Zones> getZones() {
		
		log.info("왓는가");
		
		return zonesService.getZones();
	}

}
