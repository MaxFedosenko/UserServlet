package com.tms.web.service;

import com.tms.web.entities.BRAND;
import com.tms.web.entities.Car;


import java.util.List;

public interface CarService {

    void save(Car car);

    List<Car> getAll();

    Car getByID(Long id);

    void delete(Integer number);

    void carCondition(Long id);

    void getCarsByBrand(BRAND brand);

    void getCarsByStore(String store);

}
