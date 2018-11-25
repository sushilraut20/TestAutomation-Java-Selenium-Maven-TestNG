package com.test.testAutomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.test.testAutomation.utils.*;

public class ConfirmationPage {
	
	WebDriver driver;
	
	Utilities utilities=new Utilities();
	By confirmationMessageLocator=By.xpath("//div[@id='signup-view']/h4");
	By footerMessageLocator=By.cssSelector("div.modal-footer");
	
	String confirmationMessage="All Set! We Will See You At The Date And Time You Chose And A Confirmation Email Was Sent With Details Below.";
	String footerMessage="Looking for business sign up? Call our sales team at 1-800-WEBPASS x 2 or email us";
	
	public ConfirmationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void verifyConfirmationMessage() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessageLocator));
        
        WebElement finalMessage=driver.findElement(confirmationMessageLocator);
        
        Assert.assertEquals(finalMessage.getText().trim(), confirmationMessage);
        
	}
	
	public void verifyFooterMessage() throws InterruptedException {
		
		WebElement footer=driver.findElement(footerMessageLocator);
		
		Assert.assertEquals(footer.getText().trim(), footerMessage);
		
	}
	
	public void verifyConfirmationPage() throws InterruptedException {
		
		verifyConfirmationMessage();
		verifyFooterMessage();
	}
	
}
