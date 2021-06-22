package com.purplecow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KakaoMapController {
	
	@GetMapping("map")
	public String kakaoMap() {
		
		return "map/kakaoMap";
	}
	
}
