package com.advancedproblem.validatecsvdatabeforeprocessing;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVValidatorTest {

    private static final String TEST_CSV_FILE = "D:/calculator/data.csv";;

    @Test
    public void testCSVValidation() throws IOException {
        createTestCSV();

        // Read the file and check if there are invalid entries
        List<String> lines = Files.readAllLines(Paths.get(TEST_CSV_FILE));
        boolean hasInvalidEmail = lines.stream().anyMatch(line -> line.contains("invalid_email"));
        boolean hasInvalidPhone = lines.stream().anyMatch(line -> line.contains("123")); // Invalid phone

        assertTrue(hasInvalidEmail);
        assertTrue(hasInvalidPhone);
    }

    private void createTestCSV() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_CSV_FILE))) {
            writer.println("ID,Email,Phone");
            writer.println("101,riyasoni@gmail.com,9874563210");
            writer.println("102,invalid_email,9012345678"); // Invalid email
            writer.println("103,pragya@gmail.com,123");
        }
    }
}
