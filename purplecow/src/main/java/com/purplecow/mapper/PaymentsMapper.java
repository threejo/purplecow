package com.purplecow.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.purplecow.dto.Payments;
import com.purplecow.dto.Reservations;

@Mapper
public interface PaymentsMapper {
	
	int insertPayments(Payments payments);
}
