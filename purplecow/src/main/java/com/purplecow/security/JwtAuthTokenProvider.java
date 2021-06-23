package com.purplecow.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.security.Keys;

@Component
public class JwtAuthTokenProvider{

    private final Key key;
    private final String secret ="12345678901234567890123456789012";

    public JwtAuthTokenProvider() {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public JwtAuthToken createAuthToken(String id, String role, Date expiredDate) {
        return new JwtAuthToken(id, role, expiredDate, key);
    }

    public JwtAuthToken convertAuthToken(String token) {
        return new JwtAuthToken(token, key);
    }
}
