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
    public Connection createConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(H2ConnectionFactory.class.getClassLoader().getResourceAsStream("app.properties"));

        String url = properties.getProperty("db_url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        return DriverManager.getConnection(url, user, password);
    }
}

