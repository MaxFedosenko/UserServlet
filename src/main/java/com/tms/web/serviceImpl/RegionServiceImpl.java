package com.tms.web.serviceImpl;

import com.tms.web.entities.Car;
import com.tms.web.entities.Region;
import com.tms.web.service.RegionService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static com.tms.web.config.HibernateConfiguration.sessionFactory;

public class RegionServiceImpl implements RegionService {
    @Override
    public void addCars(Car car, Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Region region = session.createQuery("from Region where id = :id", Region.class)
                .setParameter("id", id).getSingleResult();
        car.getRegions().add(region);
        region.getCars().add(car);
        session.saveOrUpdate(region);
        session.saveOrUpdate(car);
        transaction.commit();
        session.close();
    }

    @Override
    public void addRegion(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Region region = new Region();
        region.setName(name);
        session.save(region);
        transaction.commit();
        session.close();
    }
}
