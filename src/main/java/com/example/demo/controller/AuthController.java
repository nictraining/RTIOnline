package com.example.demo.controller;



import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.LoginRequest;
import com.example.demo.response.LoginResponse;
import com.example.demo.service.AuthService;


@RestController
@RequestMapping("/rti-faa")
@CrossOrigin
public class AuthController {
    public static final Map<String, String> captchaStore = new ConcurrentHashMap<>();

    @Autowired
    private AuthService authService;
   

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
     
    }

   
}

