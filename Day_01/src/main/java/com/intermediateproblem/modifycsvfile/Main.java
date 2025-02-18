package com.intermediateproblem.modifycsvfile;

public class Main {

    public static void main(String[] args) {
        String inputFile = "D:/Training/Employeee.CSV";
        String outputFile = "D:/calculator/Employee_updated.csv";
        ModifyCSVFile.updateSalaries(inputFile, outputFile);
    }
}
