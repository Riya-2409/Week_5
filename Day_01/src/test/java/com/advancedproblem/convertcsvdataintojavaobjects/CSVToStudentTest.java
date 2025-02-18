package com.advancedproblem.convertcsvdataintojavaobjects;

import com.advancedproblem.convetcsvdataintojavaobjects.CSVToStudent;
import com.advancedproblem.convetcsvdataintojavaobjects.Student;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVToStudentTest {

    private static final String TEST_CSV_FILE = "D:/riya/Student.CSV";

    @Test
    public void testReadCSV() throws IOException {
        createTestCSV();
        List<Student> students = CSVToStudent.readCSV(TEST_CSV_FILE);
        assertEquals(4, students.size()); // Expecting 4 valid records
    }

    private void createTestCSV() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_CSV_FILE))) {
            writer.println("ID,Name,Age,Marks");
            writer.println("101,Pragya,21,98.0");
            writer.println("102,Sakshi,22,96.0");
            writer.println("103,Unaiz,22,Invalid");
            writer.println("104,Shubhi,21,95.0");
            writer.println("105,Riya,21,94.0");
        }
    }
}
