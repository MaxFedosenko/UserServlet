package com.tms.web.servlet;

import com.tms.web.config.JDBCConfiguration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;

@WebServlet(value = "/home")
public class PersonServlet extends HttpServlet {

    public Connection connection = JDBCConfiguration.getConnect();

    @Override
    public void init(ServletConfig config) throws ServletException {
        Connection connect = JDBCConfiguration.getConnect();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/AuthorizationPage.html").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from person");
            while (resultSet.next()) {
                String log = resultSet.getString("login");
                String pass = resultSet.getString("password");
                String role = resultSet.getString("role");
                if (log.equals(login)) {
                    if (pass.equals(password)) {
                        if (role.equals("admin")) {
                            req.getRequestDispatcher("/WEB-INF/pages/RegistrationPage.html").forward(req, resp);
                        } else {
                            req.getRequestDispatcher("/WEB-INF/pages/UserPage.html").forward(req, resp);
                        }
                    }
                }
            }
            req.getRequestDispatcher("/WEB-INF/pages/ErrorPage.html").forward(req, resp);
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
}
