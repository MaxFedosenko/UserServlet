package com.tms.web.service;

import com.tms.web.entity.BRAND;
import com.tms.web.entity.Car;

import java.util.List;

public interface CarService {

    void save(Car car);

    List<Car> getAll();

    void getByID(Long id);

    void delete(Integer number);

    void carCondition(Long id);

    void getCarsByBrand(BRAND brand);

    void getCarsByStore(String store);

}
