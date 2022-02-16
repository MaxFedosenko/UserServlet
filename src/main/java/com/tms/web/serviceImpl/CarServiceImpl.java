package com.tms.web.serviceImpl;

import com.tms.web.entity.BRAND;
import com.tms.web.entity.Car;
import com.tms.web.config.HibernateConfiguration;
import com.tms.web.service.CarService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

import static com.tms.web.entity.BRAND.forSetBrand;
import static com.tms.web.config.HibernateConfiguration.*;

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
    public void getByID(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Car car = session.createQuery("from Car where id = :id", Car.class)
                .setParameter("id", id).getSingleResult();
        System.out.println(car);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Integer number) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Car car = session.createQuery("from Car where number = :number", Car.class)
                .setParameter("number", number).getSingleResult();
        session.delete(car);
        transaction.commit();
        session.close();
    }

    @Override
    public void carCondition(Long id) {
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

    @Override
    public void getCarsByBrand(BRAND brand) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Car> cars = session.createQuery("from Car where brand = :brand", Car.class)
                .setParameter("brand", brand).list();
        System.out.println(cars);
        transaction.commit();
        session.close();
    }

    @Override
    public void getCarsByStore(String store) {
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
