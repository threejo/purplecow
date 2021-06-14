package com.purplecow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InUseController {
	/*
	 * 해당 컨트롤러는 사용자가 차량 예약하여 사용중인 상황에서
	 * 필요한 기능들을 모아둔 것입니다.*/

	//차량 상태 확인하기(차량 내부/외부)
	@GetMapping("/inuse/checkStatus")
	public String checkStatus() {


		return "in_use/checkStatus";


	}


}
