package com.tms.web.servlet;

import com.tms.web.entity.BRAND;
import com.tms.web.entity.Car;
import com.tms.web.entity.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Date;

@WebServlet(value = "/", loadOnStartup = 1)
public class StartupServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

        HibernateConfiguration.prepareHibernate();
    }
}