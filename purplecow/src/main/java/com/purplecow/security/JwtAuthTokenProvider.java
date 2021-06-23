package com.purplecow.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtAuthTokenProvider implements AuthTokenProvider<JwtAuthToken> {

	private final Key key;
	private String secret = "12345678901234567890123456789012";
	/*constructor*/
	
	public JwtAuthTokenProvider() {
		log.info("JwtAuthTokenProvider 통과");
		this.key = Keys.hmacShaKeyFor(secret.getBytes());
	}

	// 아이디와 권한, 기한을 가지고 토큰생성
	@Override
	public JwtAuthToken createAuthToken(String id, String role, Date expiredDate) {
		
		return new JwtAuthToken(id, role, expiredDate, key);
	}

	// 문자열로 된 토큰을 가지고 JwtAuthToken형태의 토큰으로 변환
	@Override
	public JwtAuthToken convertAuthToken(String token) {
		return new JwtAuthToken(token, key);
	}

}
