package poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFromExcel {
    Workbook workbook;

@Test
    public void readData1() throws IOException {

    File excellFile = new File("src/test/resources/testData.xlsx");

    FileInputStream fileInputStream = new FileInputStream(excellFile);


    //get whole excel structure
    Workbook workbook = new XSSFWorkbook(fileInputStream);

    //get first sheet
    Sheet sheet = workbook.getSheet("Sheet1");

    //get first row
    Row row1 = sheet.getRow(0);

    //get first cell/column
    Cell cell1 = row1.getCell(0);


    String firstName = cell1.toString();

    Assert.assertEquals("First name ", firstName);


}
    @Test

    public void readData2() throws IOException {

    File excelfile=new File("src/test/resources/testData.xlsx");

    FileInputStream fileInputStream=new FileInputStream(excelfile);

    Workbook workbook=new XSSFWorkbook(fileInputStream);
    Sheet sheet1=workbook.getSheetAt(0);
    Row row1= sheet1.getRow(0);

    for(int i= row1.getFirstCellNum();i<row1.getLastCellNum();i++){

        Cell tempCell=row1.getCell(i);
        System.out.print(tempCell+" |");
    }

    }



        @Test
        public void readData3() {

            Sheet sheet = workbook.getSheet("Sheet1");
            int totalRows = sheet.getLastRowNum();

            for(int i = sheet.getFirstRowNum(); i<totalRows; i++){
                Row tempRow = sheet.getRow(i);
                for(int j = tempRow.getFirstCellNum(); j< tempRow.getLastCellNum(); j++){
                    Cell tempCell = tempRow.getCell(j);
                    System.out.print(tempCell+ " | ");
                }
            }

        }

    @Before
    public void setup() throws IOException {
        File excelFile = new File("src/test/resources/testData.xlsx");
        FileInputStream fileInputStream = new FileInputStream(excelFile); //IT MAKES COPY OF ORIGINAL file
        workbook = new XSSFWorkbook(fileInputStream);
    }



    }








