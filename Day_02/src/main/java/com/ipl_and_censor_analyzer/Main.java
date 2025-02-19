package com.ipl_and_censor_analyzer;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Process JSON file
            IPLJSONProcessor.processJson("D:\\Capgemini_Week_5\\Day_02\\src\\main\\java\\com\\ipl_and_censor_analyzer\\input_data.json", "D:\\Capgemini_Week_5\\Day_02\\src\\main\\java\\com\\ipl_and_censor_analyzer\\output_data.json");
            // Process CSV file
            IPLCSVProcessor.processCsv("D:\\Capgemini_Week_5\\Day_02\\src\\main\\java\\com\\ipl_and_censor_analyzer\\input_data.csv", "D:\\Capgemini_Week_5\\Day_02\\src\\main\\java\\com\\ipl_and_censor_analyzer\\output_data.csv");

            System.out.println("Data has been successfully sanitized and written to output files.");
        } catch ( IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
}