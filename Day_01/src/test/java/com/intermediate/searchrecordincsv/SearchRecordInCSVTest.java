package com.intermediate.searchrecordincsv;

import com.intermediateproblem.searchrecordincsv.SearchRecordInCSV;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.*;

public class SearchRecordInCSVTest {

    private static final String TEST_FILE_PATH = "D:/riya/Employee.csv";
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputStream;

    @Test
    void testSearchEmployeeFound() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE_PATH, StandardCharsets.UTF_8))) {
            writer.write("ID,NAME,DEPARTMENT,SALARY\n");
            writer.write("1,Pragya,IT,45000\n");
            writer.write("2,Sakshi,FINANCE,47000\n");
            writer.write("3,Unaiz,HR,60000\n");
            writer.write("4,Shubhi,TR,55000\n");
            writer.write("5,Riya,CIVIL,40000\n");
        }

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String input = "Riya\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        SearchRecordInCSV.searchRecordInCSV();

        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains("Employee Found"));
        assertTrue(consoleOutput.contains("Department: CIVIL"));
        assertTrue(consoleOutput.contains("Salary: 40000"));

    }

}
