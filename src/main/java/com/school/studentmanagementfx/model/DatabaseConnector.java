package com.school.studentmanagementfx.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {

    private static final String URL = "jdbc:sqlite:students.db";

    private static Connection connection;

    private DatabaseConnector() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL);
            createTablesIfNotExists(connection);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTablesIfNotExists(Connection connection) throws SQLException {
        String sql = """
                    CREATE TABLE IF NOT EXISTS student (
                        id TEXT PRIMARY KEY,
                        name TEXT,
                        age TEXT,
                        birthday TEXT,
                        address TEXT,
                        course TEXT,
                        year TEXT,
                        email TEXT
                    );
                """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }
}
