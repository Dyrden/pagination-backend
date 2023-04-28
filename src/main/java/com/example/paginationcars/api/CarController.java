package com.example.paginationcars.api;

import com.example.paginationcars.dto.CarPageResponse;
import com.example.paginationcars.dto.CarResponse;
import com.example.paginationcars.dto.CarSpecification;
import com.example.paginationcars.entity.Car;
import com.example.paginationcars.service.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/cars")
public class CarController {

    CarService carService;

    public CarController(CarService service) {
        this.carService = service;
    }

    @GetMapping()
    public List<Car> getCars(Pageable pageRequest) {
        Page<Car> carPage = carService.getCarPage(pageRequest);

        return carPage.getContent();
    }
    @GetMapping("/brand/{brand}")
    public Object getCarsByBrand(@PathVariable(name = "brand") String brand, Pageable pageRequest) {
        Page<Car> carPage = carService.getCarPageByBrand( brand , pageRequest);

        return CarPageResponse.builder().total(carPage.getTotalElements()).cars(carPage.getContent()).build();
    }

    @GetMapping("/filter")
    public Object getCarsByFilter(@RequestParam("column") String column, @RequestParam("val") String val, Pageable pageRequest) {
        Page<Car> carPage = carService.getCarByFilter(new CarSpecification(column,val),pageRequest);

        return CarPageResponse.builder().total(carPage.getTotalElements()).cars(carPage.getContent()).build();
    }


}
