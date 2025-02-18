package com.intermediateproblem.filterrecordfromcsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecordFromCSV {
    public static void filterRecords(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader("D:/calculator/Book.csv"))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String id = columns[0];
                String name = columns[1];
                String age = columns[2];
                int marks = Integer.parseInt(columns[3]);

                // Filter students with marks greater than 80
                if (marks > 80) {
                    System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
