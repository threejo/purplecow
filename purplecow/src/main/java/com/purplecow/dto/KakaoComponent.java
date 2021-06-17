package com.purplecow.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "kakao.restapi")
@Component
public class KakaoComponent {

	private String key;

	public String getkey() {
		return key;
	}

	public void setkey(String key) {
		this.key = key;
	}

}