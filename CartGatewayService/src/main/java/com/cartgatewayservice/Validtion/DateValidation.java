package com.cartgatewayservice.Validtion;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Date;

import com.cartgatewayservice.DateConverter.DateConvert;
import com.cartgatewayservice.RestModelException.DATE_FORMAT_EXCEPTION;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateValidation {
	
	@Autowired
	private DateConvert dateConvert;
	
	public  void validDate(Date date) {
	  
		LocalDate currentdate = LocalDate.now();
		
		int currentDay = currentdate.getDayOfMonth();
		int currentYear = currentdate.getYear();
		int currentMonth = currentdate.getMonthValue();

		
	    Integer month = 0;
	    Integer day = 0;
	    Integer year = 0;
	    
	    if(year < currentYear && month < currentMonth && day > currentDay) {
	    	
	    	throw new DATE_FORMAT_EXCEPTION("Wrong date format for " + year+ " - " + month + " - "+ day+".");
	    }
	    
	    	
	   
	 
	    

	  
	}

}
