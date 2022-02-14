package com.tms.web.serviceImpl;

import com.tms.web.config.JDBCConfiguration;
import com.tms.web.entity.Person;
import com.tms.web.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class PersonServiceImpl implements PersonService {

    private Connection connection = JDBCConfiguration.getConnect();

    @Override
    public void savePerson(Person person) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into person (login, password, sex, description, role) values (?, ?, ?, ?, ?)");
        statement.setString(1, person.getLogin());
        statement.setString(2, person.getPassword());
        statement.setString(3, person.getSex());
        statement.setString(4, person.getDescription());
        statement.setString(5, person.getRole());
        statement.executeUpdate();
    }
}
