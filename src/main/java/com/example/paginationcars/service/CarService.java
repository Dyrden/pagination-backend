package com.example.paginationcars.service;

import com.example.paginationcars.dto.CarSpecification;
import com.example.paginationcars.entity.Car;
import com.example.paginationcars.repository.CarRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public Page<Car> getCarPage(Pageable pageRequest) {
        return carRepository.findAll(pageRequest);
    }

    public Page<Car> getCarPageByBrand(String brand, Pageable pageRequest) {
        return carRepository.findCarsByBrand(brand, pageRequest);
    }

    public Page<Car> getCarByFilter(CarSpecification specification, Pageable pageRequest) {
        return carRepository.findAll(specification,pageRequest);
    }
}
