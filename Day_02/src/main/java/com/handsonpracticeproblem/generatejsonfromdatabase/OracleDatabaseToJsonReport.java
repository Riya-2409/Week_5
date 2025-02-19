package com.handsonpracticeproblem.generatejsonfromdatabase;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.sql.*;
import java.util.*;
public class OracleDatabaseToJsonReport {
    public static void main(String[] args) {
        String dbUrl = "jdbc:oracle:thin:@//riyasoni:1521/xe";
        String dbUsername = "oraclebatch";
        String dbPassword = "riya";

        String query = "SELECT id, name, email, age FROM users";

        // Initialize the ObjectMapper for converting to JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // List to hold the records as maps (each row as a map)
        List<Map<String, Object>> records = new ArrayList<>();

        // JDBC Connection and Query Execution
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Process each row of the result set
            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("id", resultSet.getInt("id"));
                row.put("name", resultSet.getString("name"));
                row.put("email", resultSet.getString("email"));
                row.put("age", resultSet.getInt("age"));

                // Add the row to the list of records
                records.add(row);
            }

            // Convert the list of records to JSON
            String jsonReport = objectMapper.writeValueAsString(records);

            // Print the JSON report to the console
            System.out.println(jsonReport);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}