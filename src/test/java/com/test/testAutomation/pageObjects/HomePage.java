package com.test.testAutomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
	
	WebDriver driver;
	By map=By.cssSelector("div.map-thumb.san_diego");
	By viewAvailabilityMap=By.cssSelector("button.button-cta-alt");
	By findAddresTextBox=By.cssSelector("input");
	By clickOnAddress=By.cssSelector("div.ready.building-status");
	By signUpButton=By.cssSelector("button.selected-address-action-button.ready");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void scrollDownToMapAndClick() throws InterruptedException {
		
		WebElement mapWebElement=driver.findElement(map);
		
		//This will scroll the page Vertically till the element is found		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView();", mapWebElement);
	    
	    WebElement viewAvailabilityMapWebElement = driver.findElement(viewAvailabilityMap);
	    
	    viewAvailabilityMapWebElement.click();
	    
	    Thread.sleep(5000); 
		
	}
	
	public void clickOnfindAddresTextBox(String address) throws InterruptedException {
		WebElement findAddresTextBoxWebElement=driver.findElement(findAddresTextBox);
		findAddresTextBoxWebElement.click();
		findAddresTextBoxWebElement.sendKeys(address);
	    
	    Thread.sleep(2000);
	}
	
	public void clickOnAddress() throws InterruptedException {
	    WebElement populatedAddress = driver.findElement(clickOnAddress);

	    populatedAddress.click();
	    
	    Thread.sleep(2000);
		}
	
	
	
	public void clickOnSignUpButton() throws InterruptedException {
	    WebElement signupButton = driver.findElement(signUpButton);

	    signupButton.click();
	    
	    Thread.sleep(5000);
		}
	
	public void clickOnMap(String address) throws InterruptedException {
		scrollDownToMapAndClick();
		clickOnfindAddresTextBox(address);
		clickOnAddress();
		clickOnSignUpButton();
		
	}
		
	
}
