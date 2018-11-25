package com.test.testAutomation.pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.testAutomation.utils.*;

public class ContactInformationPage {
	
	WebDriver driver;
	
	Utilities utilities=new Utilities();
	By firstName=By.xpath("//*[@id=\"first-name\"]");
	By lastName=By.xpath("//*[@id=\"last-name\"]");
	By phoneNumber=By.xpath("//*[@id=\"phone\"]");
	By emailID=By.xpath("//*[@id=\"email\"]");
	By emailConfirmation=By.xpath("//*[@id=\"email-confirm\"]");
	By howDidYouHearAboutUs=By.xpath("//*[@id=\"referral-id\"]");
	By sourceOption=By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div[1]/form/div[9]/div/select/option[3]");
	By continueButton=By.xpath("//*[@id=\"signup-view\"]/div[2]/button[2]");
	
	String randomString=utilities.returnRandomString();
	
	public ContactInformationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void insertFirstName(String input_firstName) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        WebElement firstNameWebElement=driver.findElement(firstName);
   
        firstNameWebElement.sendKeys(input_firstName);
        
        Thread.sleep(1000);
		
	}
	
	public void insertLastName(String input_lastName) throws InterruptedException {
        WebElement lastNameWebElement=driver.findElement(lastName);
       
        lastNameWebElement.sendKeys(input_lastName);
        
        Thread.sleep(1000);
		
	}
	
	public void insertPhoneNumber(String input_phoneNumber) throws InterruptedException {
        WebElement phoneNumberWebElement=driver.findElement(phoneNumber);
        
        phoneNumberWebElement.sendKeys(input_phoneNumber);
        
        Thread.sleep(1000);
		
	}
	
	public void insertEmailID(String input_emailID) throws InterruptedException {
		WebElement emailIDWebElement=driver.findElement(emailID);
		
		emailIDWebElement.sendKeys(input_emailID);
        
        Thread.sleep(1000);
       	
	}
	
	public void retypeEmailID(String input_emailconfirm) throws InterruptedException {
		WebElement retypeEmailID=driver.findElement(emailConfirmation);
        
        retypeEmailID.sendKeys(input_emailconfirm);
        
        Thread.sleep(1000);
       	
	}
	
	public void selectHowDidYouHearAboutUs() throws InterruptedException {
		
		WebElement source=driver.findElement(howDidYouHearAboutUs);
        source.click();
        
        Thread.sleep(2000);
        
        WebElement sourceOptionWebElement=driver.findElement(sourceOption);
        sourceOptionWebElement.click();
        
        Thread.sleep(1000);
		
	}
	
	public void clickOnContinueButton() throws InterruptedException {
		WebElement continueButtonWebElement=driver.findElement(continueButton);
		continueButtonWebElement.click();
		
		Thread.sleep(4000);
		
	}
	
	public void fillContactInformationForm(String firstName, String lastName, String phone, String emailID, String emailConfirm) throws InterruptedException {
		insertFirstName(firstName);
		insertLastName(lastName);
		insertPhoneNumber(phone);
		insertEmailID(emailID);
		retypeEmailID(emailConfirm);
		//selectHowDidYouHearAboutUs();
		clickOnContinueButton();
		
		ConfirmationPage confirmationPageObject=new ConfirmationPage(driver);
		
		confirmationPageObject.verifyConfirmationPage();
	}
	
}
