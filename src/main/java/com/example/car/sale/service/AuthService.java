package com.example.car.sale.service;

import com.example.car.sale.dto.AuthRequest;
import com.example.car.sale.entity.User;
import com.example.car.sale.repository.UserRepository;
import com.example.car.sale.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Password එක හංගන්න
        userRepository.save(user);
        return "User registered successfully";
    }

    public String authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        return jwtService.generateToken(request.getEmail());
    }
}