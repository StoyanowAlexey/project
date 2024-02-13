package com.lesha.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection{

    private static final String URL = System.getenv("DATABASE_URL");
    private static final String USER = System.getenv("USERNANE");
    private static final String PASSWORD = System.getenv("PASSWORD");
    public static Connection connect() throws SQLException {
           return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
