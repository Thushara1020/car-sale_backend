package com.example.car.sale.service.impl;

import com.example.car.sale.dto.CarDTO;
import com.example.car.sale.entity.Car;
import com.example.car.sale.repository.CarRepository;
import com.example.car.sale.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public CarDTO saveCar(CarDTO carDTO) {
        Car car = new Car();

        car.setBrand(carDTO.getBrand());
        car.setModel(carDTO.getModel());
        car.setPrice(carDTO.getPrice());
        car.setStatus(carDTO.getStatus().trim().toLowerCase());
        car.setYear(carDTO.getYear());

        Car savedCar = carRepository.save(car);

        CarDTO result = new CarDTO();
        result.setId(savedCar.getId());
        result.setBrand(savedCar.getBrand());
        result.setModel(savedCar.getModel());
        result.setPrice(savedCar.getPrice());
        result.setStatus(savedCar.getStatus());
        result.setYear(savedCar.getYear());
        return result;
    }

    @Override
    public List<CarDTO> getAllCars() {
        return carRepository.findAll().stream()
                .map(car -> {
                    CarDTO dto = new CarDTO();
                    dto.setId(car.getId());
                    dto.setBrand(car.getBrand());
                    dto.setModel(car.getModel());
                    dto.setPrice(car.getPrice());
                    dto.setStatus(car.getStatus());
                    dto.setYear(car.getYear());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CarDTO getCarById(int id) {
        Car car = carRepository.findById(id).orElse(null);
        if (car != null) {
            CarDTO dto = new CarDTO();
            dto.setId(car.getId());
            dto.setBrand(car.getBrand());
            dto.setModel(car.getModel());
            dto.setPrice(car.getPrice());
            dto.setStatus(car.getStatus());
            dto.setYear(car.getYear());
            return dto;
        }
        return null;
    }

    @Override
    public CarDTO updateCar(int id, CarDTO carDTO) {
        if (carRepository.existsById(id)) {
            Car car = new Car();
            car.setId(id);
            car.setBrand(carDTO.getBrand());
            car.setModel(carDTO.getModel());
            car.setPrice(carDTO.getPrice());
            car.setStatus(carDTO.getStatus().trim().toLowerCase());
            car.setYear(carDTO.getYear());
            carRepository.save(car);
            carDTO.setId(id);
            carDTO.setStatus(car.getStatus());
            return carDTO;
        }
        return null;
    }

    @Override
    public boolean deleteCar(int id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }
}