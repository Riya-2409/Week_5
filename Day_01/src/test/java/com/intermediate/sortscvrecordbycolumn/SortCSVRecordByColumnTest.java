package com.intermediate.sortscvrecordbycolumn;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortCSVRecordByColumnTest {


        private static final String TEST_CSV_FILE = "D:/calculator/Employee.CSV";

        @Test
        public void testSortingBySalary() throws IOException {
            createTestCSV();

            List<String> lines = Files.readAllLines(Paths.get(TEST_CSV_FILE));
            assertTrue(lines.get(1).contains("Pragya"));
        }

        private void createTestCSV() throws IOException {
            try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_CSV_FILE))) {
                writer.println("ID,Name,Department,Salary");
                writer.println("1,Pragya,HR,45000");
                writer.println("102,Sakshi,IT,47000");
            }
        }
}
