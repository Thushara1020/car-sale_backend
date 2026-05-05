package com.example.car.sale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private Integer id;
    private String brand;
    private String model;
    private Double price;
    private String status;
}