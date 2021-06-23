package com.purplecow.service;

import java.util.Optional;

import com.purplecow.dto.MemberDTO;

import com.purplecow.security.JwtAuthToken;

public interface LoginUseCase {
    Optional<MemberDTO> login(String id, String password);
    JwtAuthToken createAuthToken(MemberDTO memberDTO);
}
