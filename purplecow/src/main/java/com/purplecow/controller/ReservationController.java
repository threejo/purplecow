package com.purplecow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {

	@GetMapping("reservation")
	public String resevation() {
		return "reservation/reservation";
	}
	
	//예약 중 예약 정보 확인(예약 시간, 차량 정보, 결제 정보)
	@GetMapping("/payment")
	public String checkPayment() {
		return "reservation/payment";
	}
	
	//선택한 존에 해당되는 차량
	@GetMapping("/carList")
	public String showCarList() {
		return "reservation/carList";
	}
	
	//지도API 없이 테이블로 퍼플존 리스트 조회
	@GetMapping("reservation2")
	public String resevation2() {
		return "reservation/reservation2";
	}

}
