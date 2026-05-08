package com.example.car.sale.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}