package com.purplecow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {
	
	@GetMapping("reservation/resv")
	public String rest() {
		return "reservation/resv";
	}

}
