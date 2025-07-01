package com.example.RtiPioApi.controller.common;

import com.example.RtiPioApi.dto.common.LoginRequest;
import com.example.RtiPioApi.dto.common.LoginResponse;
import com.example.RtiPioApi.service.common.AuthService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;

    @Autowired // Inject AuthService dependency
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login") // Maps POST requests to /api/auth/login
    public ResponseEntity<LoginResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        logger.info("Received login request for user: {}", loginRequest.getUsername());
        LoginResponse response = authService.authenticate(loginRequest);
        return ResponseEntity.ok(response); // Return 200 OK with the login response
    }
}
