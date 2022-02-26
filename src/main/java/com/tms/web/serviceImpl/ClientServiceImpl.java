package com.tms.web.serviceImpl;

import com.tms.web.entities.Car;
import com.tms.web.entities.Client;
import com.tms.web.service.ClientService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.tms.web.config.HibernateConfiguration.sessionFactory;


public class ClientServiceImpl implements ClientService {
    @Override
    public void saveClient(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Client client = new Client();
        client.setName(name);
        session.save(client);
        transaction.commit();
        session.close();
    }

    @Override
    public void addCar(Car car, Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Client client = session.createQuery("from Client where id = :id", Client.class)
                .setParameter("id", id).getSingleResult();
        car.setClient(client);
        client.getCars().add(car);
        session.saveOrUpdate(car);
        transaction.commit();
        session.close();
    }
}
