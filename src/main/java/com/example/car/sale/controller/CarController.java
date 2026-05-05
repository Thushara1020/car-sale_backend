package com.example.car.sale.controller;

import com.example.car.sale.dto.CarDTO;
import com.example.car.sale.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/save")
    public CarDTO addCar(@RequestBody CarDTO carDTO) {
        return carService.saveCar(carDTO);
    }

    @GetMapping
    public List<CarDTO> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public CarDTO getCarById(@PathVariable int id) {
        return carService.getCarById(id);
    }

    @PutMapping("/{id}")
    public CarDTO updateCar(@PathVariable int id, @RequestBody CarDTO carDTO) {
        return carService.updateCar(id, carDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable int id) {
        boolean deleted = carService.deleteCar(id);
        return deleted ? "Delete Car" : "Vehicle cannot be found.";
    }
}