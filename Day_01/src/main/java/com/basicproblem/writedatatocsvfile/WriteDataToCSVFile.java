package com.basicproblem.writedatatocsvfile;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class WriteDataToCSVFile {
    public static void writeDataToCSVFile(String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter("D:/Training/Employeee.CSV"))) {
            String[] header = {"ID", "Name", "Department", "Salary"};
            String[] emp1 = {"1", "Pragya", "IT", "45000"};
            String[] emp2 = {"2", "Sakshi", "FINANCE", "47000"};
            String[] emp3 = {"3", "Unaiz", "HR", "60000"};
            String[] emp4 = {"4", "Shubhi", "TR", "55000"};
            String[] emp5 = {"5", "Riya", "CIVIL", "40000"};

            writer.writeNext(header);
            writer.writeNext(emp1);
            writer.writeNext(emp2);
            writer.writeNext(emp3);
            writer.writeNext(emp4);
            writer.writeNext(emp5);

            System.out.println("CSV file written successfully using OpenCSV!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
