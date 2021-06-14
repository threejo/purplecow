package com.purplecow.common;

import java.net.URI;
import java.net.URLEncoder;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KakaoRestApiHelper {
	
	@Value("${kakao.restapi.key")
	private String restApiKey;
	
	private static final String API_SERVER_HOST = "https://dapi.kakao.com";
	private static final String SEARCH_PLACE_KEYWORD_PATH = "/v2/local/search/keyword.json";
	
	public ResponseEntity<String> getSearchPlaceByKeyword(SearchVO searchVO) throws Exception {
		 String queryString = "?query="+URLEncoder.encode(searchVO.getKeywordNm(), "UTF-8")+"&page="+searchVO.getCurrentPage()+"&size="+searchVO.getPageSize();
	        RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();

	        headers.add("Authorization", "KakaoAK " + restApiKey);
	        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

	        URI url = URI.create(API_SERVER_HOST+SEARCH_PLACE_KEYWORD_PATH+queryString);
	        RequestEntity<String> rq = new RequestEntity<>(headers, HttpMethod.GET, url);
	        ResponseEntity<String> re = restTemplate.exchange(rq, String.class);

	        return re; 
	}
	
	

}
