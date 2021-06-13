package com.purplecow.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purplecow.dto.Payments;
import com.purplecow.dto.Reservations;
import com.purplecow.mapper.PaymentsMapper;
import com.purplecow.mapper.ReservationsMapper;

@Service
public class ReservationsService {

	@Autowired ReservationsMapper reservationsMapper;
	@Autowired PaymentsMapper paymentsMapper;

	public void insertReservations(Reservations reservations) {
		reservationsMapper.insertReservations(reservations);
	}

	public Reservations getReservationById(int id) {
		return reservationsMapper.getReservationById(id);
	}

	public Reservations getReservationsByUserId(int usersId) {
		return reservationsMapper.getReservationsByUserId(usersId);
	}

	public List<Reservations> getReservations() {
		return reservationsMapper.getReservations();
	}

	public void updateParkFixedInReservation(int id, Boolean park_fixed) {
		reservationsMapper.updateParkFixedInReservation(id,park_fixed);
	}

	public void updateImagesInReservation(int id, List<String> images) {
		reservationsMapper.updateImagesInReservation(id,images );
	}

	public void updateCarStatesInReservation(int id, String outside_state, String inside_state) {
		reservationsMapper.updateCarStatesInReservation(id,outside_state,inside_state);		
	}

	public void updatePaymentsInReservations(int id, int cards_id, int rental_amount) {
		//먼저 payments 객체를 rental_amount(대여 비용) 값을 넣어서 만든다.
		Payments payment =new Payments(rental_amount);
		//이 객체를 payments테이블에 넣고 그 데이터의 기본키를 반환한다.
		int payments_id=paymentsMapper.insertPayments(payment);
		
		reservationsMapper.updatePaymentsInReservations(id,cards_id,payments_id);
		
	}

	
}


