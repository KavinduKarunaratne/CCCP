package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Step 1: Create a private static instance of the class.
    private static DatabaseConnection instance;
    private Connection connection;

    // Database credentials
    private final String url = "jdbc:mysql://localhost:3306/test?characterEncoding=latin1";
    private final String username = "root";
    private final String password = "";

    // Step 2: Make the constructor private to prevent instantiation.
    private DatabaseConnection() throws SQLException {
        try {
            // Step 3: Load the MySQL JDBC driver.
            Class.forName("com.mysql.jdbc.Driver");
            // Step 4: Initialize the connection.
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    // Step 5: Provide a public static method to get the instance.
    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    // Step 6: Provide a method to get the database connection.
    public Connection getConnection() {
        return connection;
    }

    // Optionally, provide a method to close the connection.
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

