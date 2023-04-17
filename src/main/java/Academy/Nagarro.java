package Academy;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;

import org.apache.poi.ss.usermodel.DataFormatter;

import pageObjects.NagLandingPage;
import resources.base;

public class Nagarro extends base {
	NagLandingPage NagarroPage = new NagLandingPage();
	public WebDriver driver;
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static FileInputStream fis;

	public static DataFormatter formatter = new DataFormatter();
	
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
	}
	
	@Test
	public void testNagarroROICalculator() throws IOException{
		driver.get("https://www.nagarro.com/");
		
		
		// go to roi calculator
		NagarroPage.HoverServicesTab(driver);
		NagarroPage.clickTestQualityOption(driver);
		NagarroPage.clickFindROI(driver);
		
		//sliders input
		
		NagarroPage.send(driver);
		
		NagarroPage.send(driver);
		NagarroPage.send(driver);
		
		
		//enter and signup
		NagarroPage.clickCalculateRoiButton(driver);
		NagarroPage.signupDetails(driver, "Nagarro","Nagarro","a@a.com");
		
		
		NagarroPage.downloadPdf(driver);
		
		//NagarroPage.send(driver);
		
		
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}
	
	@DataProvider

	    public Object[][] getData() throws IOException {

	        FileInputStream fileInputStream = new FileInputStream(".\\src\\main\\java\\resources\\RoiDatafile.xlsx"); // Excel

	                                                                                                                    // sheet

	        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream); // get my workbook

	        sheet = workbook.getSheetAt(0);// get my sheet from workbook

	        XSSFRow Row = sheet.getRow(0); // get my Row which start from 0

	 

	        int RowNum = sheet.getPhysicalNumberOfRows();// count my number of Rows

	        int ColNum = Row.getLastCellNum(); // get last ColNum

	 

	        Object Data[][] = new Object[RowNum - 1][ColNum]; // pass my count data in array

	 

	        for (int i = 0; i < RowNum - 1; i++) // Loop work for Rows

	        {

	            XSSFRow row = sheet.getRow(i + 1);

	 

	            for (int j = 0; j < ColNum - 2; j++) // Loop work for colNum

	            {

	                if (row == null)

	                    Data[i][j] = "";

	                else {

	                    XSSFCell cell = row.getCell(j);

	                    if (cell == null)

	                        Data[i][j] = ""; // if it get Null value it pass no data

	                    else {

	                        String value = formatter.formatCellValue(cell);

	                        Data[i][j] = value; // This formatter get my all values as string i.e integer, float all type

	                                    System.out.println("Value------------------"+value);        // data value

	                    }

	                }

	            }

	        }

	        System.out.println("data is " + Data);

	        return Data;

	 

	    }

}
