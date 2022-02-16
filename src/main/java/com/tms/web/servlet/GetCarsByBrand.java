package com.tms.web.servlet;

import com.tms.web.entity.BRAND;
import com.tms.web.service.CarService;
import com.tms.web.serviceImpl.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/brand")
public class GetCarsByBrand extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BRAND brand = BRAND.valueOf(req.getParameter("brand"));
        CarService carService = new CarServiceImpl();
        carService.getCarsByBrand(brand);
    }
}
