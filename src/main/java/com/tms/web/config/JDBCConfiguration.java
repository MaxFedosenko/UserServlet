package com.tms.web.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConfiguration {

    public static Connection getConnect() {
        return JDBCConfiguration.setConnect();
    }

    public static Connection setConnect(){

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String userName = "postgres";
        String password = "1840625";
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
