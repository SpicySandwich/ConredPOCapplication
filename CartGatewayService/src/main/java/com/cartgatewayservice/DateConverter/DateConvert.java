package com.cartgatewayservice.DateConverter;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import com.cartgatewayservice.RestModelException.DATE_FORMAT_EXCEPTION;

import org.springframework.stereotype.Service;

@Service
public class DateConvert {
	

	public Date getDateFromDateProto(com.google.type.Date date) {
		Integer year = date.getYear();
		Integer month = date.getMonth();
		Integer days = date.getDay();
		
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DATE, days);
		Date datess = calendar.getTime();
		
        return datess ;
    }
	
	public  com.google.type.Date getDateFromDateProtoEntity(Date date) {
		
LocalDate currentdate = LocalDate.now();
		
		int currentDay = currentdate.getDayOfMonth();
		int currentYear = currentdate.getYear();
		int currentMonth = currentdate.getMonthValue();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		if(year < currentYear && month < currentMonth && day > currentDay) {
	    	
	    	throw new DATE_FORMAT_EXCEPTION("Wrong date format for " + year+ "-" + month + "-"+ day+". And date must not lower to current date "  + currentdate);
	    }
		com.google.type.Date datess = com.google.type.Date.newBuilder().setYear(year).setMonth(month).setDay(day).build();
		
  
		
        return datess ;
    }
	
	public  com.google.type.Date getDateFromDateProtoForUpdate(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		com.google.type.Date datess = com.google.type.Date.newBuilder().setYear(year).setMonth(month).setDay(day).build();
		
  
		
        return datess ;
    }

}
