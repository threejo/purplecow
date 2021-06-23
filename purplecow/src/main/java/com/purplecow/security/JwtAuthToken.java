package com.purplecow.security;

import java.security.Key;
import java.util.Date;
import java.util.Optional;

import exception.CustomJwtRuntimeException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SecurityException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthToken implements AuthToken<Claims> {

    @Getter
    private final String token;
    private final Key key;

    private static final String AUTHORITIES_KEY = "role";

    /*생성자*/
    JwtAuthToken(String token, Key key) {
        this.token = token;
        this.key = key;
    }

    JwtAuthToken(String id, String role, Date expiredDate, Key key) {
        this.key = key;
        this.token = createJwtAuthToken(id, role, expiredDate).get();
    }
    //getData를 걸쳐 에러 검사를 했는지 검증
    @Override
    public boolean validate() {
        return getData() != null;
    }
    //validate() 하기 위한 에러 검사
  //token 으로 부터 payload 를 추출하는 메서드
    @Override
    public Claims getData() {

        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (SecurityException e) {
            log.info("Invalid JWT signature.");
            throw new CustomJwtRuntimeException();
        } catch (MalformedJwtException e) {
            log.info("Invalid JWT token.");
            throw new CustomJwtRuntimeException();
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT token.");
            throw new CustomJwtRuntimeException();
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT token.");
            throw new CustomJwtRuntimeException();
        } catch (IllegalArgumentException e) {
            log.info("JWT token compact of handler are invalid.");
            throw new CustomJwtRuntimeException();
        }
    }
    /*토큰 생성
     * 전달받은 id, 권한, 만료 시간을 통해
     * HS256 알고리즘으로 암호화하여
     * 토큰을 생성한 뒤 반환한다*/
    private Optional<String> createJwtAuthToken(String id, String role, Date expiredDate) {

        String token = Jwts.builder()
                .setSubject(id) // 토큰 용도 
                .claim(AUTHORITIES_KEY, role) // Claims 설정
                .signWith(key, SignatureAlgorithm.HS256)// HS256로 Sign
                .setExpiration(expiredDate) //토큰 만료 시간 설정
                .compact();//토큰 생성

        return Optional.ofNullable(token);
    }
}