package com.tms.web.service;

import com.tms.web.entities.Person;

import java.sql.SQLException;

public interface PersonService {

    void savePerson(Person person) throws SQLException;

}
