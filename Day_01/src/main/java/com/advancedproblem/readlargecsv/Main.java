package com.advancedproblem.readlargecsv;

public class Main {
    public static void main(String[] args) {
        String filePath = "D:/calculator/data.csv"; // Path to the large CSV file
        ReadLargeCSV.readCSVInChunks(filePath);
    }
}
