package com.tms.web.servlet;

import com.tms.web.config.HibernateConfiguration;
import com.tms.web.entities.Car;
import com.tms.web.entities.Client;
import com.tms.web.serviceImpl.CarServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/savecar")
public class SaveCar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer number = Integer.valueOf(req.getParameter("number"));
        CarServiceImpl carService = new CarServiceImpl();
        Car car = new Car();
        car.setNumber(number);
        carService.save(car);
    }
}
