package com.tms.web.entity;

public class Person {

    private String login;
    private String password;
    private String sex;
    private String description;
    private String role;

    public Person() {

    }

    public Person(String login, String password, String sex, String description, String role) {
        this.login = login;
        this.password = password;
        this.sex = sex;
        this.description = description;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", description='" + description + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
