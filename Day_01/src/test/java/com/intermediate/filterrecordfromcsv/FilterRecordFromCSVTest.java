package com.intermediate.filterrecordfromcsv;

import com.intermediateproblem.filterrecordfromcsv.FilterRecordFromCSV;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterRecordFromCSVTest {

    @Test
    public void testFilterRecords() {
        String filePath = "D:/calculator/Book.csv"; // Ensure this path is correct

        // Capture system output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Call the method
        FilterRecordFromCSV.filterRecords(filePath);

        // Reset System.out before assertions
        System.setOut(System.out);

        // Get captured output and trim spaces/newlines
        String output = outputStream.toString().trim();
        System.out.println("Captured Output:\n" + output); // Debugging line

        // Verify expected output
        assertTrue(output.contains("ID: 1, Name: Ram, Age: 21, Marks: 88"),
                "Output should contain 'ID: 1, Name: Ram, Age: 21, Marks: 88'. Found: " + output);
        assertTrue(output.contains("ID: 2, Name: Riya, Age: 21, Marks: 98"),
                "Output should contain 'ID: 2, Name: Riya, Age: 21, Marks: 98'. Found: " + output);
    }

}

