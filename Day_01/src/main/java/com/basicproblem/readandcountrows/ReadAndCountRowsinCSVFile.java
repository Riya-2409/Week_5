package com.basicproblem.readandcountrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountRowsinCSVFile {
    public static int readAndCountRowsInCSVFile(String filePath){
        int rowCount = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("D:/Training/Employeee.CSV"))){
            String line;
            while((line = br.readLine())!=null){
                String columns[] = line.split(",");
                rowCount++;
            }
            System.out.println("Number of records (excluding header): " + rowCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rowCount;
    }
}
