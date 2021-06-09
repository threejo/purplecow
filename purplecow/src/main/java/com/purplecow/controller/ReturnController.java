package com.purplecow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReturnController {
	
	@GetMapping("/return")
	public String returnCar() {

		
		return "return/returnCar";


	}

}
