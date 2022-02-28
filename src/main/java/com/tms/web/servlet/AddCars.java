package com.tms.web.servlet;

import com.tms.web.entities.Car;
import com.tms.web.service.CarService;
import com.tms.web.service.ClientService;
import com.tms.web.serviceImpl.CarServiceImpl;
import com.tms.web.serviceImpl.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addcars")
public class AddCars extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idCar = Long.valueOf(req.getParameter("idCar"));
        Long idClient = Long.valueOf(req.getParameter("idClient"));
        ClientService clientService = new ClientServiceImpl();
        CarService carService = new CarServiceImpl();
        Car car = carService.getByID(idCar);
        clientService.addCar(car, idClient);
    }
}
