package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.repo.UserRepository;
import com.example.demo.request.LoginRequest;
import com.example.demo.response.LoginResponse;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user){
        return userRepository.save(user);
    }

    public LoginResponse login(LoginRequest request) {

        
        

        
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new InvalidCredentialsException("InValidUser"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new InvalidCredentialsException("InValidUser");
        }

        
        String status = switch (user.getLoginActive()) {
            case "Y" -> "Active";
            case "B" -> "BlockUser";
            case "P" -> "BlockPass";
            case "C" -> "ChangePass";
            case "A" -> "AlreadyActive";
            default  -> "InValidUser";
        };

        return new LoginResponse(user.getUsername(), status, user.getRole(), user.getUcode());
    }
}
