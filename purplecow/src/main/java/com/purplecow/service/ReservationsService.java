package com.purplecow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purplecow.dto.Reservations;
import com.purplecow.mapper.ReservationsMapper;

@Service
public class ReservationsService {

	@Autowired ReservationsMapper reservationsMapper;

	public void insertReservations(Reservations reservations) {

		reservationsMapper.insertReservations(reservations);
	}

	public Reservations getReservationById(int id) {

		return reservationsMapper.getReservationById(id);
	}

	public Reservations getReservationsByUserId(int userId) {

		return reservationsMapper.getReservationsByUserId(userId);
	}

	public List<Reservations> getReservations() {

		return reservationsMapper.getReservations();
	}

	public void updateParkFixedInReservation(int id, Boolean park_fixed) {

		reservationsMapper.updateParkFixedInReservation(id,park_fixed);

	}

	public void updateImagesInReservation(int id, String[] images) {
		reservationsMapper.updateImagesInReservation(id,images);

	}

}
