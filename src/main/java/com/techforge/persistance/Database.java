package com.techforge.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/tech_forge";
    private static final String DEFAULT_USER = "root";
    private static final String DEFAULT_PASSWORD = "n3admin";

    public static Connection getConnection() throws SQLException {
        String url = System.getProperty("db.url",  System.getenv().getOrDefault("DB_URL", DEFAULT_URL));
        String user = System.getProperty("db.user", System.getenv().getOrDefault("DB_USER", DEFAULT_USER));
        String password = System.getProperty("db.password", System.getenv().getOrDefault("DB_PASS", DEFAULT_PASSWORD));
        return DriverManager.getConnection(url, user, password);
    }
}
