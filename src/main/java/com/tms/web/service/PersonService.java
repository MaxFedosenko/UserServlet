package com.tms.web.service;

import com.tms.web.entity.Person;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

public interface PersonService {

    void savePerson(Person person) throws SQLException;

}
