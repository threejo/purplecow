package com.purplecow.service;

import java.util.ArrayList;
import java.util.Arrays;
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

	public void updateImagesInReservation(int id, List<String> images) {
		
//		String[] imgArr =(String[])images.toArray(new String[images.size()]);
//		String imageList="{";
//		for(String img:imgArr) {
//			imageList += img;
//		}
//		imageList += "}";
//		String[] a = {"1","2","3000000"};
		reservationsMapper.updateImagesInReservation(id,images );

	}

}
