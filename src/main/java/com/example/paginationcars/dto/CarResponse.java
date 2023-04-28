package com.example.paginationcars.dto;

import com.example.paginationcars.entity.Car;

public class CarResponse {

    int id;
    String brand;
    String model;
    String color;
    int kilometers;

    public CarResponse(Car car) {
        this.id = car.getId();
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.color = car.getColor();
        this.kilometers = car.getKilometers();
    }
}
