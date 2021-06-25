package com.purplecow.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.purplecow.dto.LoginRequestDTO;
import com.purplecow.dto.MemberDTO;
import com.purplecow.security.JwtAuthToken;
import com.purplecow.service.LoginService;
import com.purplecow.utils.CommonResponse;

import exception.LoginFailedException;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class LoginController {

	@Autowired LoginService loginService; 

    /*로그인 요청
     * 이메일과 패스워드로 된 dto가 리퀘스트바디로 전달되면
     * 서비스에서 유저 권한과 유저이름을 넣어서 멤버 객체로 만들어 반환해준다.
     * 해당 맴버가 있으면 현재시간+30분의 유효기간의 토큰을 발행하고 문자열 형태의 토큰,키를 메세지로 로그인 성공 코드를 반환한다
     * 해당 멤버가 없으면 로그인실패 예외처리한다.*/
    @PostMapping("/api/v1/login")
    public CommonResponse login(@RequestBody LoginRequestDTO loginRequestDTO) {
    	log.info("loginRequestDTO"+String.valueOf(loginRequestDTO));
        Optional<MemberDTO> optionalMemberDTO = loginService.login(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());
        log.info("optionalMemberDTO"+String.valueOf(optionalMemberDTO));
        if (optionalMemberDTO.isPresent()) {        	
            JwtAuthToken jwtAuthToken = (JwtAuthToken) loginService.createAuthToken(optionalMemberDTO.get());

            return CommonResponse.builder()
                    .code("LOGIN_SUCCESS")
                    .status(200)
                    .message(jwtAuthToken.getToken())
                    .build();

        } else {
            throw new LoginFailedException();
        }
    }
}
