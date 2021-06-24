package com.purplecow.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


import com.purplecow.dto.PropertyUtil;
import com.purplecow.mapper.AccountMapper;
import com.purplecow.service.KakaoService;


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
	
	
	 @GetMapping("/getkey") @ResponseBody public String getkey() { 
		 String key = PropertyUtil.getProperty("kakao.restapi.key");
		 System.out.println(key );
		 return key;
	 
	 }
	
	
	@GetMapping("/kakaologin")
	public String kakaologin(String code, HttpSession session) {
		System.out.println("code :" + code);
		String access_Token = KakaoService.getAccessToken(code);
        System.out.println("access_Token : " + access_Token);
        HashMap<String, Object> userInfo = KakaoService.getUserInfo(access_Token);
        System.out.println("login Controller : " + userInfo);
        
        //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
        if (userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("access_Token", access_Token);
        }
        
		return "login/login_complete";

	}
	
}
