package com.tms.web.service;

import com.tms.web.entity.Car;

import java.util.List;

public interface CarService {

    void save(Car car);

    List<Car> getAll();

    void delete(Car car);

}
