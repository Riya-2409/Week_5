package com.advancedproblem.mergetwocsvfiles;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MergeCSVTest {

        private static final String STUDENT1_FILE = "D:/calculator/test_student1.csv";
        private static final String STUDENT2_FILE = "D:/calculator/test_student2.csv";
        private static final String MERGED_FILE = "D:/calculator/test_merge_student.csv";

        @Test
        void testMergeCSVFiles() throws IOException {
            // Create Student1.csv file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENT1_FILE))) {
                writer.write("ID,NAME,AGE\n");
                writer.write("101,Riya,21\n");
                writer.write("102,Shubhi,22\n");
                writer.write("103,Pragya,23\n");
                writer.write("104,Sakshi,21\n");
                writer.write("105,Yaman,24\n");
                writer.write("106,Mohit,22\n");
            }

            // Create Student2.csv file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENT2_FILE))) {
                writer.write("ID,MARKS,GRADE\n");
                writer.write("101,98.2,A\n");
                writer.write("102,88,B\n");
                writer.write("103,86.12,B\n");
                writer.write("104,75.14,C\n");
                writer.write("105,67.2,C\n");
                writer.write("106,89.45,B\n");
            }

            // Merge the two CSV files
            MergeCSV.mergeCSVFiles(STUDENT1_FILE, STUDENT2_FILE, MERGED_FILE);

            // Verify that the merged file exists
            File mergedFile = new File(MERGED_FILE);
            assertTrue(mergedFile.exists(), "Merged file should be created.");

            // Verify the content of the merged file
            try (BufferedReader reader = new BufferedReader(new FileReader(MERGED_FILE))) {
                String line = reader.readLine();  // Read header
                assertEquals("ID,Name,Age,Marks,Grade", line, "Header should match the expected format.");

                // Check that each subsequent line contains the correct merged data
                String[] expectedData = {
                        "101,Riya,21,98.2,A",
                        "102,Shubhi,22,88,B",
                        "103,Pragya,23,86.12,B",
                        "104,Sakshi,21,75.14,C",
                        "105,Yaman,24,67.2,C",
                        "106,Mohit,22,89.45,B"
                };

                int lineCount = 0;
                while ((line = reader.readLine()) != null) {
                    assertEquals(expectedData[lineCount], line, "Merged data at line " + (lineCount + 1) + " is incorrect.");
                    lineCount++;
                }
            } catch (IOException e) {
                fail("Error reading the merged file: " + e.getMessage());
            }

        }


}
