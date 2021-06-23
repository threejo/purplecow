package com.purplecow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResvRestController {
	
	@GetMapping("/reservation")
	public String resarvation() {
		
		return "reservation";
	}
}
