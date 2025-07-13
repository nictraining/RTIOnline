package com.example.rti.service;

import com.example.rti.dto.LoginRequest;
import com.example.rti.dto.LoginResponse;

public interface LoginService {
    LoginResponse authenticate(LoginRequest req);
}
