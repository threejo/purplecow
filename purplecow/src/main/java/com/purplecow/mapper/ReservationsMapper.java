package com.purplecow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.purplecow.dto.Reservations;

@Mapper
public interface ReservationsMapper {

	void insertReservations(Reservations reservations);

	Reservations getReservationById(int id);

	Reservations getReservationsByUserId(int userId);

	List<Reservations> getReservations();

	void updateParkFixedInReservation(int id, Boolean park_fixed);

	void updateImagesInReservation(int id, String[] images);

}
