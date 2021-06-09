package com.purplecow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReturnController {
	/*
	 * 해당 컨트롤러는 사용자가 차량을 반납할 때
	 * 필요한 기능들을 모아둔 것입니다.*/


	//반납하기 - 주차위치,상태 체크
	@GetMapping("/return")
	public String returnCar() {


		return "return/returnCar";


	}

	//반납하기_결제 -주행요금,
	@GetMapping("/return/pay")
	public String returnPayCar() {


		return "return/returnCar_pay";


	}


}
