package com.tms.web.config;

import com.tms.web.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class HibernateConfiguration {

    public static SessionFactory sessionFactory;
    private HibernateConfiguration(){

    }

    public static void prepareHibernate() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "1840625");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");

        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        configuration.setProperty("hibernate.format_sql", "true");
        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Region.class);
//        configuration.addAnnotatedClass(Parent.class);
//        configuration.addAnnotatedClass(Home.class);

        sessionFactory = configuration.buildSessionFactory();
    }

//    public static void testParent(){
//
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//
//        Home home1 = new Home(null, 12L, 3L, null);
//        Home home2 = new Home(null, 1L, 30L, null);
//        Parent parent1 = new Parent(null, "parent1", Arrays.asList(home1, home2));
//
//        home1.setParent(parent1);
//        home2.setParent(parent1);
//
//        session.save(parent1);
//        session.save(home1);
//        session.save(home2);
//        transaction.commit();
//        session.close();
//
//    }

}
