package com.tms.web.servlet;

import com.tms.web.entity.Car;
import com.tms.web.serviceImpl.CarServiceImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.tms.web.entity.HibernateConfiguration.sessionFactory;

@WebServlet("/id")
public class GetCarsByID extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.valueOf(req.getParameter("id"));
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Car id1 = session.createQuery("from Car where id = :id", Car.class)
                .setParameter("id", id).getSingleResult();
        System.out.println(id1);
        transaction.commit();
        session.close();
    }
}
