package com.tms.web.servlet;

import com.tms.web.entity.Person;
import com.tms.web.serviceImpl.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin")
public class PersonAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/RegistrationPage.html").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String description = req.getParameter("description");
        String role = req.getParameter("role");
        Person person = new Person(login, password, sex, description, role);
        PersonServiceImpl personService = new PersonServiceImpl();
        try {
            personService.savePerson(person);
            req.getRequestDispatcher("/WEB-INF/pages/UserAdd.html").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
