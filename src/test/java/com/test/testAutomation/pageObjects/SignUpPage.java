package com.test.testAutomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
	
	WebDriver driver;
	
	By unit=By.xpath("//*[@id=\"unit\"]");
	By continueButton=By.name("commit");
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	public void insertUnit(String input_unit) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(unit));
		WebElement unitWebElement=driver.findElement(unit);
		unitWebElement.click();
		unitWebElement.sendKeys(input_unit);
	    
	    Thread.sleep(1000);
		
	}
	
	public void clickOnContinue() throws InterruptedException {
		WebElement continueButtonWebElement=driver.findElement(continueButton);
		continueButtonWebElement.click();
	    
	    Thread.sleep(1000);
	}
	
	public void fillSignUpPage(String unit) throws InterruptedException {
		
		insertUnit(unit);//1202,1203,1204,1205,1206
		clickOnContinue();
		
	}
	

}
