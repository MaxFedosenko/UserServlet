package com.tms.web.servlet;

import com.tms.web.entity.BRAND;
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

@WebServlet("/brand")
public class GetCarsByBrand extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BRAND brand = BRAND.valueOf(req.getParameter("brand"));
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Car> brand1 = session.createQuery("from Car where brand = :brand", Car.class)
                .setParameter("brand", brand).list();
        System.out.println(brand1);
        transaction.commit();
        session.close();
    }
}
