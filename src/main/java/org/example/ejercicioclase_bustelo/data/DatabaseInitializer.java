package org.example.ejercicioclase_bustelo.data;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initialize(DataSource dataSource) {
        executeScript(dataSource, "/init.sql");
    }

    public static void executeScript(DataSource dataSource, String script) {
        InputStream inputStream = DatabaseInitializer.class.getResourceAsStream(script);
        if (inputStream == null) {
            throw new RuntimeException("Script file not found: " + script);
        }

        StringBuilder sql = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trim = line.trim();
                if (trim.isEmpty() || trim.startsWith("--")) {
                    continue; // Skip empty lines and comments
                }
                sql.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading script file: " + script, e);
        }

        try (Connection connection = dataSource.getConnection();)
             Statement statement = connection.createStatement()) {
            statement.execute(sql.toString());
        } catch (SQLException e) {
            throw new RuntimeException("Error executing script: " + script, e);
        }
    }

}

