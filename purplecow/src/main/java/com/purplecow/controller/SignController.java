package com.purplecow.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.purplecow.mapper.AccountMapper;

@Controller
public class SignController {

	@Autowired
    private AccountMapper accountMapper;



	@GetMapping("/registration")
	public String reg() {
		
		return "registration/registration";

	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login/login";

	}
}
