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
        car.setStatus(carDTO.getStatus());

        Car savedCar = carRepository.save(car);

        return new CarDTO(savedCar.getId(), savedCar.getBrand(), savedCar.getModel(), savedCar.getPrice(), savedCar.getStatus());
    }

    @Override
    public List<CarDTO> getAllCars() {
        return carRepository.findAll().stream()
                .map(car -> new CarDTO(car.getId(), car.getBrand(), car.getModel(), car.getPrice(), car.getStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public CarDTO getCarById(int id) {
        Car car = carRepository.findById(id).orElse(null);
        if (car != null) {
            return new CarDTO(car.getId(), car.getBrand(), car.getModel(), car.getPrice(), car.getStatus());
        }
        return null;
    }

    @Override
    public CarDTO updateCar(int id, CarDTO carDTO) {
        if (carRepository.existsById(id)) {
            Car car = new Car(id, carDTO.getBrand(), carDTO.getModel(), carDTO.getPrice(), carDTO.getStatus());
            carRepository.save(car);
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