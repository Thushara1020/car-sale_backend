package com.example.car.sale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private int id;
    private String brand;
    private String model;
    private double price;
    private String status;
}