package com.tms.web.servlet;

import com.tms.web.entity.Car;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.tms.web.entity.HibernateConfiguration.sessionFactory;

@WebServlet("/condition")
public class CarCondition extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Car car = session.createQuery("from Car where id = :id", Car.class)
                .setParameter("id", id).getSingleResult();
        Boolean isInStore = car.getIsInStore();
        car.setIsInStore(isInStore == true ? false : true);
        session.saveOrUpdate(car);
        System.out.println(car);
        transaction.commit();
        session.close();
    }
}
