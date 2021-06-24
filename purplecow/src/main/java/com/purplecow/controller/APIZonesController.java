package com.purplecow.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purplecow.dto.Zones;
import com.purplecow.service.ZonesService;

@RestController
public class APIZonesController {
	
	private static final Logger log = LogManager.getLogger(APICarsController.class);
	
	@Autowired
	ZonesService zonesService;
	
	@GetMapping("/zones")
	public List<Zones> getZones() {
		
		log.info("왓는가");
		
		return zonesService.getZones();
	}

}
