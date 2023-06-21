package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;
import org.h2.mode.FunctionsPostgreSQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory  implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        Connection connection = null;
        try {
            Properties properties = new Properties();
            properties.load(H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties"));

            String url = properties.getProperty("db_url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

