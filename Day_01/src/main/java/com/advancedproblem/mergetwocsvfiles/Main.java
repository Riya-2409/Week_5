package com.advancedproblem.mergetwocsvfiles;

public class Main {
    public static void main(String[] args) {
        String file1Path = "D:/calculator/Student1.csv";  // students1.csv path
        String file2Path = "D:/calculator/Student2.csv";  // students2.csv path
        String outputPath = "D:/calculator/merge_student.csv";  // Output file path

        MergeCSV.mergeCSVFiles(file1Path, file2Path, outputPath);
    }
}
