package com.purplecow.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purplecow.dto.MemberDTO;
import com.purplecow.dto.Users;
import com.purplecow.mapper.UsersMapper;
import com.purplecow.security.ErrorCode;
import com.purplecow.security.JwtAuthToken;
import com.purplecow.security.JwtAuthTokenProvider;
import com.purplecow.utils.CommonResponse;
import com.purplecow.utils.Role;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {

    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    private final static long LOGIN_RETENTION_MINUTES = 30;
    @Autowired UsersMapper usersMapper;

    @Override
    public Optional<MemberDTO> login(String email, String password) {

        //해당 이메일의 유저가 있는지 확인
    	Users existing = usersMapper.getUserByEmail(email);
    	if(existing != null) {
    		//비밀번호가 일치하는 경우
    		if(existing.getPassword().equals(password)) {
    			 //로그인 성공했다고 가정하고..
    	        MemberDTO memberDTO = MemberDTO.builder()
    	                .userName(existing.getName())
    	                .email(email)
    	                .role(Role.USER)
    	                .build();

    	        return Optional.ofNullable(memberDTO);
    		}
    		//비밀번호가 다를 경우
    		else {
    			return Optional.empty();
    		}
    	}
    	else return Optional.empty();
       
    }

    //TODO: 네이밍
    @Override
    public JwtAuthToken createAuthToken(MemberDTO memberDTO) {

        Date expiredDate = Date.from(LocalDateTime.now().plusMinutes(LOGIN_RETENTION_MINUTES).atZone(ZoneId.systemDefault()).toInstant());
        return jwtAuthTokenProvider.createAuthToken(memberDTO.getEmail(), memberDTO.getRole().getCode(), expiredDate);
    }
}