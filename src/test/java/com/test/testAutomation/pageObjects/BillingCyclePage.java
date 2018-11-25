package com.test.testAutomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingCyclePage {
	
	WebDriver driver;
	
	By monthlyBillingCycle=By.xpath("//form[@id='item-select-form']/div/input");
	By continueButton=By.xpath("//*[@id=\"signup-view\"]/div[3]/button[2]");
	
	public BillingCyclePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickOnMonthlyBillingCycle() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(monthlyBillingCycle));
        WebElement billingCycle=driver.findElement(monthlyBillingCycle);
        billingCycle.click();
	}
	
	public void clickOnContinueButton() throws InterruptedException {
		WebElement continueButtonWebElement=driver.findElement(continueButton);
		continueButtonWebElement.click();
		Thread.sleep(4000);
	}
	
	public void clickOnBillingCycle() throws InterruptedException {
		clickOnMonthlyBillingCycle();
		clickOnContinueButton();
		
	}
}
