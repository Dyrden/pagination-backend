package com.example.paginationcars.dto;

import com.example.paginationcars.entity.Car;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class CarSpecification implements Specification<Car> {
    private final String column;
    private final String value;

    public CarSpecification(String column, String value) {
        this.column = column;
        this.value = value;
    }

    @Override
    public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Path<Object> path = root.get(column);
        return criteriaBuilder.equal(path, value);
    }
}



