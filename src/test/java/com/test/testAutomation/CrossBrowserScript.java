package com.test.testAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.collect.Iterators;
import com.test.testAutomation.pageObjects.AppointmentPage;
import com.test.testAutomation.pageObjects.BillingCyclePage;
import com.test.testAutomation.pageObjects.ContactInformationPage;
import com.test.testAutomation.pageObjects.HomePage;
import com.test.testAutomation.pageObjects.SignUpPage;
import com.test.testAutomation.pageObjects.VerifyAddressPage;


public class CrossBrowserScript {

		WebDriver driver;
		private static XSSFSheet ExcelWSheet;
		private static XSSFWorkbook ExcelWBook;
		private static XSSFCell Cell;
		
		/**
		 * This function will execute before each Test tag in testng.xml
		 * @param browser
		 * @throws Exception
		 */
		
		@BeforeMethod
		@Parameters({"browser"})
		public void setup(String browser) throws Exception{
			//Check if parameter passed from TestNG is 'firefox'
			if(browser.equalsIgnoreCase("firefox")){
				//set path to chromedriver.exe
				//For Windows OS, uncomment bellow line, and comment next line
				//System.setProperty("webdriver.gecko.driver","src/test/resources/Drivers/geckodriver.exe");
				//For MAC OS, install geckodriver in system and use below line
				System.setProperty("webdriver.gecko.driver","/Applications/geckodriver");
				
				//create firefox instance
				driver = new FirefoxDriver();
			}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("chrome")){
				//set path to chromedriver.exe
				//For Windows OS, uncomment bellow line, and comment next line
				//System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver.exe");
				//For MAC OS, install chromedriver in system, and use below line
				System.setProperty("webdriver.chrome.driver","/Applications/chromedriver");
				
				//create chrome instance
				driver = new ChromeDriver();
			}
			else{
				//If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@AfterMethod
		public void closeBrowser() throws Exception{
			driver.close();
			driver.quit();
		}
		
		@Test(dataProvider = "testDataForRun")
		public void run(String address, String unit, String firstName, String lastName, String phone, String emailID, String emailConfirmation) throws InterruptedException {
			
			System.out.println(address);
			System.out.println(unit);
			System.out.println(firstName);
			System.out.println(lastName);
			System.out.println(phone);
			System.out.println(emailID);
			System.out.println(emailConfirmation);
			
			driver.get("https://webpass.net/san_diego/residential");
			
			HomePage homePage=new HomePage(driver);
			homePage.clickOnMap(address);
			
			SignUpPage signUpPageObject=new SignUpPage(driver);
			signUpPageObject.fillSignUpPage(unit);
			
			VerifyAddressPage verifyAddressPageObject= new VerifyAddressPage(driver);
			verifyAddressPageObject.verifyAddressAndContinue();
			
			BillingCyclePage billingCyclePageObject=new BillingCyclePage(driver);
			billingCyclePageObject.clickOnBillingCycle();
			
			AppointmentPage appointmentPage=new AppointmentPage(driver);
			appointmentPage.setAppointment();
			
			ContactInformationPage contactInformationPageObject=new ContactInformationPage(driver);
			contactInformationPageObject.fillContactInformationForm(firstName, lastName, phone, emailID, emailConfirmation);
		}
		
		//@DataProvider
		@DataProvider (name = "testDataForRun")
	    public Object[][] runDataProvider() throws Exception{
	        //Object[][] retObjArr=getTableArray("/Resources/Data/TestData.xlsx", "run");
			Object[][] retObjArr=getTableArray("src/test/resources/Data/TestData.xlsx", "run");
	        
			System.out.println(retObjArr);
	        return(retObjArr);
	    }
		
		
		
		public String[][] getTableArray(String xlFilePath, String testName) throws Exception{
			String[][] tabArray = null;
			try {
				FileInputStream ExcelFile = new FileInputStream(xlFilePath);
				ExcelWBook = new XSSFWorkbook(ExcelFile);
				ExcelWSheet = ExcelWBook.getSheetAt(0);
				int startRow = 1;
				int startCol = 1;
				Iterator<Row> rowIterator = ExcelWSheet.iterator();

				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();
					int totalCols = Iterators.size(cellIterator);
					int totalRows = Iterators.size(rowIterator);
					tabArray = new String[totalRows][totalCols - 1];
					int ci = 0;
					for (int i = startRow; i <= totalRows; i++, ci++) {
						String excelData = getCellData(i, 0);
						int cj = 0;
						if (excelData.equalsIgnoreCase(testName)) {
							for (int j = startCol; j < totalCols; j++, cj++) {
								excelData = getCellData(i, j);
								tabArray[ci][cj] = excelData;
							}
						}
					}
				}
			} catch (IOException e) {
				System.out.println("Could not read the Excel sheet");
				e.printStackTrace();
			}
			return (tabArray);
			
		}
		
		public static String getCellData(int RowNum, int ColNum) throws Exception {
			try {
				//DataFormatter formatter = new DataFormatter();
				Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
				String CellData = Cell.getStringCellValue();
				System.out.println("CellData: "+CellData);
				return CellData;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw (e);
			}
		}

	}

