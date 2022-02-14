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
        if (store.equals("true")){
            car.setIsInStore(true);
        } else {
            car.setIsInStore(false);
        }

        List<Car> isinstore;
        if (car.getIsInStore()) {
            isinstore = session.createQuery("from Car where isinstore is true", Car.class).list();
        } else {
            isinstore = session.createQuery("from Car where isinstore is false", Car.class).list();
        }
        System.out.println(isinstore);
        transaction.commit();
        session.close();
    }
}
