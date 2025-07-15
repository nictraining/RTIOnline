package com.example.rtionlinepj.controller;

import com.example.rtionlinepj.dto.LoginRequestDto;
import com.example.rtionlinepj.dto.LoginResponseDto;
import com.example.rtionlinepj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rti-nodal")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
        LoginResponseDto response = loginService.login(request);

        if ("InValidUser".equals(response.getLoginActive())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        return ResponseEntity.ok(response);
    }
}
