package com.example.RtiPioApi.service.common;

import com.example.RtiPioApi.dto.common.LoginRequest;
import com.example.RtiPioApi.dto.common.LoginResponse;
import com.example.RtiPioApi.security.JwtTokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    @Autowired
    public AuthService(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    public LoginResponse authenticate(LoginRequest loginRequest) {
        try {
            logger.info("Attempting to authenticate user: {}", loginRequest.getUsername());

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );


            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Generate JWT token
            String jwt = tokenProvider.generateToken(authentication);
            logger.info("Authentication successful for user: {}", loginRequest.getUsername());


            org.springframework.security.core.userdetails.User userDetails =
                    (org.springframework.security.core.userdetails.User) authentication.getPrincipal();


            String role = userDetails.getAuthorities().isEmpty() ? "UNKNOWN" :
                    userDetails.getAuthorities().iterator().next().getAuthority().replace("ROLE_", "");

            String publicAuthority = "Tripura Public Service Commission"; // Placeholder

            // Construct and return the LoginResponse
            return new LoginResponse("Login Successful", role, userDetails.getUsername(), publicAuthority, jwt);

        } catch (BadCredentialsException e) {
            logger.warn("Authentication failed for user {}: Invalid credentials.", loginRequest.getUsername());

            throw new BadCredentialsException("Invalid username or password.");
        } catch (Exception e) {
            logger.error("An unexpected error occurred during authentication for user {}: {}", loginRequest.getUsername(), e.getMessage(), e);

            throw new RuntimeException("An error occurred during login. Please try again.", e);
        }
    }
}
