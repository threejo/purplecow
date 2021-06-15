package com.purplecow.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.purplecow.mapper.AccountMapper;

@Controller
public class RegistrationController {

	
	@Autowired
    private AccountMapper accountMapper;

	
	
	@GetMapping("/registration")
	public String login() {

		
		return "registration/registration";


	}
	
	 @RequestMapping("/user_ajax_test")
	    public @ResponseBody String restest() {
	        System.out.println("ajax 요청 도착!");
	        return "cool";

	 }
}