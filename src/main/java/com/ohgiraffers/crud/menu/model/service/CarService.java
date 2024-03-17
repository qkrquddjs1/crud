package com.ohgiraffers.crud.menu.model.service;

import com.ohgiraffers.crud.menu.model.dao.CarMapper;
import com.ohgiraffers.crud.menu.model.dto.CarDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarMapper carMapper;

    public CarService(CarMapper carMapper) { this.carMapper = carMapper; }


    public List<CarDTO> findAllCar() { return carMapper.findAllCar(); }

    public void registCar(CarDTO car) { carMapper.registCar(car);
    }
}
