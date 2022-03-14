package com.tms.web.serviceImpl;

import com.tms.web.entities.Car;
import com.tms.web.entities.Region;
import com.tms.web.service.RegionService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static com.tms.web.config.HibernateConfiguration.sessionFactory;

public class RegionServiceImpl implements RegionService {
    @Override
    public void addCars(Long idCar, Long idRegion) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Car car = session.createQuery("from Car where id = :id", Car.class)
                .setParameter("id", idCar).getSingleResult();
        Region region = session.createQuery("from Region where id = :id", Region.class)
                .setParameter("id", idRegion).getSingleResult();
        car.getRegions().add(region);
        transaction.commit();
        session.close();
    }

    @Override
    public void saveOrAdd(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Region region = new Region();
        region.setName(name);
        session.save(region);
        transaction.commit();
        session.close();
    }
}
