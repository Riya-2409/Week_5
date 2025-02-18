package com.advancedproblem.jsoncsvconverter;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonCsvConverter {

        private static final String JSON_FILE = "students.json";
        private static final String CSV_FILE = "students.csv";

        public static void jsonCSVConverter() {
            try {
                // Step 1: Read JSON and convert to CSV
                List<Student> students = readJson(JSON_FILE);
                writeCsv(students, CSV_FILE);
                System.out.println("CSV file generated successfully!");

                // Step 2: Read CSV and convert back to JSON
                List<Student> convertedStudents = readCsv(CSV_FILE);
                writeJson(convertedStudents, "converted_students.json");
                System.out.println("JSON file generated from CSV successfully!");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static List<Student> readJson(String jsonFile) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(jsonFile), new TypeReference<List<Student>>() {});
        }

        public static void writeCsv(List<Student> students, String csvFile) throws IOException {
            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
                writer.writeNext(new String[]{"Name", "Age", "Grade"});
                for (Student student : students) {
                    writer.writeNext(new String[]{student.getName(), String.valueOf(student.getAge()), student.getGrade()});
                }
            }
        }

        public static List<Student> readCsv(String csvFile) throws IOException {
            List<Student> students = new ArrayList<>();
            try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
                String[] line;
                boolean skipHeader = true;
                while ((line = reader.readNext()) != null) {
                    if (skipHeader) { // Skip header row
                        skipHeader = false;
                        continue;
                    }
                    students.add(new Student(line[0], Integer.parseInt(line[1]), line[2]));
                }
            }
            return students;
        }

        public static void writeJson(List<Student> students, String jsonFile) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(jsonFile), students);
        }
    }


