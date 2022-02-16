package com.tms.web.servlet;

import com.tms.web.service.CarService;
import com.tms.web.serviceImpl.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/store")
public class GetCarsByStore extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  store = req.getParameter("store");
        CarService carService = new CarServiceImpl();
        carService.getCarsByStore(store);
    }
}
