package com.purplecow.mapper;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.purplecow.dto.Cars;
import com.purplecow.dto.Payments;
import com.purplecow.dto.Reservations;

@Mapper
public interface ReservationsMapper {

	void insertReservations(Reservations reservations);

	Reservations getReservationById(int id);

	Reservations getReservationsByUserId(int usersId);

	List<Reservations> getReservations();

	Cars getCarsById(int id);
	
	Payments getPaymentsById(int id);

	void updateParkFixedInReservation(int id, Boolean park_fixed);

	void updateImagesInReservation(int id, List<String> images);

	void updateCarStatesInReservation(int id, String outside_state, String inside_state);

	void updatePaymentsInReservations(int id, int cards_id, int payments_id);

	

	

}
