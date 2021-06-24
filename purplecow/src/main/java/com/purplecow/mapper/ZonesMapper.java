package com.purplecow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.purplecow.dto.Zones;

@Mapper
public interface ZonesMapper {
	
	public List<Zones> getZones();

}
