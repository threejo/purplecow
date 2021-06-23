package com.purplecow.service;

import java.util.Optional;

import com.purplecow.dto.MemberDTO;
import com.purplecow.security.AuthToken;

public interface LoginUseCase {
    Optional<MemberDTO> login(String id, String password);
    AuthToken createAuthToken(MemberDTO memberDTO);
}
