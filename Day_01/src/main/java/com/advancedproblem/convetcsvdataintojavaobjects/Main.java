package com.advancedproblem.convetcsvdataintojavaobjects;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "D:/riya/Student.CSV";
        List<Student> students = CSVToStudent.readCSV(filePath);
        students.forEach(System.out::println);
    }
}
