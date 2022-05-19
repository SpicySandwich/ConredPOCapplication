package com.kongapigateway.KongAPIgateway;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import com.kongapigateway.KongAPIgateway.ModelException.DATE_FORMAT_EXCEPTION;

import org.springframework.stereotype.Service;


@Service
public class DateValidation {
	
	
	public Date dateValidation(Date date) {
		
LocalDate currentdate = LocalDate.now();
		
		int currentDay = currentdate.getDayOfMonth();
		int currentYear = currentdate.getYear();
		int currentMonth = currentdate.getMonthValue();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		Calendar calendars = Calendar.getInstance();
		calendars.clear();
		calendars.set(Calendar.YEAR, year);
		calendars.set(Calendar.MONTH, month);
		calendars.set(Calendar.DATE, day);
		
		if(year < currentYear && month < currentMonth && day > currentDay) {
	    	
	    	throw new DATE_FORMAT_EXCEPTION("Wrong date format for " + year+ "-" + month + "-"+ day+". And date must not lower to current date "  + currentdate);
	    }

		Date dates = calendars.getTime();
        return  dates;
		
	}
	

}
