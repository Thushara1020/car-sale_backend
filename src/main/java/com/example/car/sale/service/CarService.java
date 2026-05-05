package com.example.car.sale.service;

import com.example.car.sale.dto.CarDTO;
import java.util.List;

public interface CarService {
    CarDTO saveCar(CarDTO carDTO);
    List<CarDTO> getAllCars();
    CarDTO getCarById(int id);
    CarDTO updateCar(int id, CarDTO carDTO);
    boolean deleteCar(int id);
}