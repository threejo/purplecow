package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.purplecow.security.JwtAuthTokenProvider;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;



@Configuration
@Slf4j
public class JwtConfiguration {

	/*
	 * @Value("${jwt.secret}") private String secret;
	 * 
	 * @Bean public JwtAuthTokenProvider JwtAuthTokenProvider() {
	 * log.info("시크릿 키의 값은 ---->"+secret); return new
	 * JwtAuthTokenProvider("12345678901234567890123456789012"); }
	 */
    
    
}
