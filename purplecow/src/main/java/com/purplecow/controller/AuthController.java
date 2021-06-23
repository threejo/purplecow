package com.purplecow.controller;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purplecow.dto.Cars;
import com.purplecow.dto.Users;
import com.purplecow.security.JwtAuthToken;
import com.purplecow.security.JwtAuthTokenProvider;
import com.purplecow.security.TokenValidation;
import com.purplecow.service.AuthService;
import com.purplecow.utils.CommonResponse;
import com.purplecow.utils.Role;

import exception.CustomAuthenticationException;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class AuthController {

	@Autowired
	AuthService authService;
	@Autowired
	TokenValidation tokenValidation;
	


	@GetMapping("/api/v1/cars")
	public Object getAllCars(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Object handler) {

		
		if(tokenValidation.tokenIsVaild(servletRequest)) return authService.findAll();
		else return CommonResponse.builder()
                .code("INVALID_JWT_TOKEN")
                .status(401)
                .message("INVALID_JWT_TOKEN.")
                .build();
           
        
		

	}
	
	 @GetMapping("/api/v2/cars")
	    public List<Cars> getAllCars2(HttpSession session) {
	        return authService.findAll();
	    }
	
	
	
	
	

}
