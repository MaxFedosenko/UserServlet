package com.tms.web.servlet;

import com.tms.web.serviceImpl.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteCars extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer number = Integer.valueOf(req.getParameter("number"));
        CarServiceImpl carService = new CarServiceImpl();
        carService.delete(number);
    }
}
