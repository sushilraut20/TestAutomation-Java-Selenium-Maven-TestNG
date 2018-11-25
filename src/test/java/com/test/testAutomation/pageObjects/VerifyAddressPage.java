package com.test.testAutomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyAddressPage {
	
	WebDriver driver;
	By header=By.xpath("//div[@id='signup-view']/h4");
	By address=By.cssSelector("li.row");
	By continueButton=By.cssSelector(".continue");
	
	public VerifyAddressPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void checkHeaderandConfirmAddress() throws InterruptedException {
		WebElement selectaddress=driver.findElement(address);
		selectaddress.click();
    		
    		Thread.sleep(1000);	
		
	}
	
	public void clickOnContinueButton() throws InterruptedException {
		WebElement continueButtonWebElement=driver.findElement(continueButton);
		continueButtonWebElement.click();
		
		Thread.sleep(4000);
		
	}
	
	public void verifyAddressAndContinue() throws InterruptedException {
		
		WebElement headerWebElement=driver.findElement(header);
		String header_text=headerWebElement.getText().trim();
		
		if(header_text.contentEquals("Did You Mean One Of These Addresses?")) {
			checkHeaderandConfirmAddress();
			clickOnContinueButton();
			
		}
		
		
	}
	

}
