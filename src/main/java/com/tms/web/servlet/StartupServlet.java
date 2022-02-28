package com.tms.web.servlet;

import com.tms.web.config.HibernateConfiguration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import static com.tms.web.config.HibernateConfiguration.*;

@WebServlet(value = "/", loadOnStartup = 1)
public class StartupServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

        prepareHibernate();
    }
}