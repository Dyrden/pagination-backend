package com.example.paginationcars.dto;

import com.example.paginationcars.entity.Car;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarPageResponse {

    Long total;

    List<Car> cars;


}
