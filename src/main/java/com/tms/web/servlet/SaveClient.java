package com.tms.web.servlet;

import com.tms.web.entities.BRAND;
import com.tms.web.entities.Car;
import com.tms.web.entities.Client;
import com.tms.web.service.CarService;
import com.tms.web.service.ClientService;
import com.tms.web.serviceImpl.CarServiceImpl;
import com.tms.web.serviceImpl.ClientServiceImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.tms.web.config.HibernateConfiguration.sessionFactory;

@WebServlet("/client")
public class SaveClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        ClientService clientService = new ClientServiceImpl();
        clientService.saveClient(name);





    }
}
