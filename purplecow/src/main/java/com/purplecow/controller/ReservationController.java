package com.purplecow.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.purplecow.dto.Reservations;
import com.purplecow.service.ReservationsService;

/**
 * @author miho7724
 *
 */
@RestController
public class ReservationController {

	@Autowired ReservationsService reservationsService;

	/*POST*/
	/*예약 최초 생성*/
	/*전달되는 날짜 패턴은 yyyy-MM-dd kk:mm:ss 이 형태로 전달해야 함*/
	@ResponseBody
	@PostMapping("/reservations")
	public void insertReservations(@RequestBody @DateTimeFormat(pattern = "yyyy-MM-dd kk:mm:ss") Reservations reservations) {
		reservationsService.insertReservations(reservations);
	}

	/*SELECT*/
	/*id로 특정 예약 조회*/
	@GetMapping("/reservations/{id}")
	public Reservations getReservationById(@PathVariable("id") int id) {
		return reservationsService.getReservationById(id);
	}

	/*user_id로 특정 사용자의 예약 전체 조회*/
	@GetMapping("/reservations")
	public Reservations getReservationsByUserId(@RequestParam("users_id") int userId) {
		return reservationsService.getReservationsByUserId(userId);
	}

	/*예약 전체 목록 조회*/
	@GetMapping("/reservations/list")
	public List<Reservations> getReservationsByUserId() {
		return reservationsService.getReservations();
	}



	/*PUT*/
	@ResponseBody
	@PutMapping("/reservations/{id}")
	public void updateReservationsById(@PathVariable("id") int id,@RequestBody(required= false) Map<String,Object> rbo) {
		/*예약 테이블에 정해진 자리 주차 여부 수정*/
		if(rbo.get("park_fixed") != null) reservationsService.updateParkFixedInReservation(id,Boolean.valueOf((String) rbo.get("park_fixed")));
		/*예약 테이블에 외부사진 목록 수정*/
		else if(rbo.get("images")!=null) {
			reservationsService.updateImagesInReservation(id,(List<String>)rbo.get("images"));
		}
		/*예약 테이블에 차량 외부상태와 내부상태 값 수정*/
		else if(rbo.get("outside_state")!=null && rbo.get("inside_state")!=null) {
			reservationsService.updateCarStatesInReservation(id,(String)rbo.get("outside_state"),(String)rbo.get("inside_state"));
		}
		/*예약 테이블에 결제한 카드 정보와 선결제한 금액으로 예약시 선결제한 정보 저장*/
		else if(rbo.get("cards_id") != null && rbo.get("rental_amount") != null) {
			reservationsService.updatePaymentsInReservations(id, (Integer)rbo.get("cards_id"),(Integer)rbo.get("rental_amount"));
		}
		/*예약 테이블에  결제한 정보 저장*/
		else if(rbo.get("distance")!=null) {
			reservationsService.updatePostPaymentsInReservation(id,(Integer)rbo.get("distance"));
		}

	}






}
