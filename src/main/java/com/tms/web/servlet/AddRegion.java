package com.tms.web.servlet;

import com.tms.web.service.RegionService;
import com.tms.web.serviceImpl.RegionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addregion")
public class AddRegion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idCar = Long.valueOf(req.getParameter("idCar"));
        Long idRegion = Long.valueOf(req.getParameter("idRegion"));
        RegionService regionService = new RegionServiceImpl();
        regionService.addCars(idCar, idRegion);
    }
}
