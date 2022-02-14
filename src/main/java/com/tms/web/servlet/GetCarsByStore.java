package com.tms.web.servlet;

import com.tms.web.entity.Car;
import com.tms.web.entity.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/store")
public class GetCarsByStore extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  store = req.getParameter("store");
        Session session = HibernateConfiguration.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Car car = new Car();
        car.setIsInStore(store.equals("true") ? true : false);
        List<Car> isInStore;
        if (car.getIsInStore()) {
            isInStore = session.createQuery("from Car where isinstore is true", Car.class).list();
        } else {
            isInStore = session.createQuery("from Car where isinstore is false", Car.class).list();
        }
        System.out.println(isInStore);
        transaction.commit();
        session.close();
    }
}
