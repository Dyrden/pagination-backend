package com.example.paginationcars.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Car {
    @Id
    int id;

    String brand;
    String model;
    String color;
    int kilometers;
    LocalDateTime created;
    LocalDateTime updated;
}
