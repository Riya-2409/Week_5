package com.basicprobelm.readcsvfile;

import com.basicproblem.readcsvfile.ReadCSV;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadCSVTest {

    @Test
    void testReadCSVFile() throws IOException {
        String testCsvFile = "test_student.csv";
        List<String> lines = new ArrayList<>();
        lines.add("1,Pragya,21,98");
        lines.add("2,Sakshi,22,97");
        lines.add("3,Unaiz,22,96");
        lines.add("4,Shubhi,21,95");
        lines.add("5,Riya,21,94");
        Files.write(Paths.get(testCsvFile), lines);

        ReadCSV.readCSVFile();

        Files.deleteIfExists(Paths.get(testCsvFile));
    }
}
