package com.basicprobelm.writedatatocsvfile;

import com.basicproblem.writedatatocsvfile.WriteDataToCSVFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class WriteDataToCSVFileTest {

    @Test
    void testwriteDataToCSVFileExample(){
        String filePath = "D:/Training/Employeee.CSV";
        try {
            WriteDataToCSVFile.writeDataToCSVFile(filePath);
        } catch (Exception e) {
            fail("Method should handle invalid file path gracefully: " + e.getMessage());
        }
    }

}
