package com.example.tpchifoumipoe.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
    private static Connection connection;

    private ConnectionManager() {
    }

    public static Connection getConnection() {

        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chifoumi", "root", "abdallah");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}