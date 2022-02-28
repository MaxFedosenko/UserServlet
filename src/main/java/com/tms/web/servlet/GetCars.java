package com.tms.web.servlet;

import com.tms.web.entities.Car;
import com.tms.web.serviceImpl.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getall")
public class GetCars extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CarServiceImpl carService = new CarServiceImpl();
        List<Car> all = carService.getAll();
        System.out.println(all);
    }
}
