package com.intermediateproblem.sortscvrecordbycolumn;

public class Main {

    public static void main(String[] args) {
        String filePath = "D:/calculator/Employee.CSV";
        int topN = 5;
        SortCSVRecordByColumn.sortAndPrintTopSalaries(filePath, topN);
    }
}
