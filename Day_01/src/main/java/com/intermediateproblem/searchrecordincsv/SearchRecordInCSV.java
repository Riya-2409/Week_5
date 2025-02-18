package com.intermediateproblem.searchrecordincsv;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class SearchRecordInCSV {

    public static void searchRecordInCSV() {
        String filePath = "D:/riya/Employee.csv";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            boolean found = false;

            br.readLine(); // Skip the header row

            while ((line = br.readLine()) != null) {
                String[] data = line.replace("\r", "").split("\\s*,\\s*");

                if (data.length >= 4) {
                    String name = data[1].trim();
                    String department = data[2].trim();
                    String salary = data[3].trim();

                    if (name.equalsIgnoreCase(searchName)) {
                        System.out.println("Employee Found:");
                        System.out.println("Department: " + department);
                        System.out.println("Salary: " + salary);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

