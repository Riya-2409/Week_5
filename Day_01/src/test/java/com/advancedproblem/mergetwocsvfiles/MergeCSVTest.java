package com.advancedproblem.mergetwocsvfiles;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MergeCSVTest {

    private static final String OUTPUT_FILE =  "D:/calculator/merge_student.csv";

    @Test
    public void testMergeCSVFiles() throws IOException {
        String file1Path = "D:/calculator/Student1.csv";
        String file2Path = "D:/calculator/Student2.csv";

        MergeCSV.mergeCSVFiles(file1Path, file2Path, OUTPUT_FILE);


        File outputFile = new File(OUTPUT_FILE);
        assertTrue(outputFile.exists());


        List<String> lines = java.nio.file.Files.readAllLines(outputFile.toPath());
        assertEquals(6, lines.size());
        assertTrue(lines.get(1).contains("101,Riya,21,98.2,A"));
        assertTrue(lines.get(2).contains("102,Shubhi,22,88,B"));
    }
}
