package com.tms.web.service;

import com.tms.web.entities.Car;
import com.tms.web.entities.Client;

import java.util.List;

public interface ClientService {

    void saveClient(String name);

    void addCar(Car car, Long id);



}
