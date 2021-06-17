package com.purplecow.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purplecow.dto.Reservations;

@Controller
public class IntroController {
	
	@GetMapping("/feeinfo")
	public String feeinfo() {
		return "intro/feeinfo";
	}
	@GetMapping("/usageguide")
	public String usageguide() {
		return "intro/usageguide";
	}

}
