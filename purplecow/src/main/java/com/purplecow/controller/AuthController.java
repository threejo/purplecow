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
import com.purplecow.service.AuthService;

import config.provider.Role;
import exception.CustomAuthenticationException;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class AuthController {

	@Autowired
	AuthService authService;
	@Autowired JwtAuthTokenProvider jwtAuthTokenProvider;
	private static final String AUTHORIZATION_HEADER = "x-auth-token";


	@GetMapping("/api/v1/cars")
	public List<Cars> getAllCars(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Object handler) {

		log.info("preHandle!!");

        Optional<String> token = resolveToken(servletRequest);
        log.info("token 객체는?"+token);
        //헤더에 토큰이 존재한다면
        if (token.isPresent()) {
        	
        	log.info("토큰 존재"+token.isPresent());
        	//문자열 형태의 토큰에서 토큰 객체로 변환
            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
            //토큰이 검증되고 헤더에서 받은 토큰의 권한이 유저일 경우 true 그외의 경우는 다 예외처리
            if(jwtAuthToken.validate() & Role.USER.getCode().equals(jwtAuthToken.getData().get("role"))) {
            	return authService.findAll();
            }
            else {
                throw new CustomAuthenticationException();
            }
        } else {
            throw new CustomAuthenticationException();
        }
		

	}
	
	 @GetMapping("/api/v2/cars")
	    public List<Cars> getAllCars2(HttpSession session) {
	        return authService.findAll();
	    }
	
	
	
	
	private Optional<String> resolveToken(HttpServletRequest request) {
    	//요청에서 헤더에서 'x-auth-token'의 값 가져와서 값이 있는지 확인 후 리턴
        String authToken = request.getHeader(AUTHORIZATION_HEADER);
        log.info("헤더에서 토큰 가져와"+authToken);
        if (StringUtils.hasText(authToken)) {
            return Optional.of(authToken);
        } else {
            return Optional.empty();
        }
    }

}
