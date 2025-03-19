package com.marktech.taskmanager.service;

import com.marktech.taskmanager.dto.AuthRequest;
import com.marktech.taskmanager.config.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public String login(AuthRequest authRequest) {
        try {
            // Perform Authentication
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );

            // Generate JWT Token using JwtTokenProvider
            return jwtTokenProvider.generateToken(authentication);
        } catch (Exception e) {
            return "Invalid username or password";
        }
    }
}
