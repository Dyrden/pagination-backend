package com.example.paginationcars.repository;

import com.example.paginationcars.dto.CarSpecification;
import com.example.paginationcars.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer>, JpaSpecificationExecutor<Car> {
    Page<Car> findCarsByBrand(String brand, Pageable pageable);

    Page<Car> findAll(Specification<Car> specification, Pageable pageRequest);
}
