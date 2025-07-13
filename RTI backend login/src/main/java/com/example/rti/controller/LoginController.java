package com.example.rti.controller;

import com.example.rti.dto.LoginRequest;
import com.example.rti.dto.LoginResponse;
import com.example.rti.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rti-citizen")
public class LoginController {
    private final LoginService loginService;
    public LoginController(LoginService loginService) { this.loginService = loginService; }
}