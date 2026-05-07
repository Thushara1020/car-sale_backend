package com.example.car.sale.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    private Integer id;

    @NotBlank(message = "The brand name must be present.")
    private String brand;

    @NotBlank(message = "The brand name must be present.")
    private String model;

    @NotNull(message = "Price entry is mandatory.")
    @Positive(message = "Price must always be a positive value.")
    private Double price;

    @NotBlank(message = "Enter the status (available/sold)")
    @Pattern(regexp = "(?i)^(available|sold)$", message = "The status should only be 'available' or 'sold'.")
    private String status;

    @Min(value = 1886, message = "The world's first car couldn't have been a year earlier.")
    @Max(value = 2026, message = "The year of manufacture cannot be a future year.")
    private Integer year;
}