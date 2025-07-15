package com.example.rtionlinepj.service.impl;

import com.example.rtionlinepj.dao.UserRepository;
import com.example.rtionlinepj.dto.LoginRequestDto;
import com.example.rtionlinepj.dto.LoginResponseDto;
import com.example.rtionlinepj.entity.User;
import com.example.rtionlinepj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginResponseDto login(LoginRequestDto request) {
        User user = userRepository.findByUsername(request.getUsername());

        if (user == null) {
            return new LoginResponseDto(null, "InValidUser", null, null, "User does not exist");
        }

        if (!user.getPassword().equals(request.getPassword())) {
            return new LoginResponseDto(null, "InValidUser", null, null, "Invalid password");
        }

        return new LoginResponseDto(
                user.getUsername(),
                user.getLoginActive(),
                user.getRole(),
                user.getUcode(),
                "Login successful"
        );
    }
}
