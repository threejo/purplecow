package com.purplecow.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purplecow.dto.Cars;
import com.purplecow.dto.Payments;
import com.purplecow.dto.Reservations;
import com.purplecow.mapper.PaymentsMapper;
import com.purplecow.mapper.ReservationsMapper;


/**
 * @author miho7724
 *
 */
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
		//reservations테이블에 이용한 카드와 결제 정보를 기록한다.
		reservationsMapper.updatePaymentsInReservations(id,cards_id,payments_id);
		
	}

	public void updatePostPaymentsInReservation(int id, int distance) {
		//reservations 테이블에 저장된 cars_id를 통해 이용한 차량의 km당 주행요금을 가져온다.
		Cars car = reservationsMapper.getCarsById(id);		
		int driving_fee_per_km = car.getDriving_fee_per_km();
		//입력된 주행거리(distance)를 바탕으로 주행요금(차량별 km당 주행요금*주행거리)를 payments의 driving_amount에 기록한다.
		int driving_amount = driving_fee_per_km*distance;
		int hipass_fee = 0;
		int penalty_fee = 0;
		int postpaid_amount =driving_amount+hipass_fee+penalty_fee;
		
		Payments payment = reservationsMapper.getPaymentsById(id);
		payment.setDriving_amount(driving_amount);
		payment.setHipass_fee(hipass_fee);
		payment.setPenalty_fee(penalty_fee);
		payment.setPostpaid_amount(postpaid_amount);
		paymentsMapper.updatePayments(payment);
		
		
	}

	
}


