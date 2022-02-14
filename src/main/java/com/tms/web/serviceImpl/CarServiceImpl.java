package com.tms.web.serviceImpl;

import com.tms.web.entity.BRAND;
import com.tms.web.entity.Car;
import com.tms.web.entity.HibernateConfiguration;
import com.tms.web.service.CarService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

import static com.tms.web.entity.BRAND.forSetBrand;
import static com.tms.web.entity.HibernateConfiguration.*;

public class CarServiceImpl implements CarService {
    @Override
    public void save(Car car) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        forSetBrand(car);
        car.setIsInStore((car.getBrand()) == (BRAND.MERCEDES) ? true : false);
        car.setRelease(new Date());
        session.save(car);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Car> getAll() {
        SessionFactory sessionFactory = HibernateConfiguration.sessionFactory;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Car> cars = session.createQuery("from Car", Car.class).list();
        transaction.commit();
        session.close();
        return cars;
    }

    @Override
    public void delete(Car car) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Car number = session.createQuery("from Car where number = :number", Car.class)
                .setParameter("number", car.getNumber()).getSingleResult();
        session.delete(number);
        transaction.commit();
        session.close();
    }
}
