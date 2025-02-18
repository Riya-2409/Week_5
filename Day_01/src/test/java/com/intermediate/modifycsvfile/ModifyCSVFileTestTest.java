package com.intermediate.modifycsvfile;

import com.intermediateproblem.modifycsvfile.ModifyCSVFile;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModifyCSVFileTestTest {

    private static final String TEST_INPUT_CSV = "D:/Training/Employeee.CSV";
    private static final String TEST_OUTPUT_CSV = "D:/calculator/Employee_updated.csv";

    @Test
    public void testSalaryUpdate() throws IOException {
        // Create a test CSV file
        createTestCSV();

        // Run the salary update function
        ModifyCSVFile.updateSalaries(TEST_INPUT_CSV, TEST_OUTPUT_CSV);

        // Read the updated file and check IT employees' salaries
        List<String> lines = Files.readAllLines(Paths.get(TEST_OUTPUT_CSV));
        for (String line : lines) {
            if (line.contains("IT")) {
                String[] columns = line.split(",");
                double salary = Double.parseDouble(columns[4]);
                assertTrue(salary > 495000);
            }
        }
    }

    private void createTestCSV() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_INPUT_CSV))) {
            writer.println("ID,Name,Department,Salary");
            writer.println("1,Pragya,IT,49500");
            writer.println("2,Sakshi,FINANCE,47000");
            writer.println("3,Unaiz,HR,60000");
            writer.println("4,Shubhi,TR,55000");
            writer.println("5,Riya,CIVIL,40000");
        }
    }
}