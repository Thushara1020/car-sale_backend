package com.example.car.sale.controller;

import com.example.car.sale.dto.AuthRequest;
import com.example.car.sale.dto.AuthResponse;
import com.example.car.sale.entity.User;
import com.example.car.sale.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        String token = authService.authenticate(request);
        return new AuthResponse(token);
    }
}