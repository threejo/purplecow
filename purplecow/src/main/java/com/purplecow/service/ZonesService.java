package com.purplecow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purplecow.dto.Zones;
import com.purplecow.mapper.ZonesMapper;

@Service
public class ZonesService {

	@Autowired
	ZonesMapper zonesMapper;
	
	public List<Zones> getZones() {
		return zonesMapper.getZones();
		
	}
}
