package com.test.testAutomation.utils;

import java.util.Calendar;
import java.util.Random;

public class Utilities {
	
	public int returnTodaysDate() {
		Calendar cal = Calendar.getInstance();
		java.util.Date today =  cal.getTime();
		int todays_date=Integer.parseInt(today.toString().split(" ")[2]);
		return todays_date;
		
	}

	public String returnRandomString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
	}

}
