package com.purplecow.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.purplecow.dto.KakaoComponent;
import com.purplecow.mapper.AccountMapper;
import com.purplecow.service.KakaoService;


@Controller
public class SignController {
	
	@Value("${kakao.restapi.key}") String tmp;
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
	
	/*
	 * @GetMapping("/getkey") public String getkey() { return ;
	 * 
	 * }
	 */
	
	@GetMapping("/kakaologin")
	public String kakaologin(String code) {
		System.out.println("code :" + code);
		String access_Token = KakaoService.getAccessToken(code);
        System.out.println("access_Token : " + access_Token);
		return "login/login";

	}
	
}
