package com.example.RtiPioApi.security;

import com.example.RtiPioApi.entity.user.User;
import com.example.RtiPioApi.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));


        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), // Calls getUsername() from our User entity
                user.getPassword(), // Calls getPassword() from our User entity
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().toUpperCase())) // Calls getRole() from our User entity
        );
    }
}
