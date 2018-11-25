package com.test.testAutomation.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.testAutomation.utils.Utilities;

public class AppointmentPage {
	
	WebDriver driver;
	
	Utilities utilities=new Utilities();
	By calenderVisibility=By.xpath("//div[@id='installation-appointment']/div");
	By nextMonthLocator=By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e");
	By allTimeSlots=By.xpath("//div[@id='appointment-times-list']/tr/div/input");
	By continueButton=By.cssSelector(".continue");
	
	public AppointmentPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void selectDateFromCalendar() throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(calenderVisibility));
		
		int todaysDate=utilities.returnTodaysDate();
		WebElement dateSelection = null;
		
		if((todaysDate+10)>30) {
			WebElement nextMonth=driver.findElement(nextMonthLocator);
			nextMonth.click();
			
			Thread.sleep(2000);
			dateSelection=driver.findElement(By.xpath("//a[contains(text(),1)]"));
		}
		else {
			dateSelection=driver.findElement(By.xpath("//a[contains(text(),"+(todaysDate+10)+")]"));
		}
		 
		dateSelection.click();
        
        Thread.sleep(5000);
		
	}
	
	
	public void selectTimeSlot() throws InterruptedException {
		
		List<WebElement> timeSlots = new ArrayList<WebElement>();
		   
        timeSlots=driver.findElements(allTimeSlots);
        
        /*
         * Alternate way to implement above logic
         * 
         * for(int i=1;i<=8;i++) {
        	   		timeSlots.add(driver.findElement(By.xpath("//div[@id='appointment-times-list']/tr["+i+"]/div/input")));
        	   }
         * 
         * */
        
        
        for(WebElement element: timeSlots) {
        		if(element.isEnabled()) {
        			element.click();
        			break;
        		}
        }
        Thread.sleep(2000);
		
	}
	
	public void clickOnContinueButton() throws InterruptedException {
		WebElement continueButtonWebElement=driver.findElement(continueButton);
		continueButtonWebElement.click();
		Thread.sleep(4000);
	}
	
	
	public void setAppointment() throws InterruptedException {
		selectDateFromCalendar();
		selectTimeSlot();
		clickOnContinueButton();
		
	}
	
	
}
