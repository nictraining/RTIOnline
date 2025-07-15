package com.example.rtionlinepj.service;

import com.example.rtionlinepj.dto.LoginRequestDto;
import com.example.rtionlinepj.dto.LoginResponseDto;

public interface LoginService {
    LoginResponseDto login(LoginRequestDto request);
}
