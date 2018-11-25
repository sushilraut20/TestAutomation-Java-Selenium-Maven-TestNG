package com.test.testAutomation.pageObjects;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.testAutomation.utils.Utilities;





//import com.test.automation.challenge.pageObjects.HomePage;
//import com.test.automation.challenge.utils.ExcelUtils;

public class ExcelTest {
	
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	WebDriver driver;
	Utilities utilities=new Utilities();
	By elementfirstName=By.xpath("//*[@id=\"first-name\"]");
	By elementlastName=By.xpath("//*[@id=\"last-name\"]");
	By elementphoneNumber=By.xpath("//*[@id=\"phone\"]");
	By elementemailID=By.xpath("//*[@id=\"email\"]");
	By elementemailConfirmation=By.xpath("//*[@id=\"email-confirm\"]");
	By elementhowDidYouHearAboutUs=By.xpath("//*[@id=\"referral-id\"]");
	By elementsourceOption=By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div[1]/form/div[9]/div/select/option[3]");
	By elementcontinueButton=By.xpath("//*[@id=\"signup-view\"]/div[2]/button[2]");
	
	
	public ExcelTest(WebDriver driver) {
		this.driver=driver;
	}

	@DataProvider(name = "testDataForRun")
 //   public Object[][] createData1() throws InterruptedException{
	//	System.out.println("createdata object ke andar aaya ");
//        Object[][] retObjArr=getTableArray("Resources/Data/TestData.xlsx",
  //              "Sheet1");
 //       return(retObjArr);
  //  }
	
	@Test(dataProvider = "testDataForRun")
	public void exceldata(String firstName, String lastName, String phone, String emailID, String emailConfirmation) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		System.out.println("excel data ke andar aaya ");
		WebElement firstNameWebElement=driver.findElement(elementfirstName);
        firstNameWebElement.sendKeys(firstName);
		
        WebElement lastNameWebElement=driver.findElement(elementlastName);
        lastNameWebElement.sendKeys(lastName);
        
        //String longToString = ""+ phone;
        WebElement phoneWebElement=driver.findElement(elementlastName);
        phoneWebElement.sendKeys(phone);
        //phoneWebElement.sendKeys(longToString);
        
        WebElement emailIDWebElement=driver.findElement(elementlastName);
        emailIDWebElement.sendKeys(emailID);
        
        WebElement emailIDConfirmationWebElement=driver.findElement(elementlastName);
        emailIDConfirmationWebElement.sendKeys(emailConfirmation);
		
        WebElement source=driver.findElement(elementhowDidYouHearAboutUs);
        source.click();
        
        Thread.sleep(2000);
        
        WebElement sourceOptionWebElement=driver.findElement(elementsourceOption);
        sourceOptionWebElement.click();
        
        Thread.sleep(1000);
        
        WebElement continueButtonWebElement=driver.findElement(elementcontinueButton);
		continueButtonWebElement.click();
		
		Thread.sleep(4000);
		
		ConfirmationPage confirmationPageObject=new ConfirmationPage(driver);
		
		confirmationPageObject.verifyConfirmationPage();
	}

	
	}
