package com.purplecow.security;

import java.util.Date;

public interface AuthTokenProvider<T> {
	//아이디와 권한, 기한을 가지고 토큰생성
    T createAuthToken(String id, String role, Date expiredDate);
    //문자열로 된 토큰을 가지고 객체형태의 토큰으로 변환
    T convertAuthToken(String token);
}
