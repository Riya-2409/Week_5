package com.basicprobelm.readandcountrows;


import com.basicproblem.readandcountrows.ReadAndCountRowsinCSVFile;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadAndCountRowsinCSVFileTest {

    @Test
    public void testReadAndCountRowsInCSVFile() {
        // Test with a sample file path
        String filePath = "D:/Training/Employeee.CSV";
        int expectedRowCount = 6;

        int rowCount = ReadAndCountRowsinCSVFile.readAndCountRowsInCSVFile(filePath);

        assertEquals(expectedRowCount, rowCount, "Row count should be " + expectedRowCount);
    }
}