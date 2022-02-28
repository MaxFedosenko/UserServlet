package com.tms.web.service;

import com.tms.web.entities.Car;

public interface RegionService {

    void addRegion (String name);
    void addCars(Car car, Long id);


}
