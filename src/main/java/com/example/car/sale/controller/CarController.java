package com.example.car.sale.controller;

import com.example.car.sale.dto.CarDTO;
import com.example.car.sale.service.CarService;
import jakarta.validation.Valid; // Validation සඳහා
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/save")
    public ResponseEntity<CarDTO> addCar(@Valid @RequestBody CarDTO carDTO) {
        CarDTO savedCar = carService.saveCar(carDTO);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars() {
        List<CarDTO> allCars = carService.getAllCars();
        return ResponseEntity.ok(allCars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable int id) {
        CarDTO carDTO = carService.getCarById(id);
        if (carDTO != null) {
            return ResponseEntity.ok(carDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable int id, @Valid @RequestBody CarDTO carDTO) {
        CarDTO updatedCar = carService.updateCar(id, carDTO);
        if (updatedCar != null) {
            return ResponseEntity.ok(updatedCar);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable int id) {
        boolean deleted = carService.deleteCar(id);
        if (deleted) {
            return ResponseEntity.ok("Deleted Car ID: " + id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle cannot be found.");
    }
}