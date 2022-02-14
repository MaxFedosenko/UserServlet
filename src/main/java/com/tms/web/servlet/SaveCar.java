package com.tms.web.servlet;

import com.tms.web.entity.BRAND;
import com.tms.web.entity.Car;
import com.tms.web.serviceImpl.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/savecar")
public class SaveCar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer number = Integer.valueOf(req.getParameter("number"));
        CarServiceImpl saveCar = new CarServiceImpl();
        Car car = new Car();
        car.setNumber(number);
        saveCar.save(car);
    }
}
