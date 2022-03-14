package com.tms.web.serviceImpl;

import com.tms.web.entities.Car;
import com.tms.web.entities.Client;
import com.tms.web.service.ClientService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static com.tms.web.config.HibernateConfiguration.sessionFactory;


public class ClientServiceImpl implements ClientService {
    @Override
    public void save(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Client client = new Client();
        client.setName(name);
        session.save(client);
        transaction.commit();
        session.close();
    }

    @Override
    public void addCar(Long idCar, Long idClient) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Car car = session.createQuery("from Car where id = :id", Car.class)
                .setParameter("id", idCar).getSingleResult();
        Client client = session.createQuery("from Client where id = :id", Client.class)
                .setParameter("id", idClient).getSingleResult();
        car.setClient(client);
        transaction.commit();
        session.close();
    }
}
