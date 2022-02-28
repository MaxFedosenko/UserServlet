package com.tms.web.servlet;

import com.tms.web.entities.Car;
import com.tms.web.service.CarService;
import com.tms.web.serviceImpl.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getAllCars")
public class GetAllCars extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarService carService = new CarServiceImpl();
        List<Car> allCars = carService.getAll();
        req.setAttribute("cars", allCars);
        req.getRequestDispatcher("/jsp/cars.jsp").forward(req, resp);
    }
}
