package com.purplecow.security;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.purplecow.utils.Role;

import exception.CustomAuthenticationException;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class TokenValidation {
	
	@Autowired JwtAuthTokenProvider jwtAuthTokenProvider;
	private static final String AUTHORIZATION_HEADER = "x-auth-token";

	
	public boolean tokenIsVaild(HttpServletRequest servletRequest) {
		log.info("-----------토큰 확인중--------------");
		Optional<String> token = resolveToken(servletRequest);
		 if (token.isPresent()) {
	        	
	        	log.info("토큰 존재하나요?"+token.isPresent());
	        	JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
	        	if(jwtAuthToken.validate() & Role.USER.getCode().equals(jwtAuthToken.getData().get("role"))) {
	        		return true;
	        	}
	        	else {
	                return false;
	            }
	        } else {
	            return false;
	        }
		
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
