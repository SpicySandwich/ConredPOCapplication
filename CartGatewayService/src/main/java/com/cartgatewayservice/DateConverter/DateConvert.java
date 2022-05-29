package com.cartgatewayservice.DateConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.cartgatewayservice.RestModelException.DATE_FORMAT_EXCEPTION;

import org.springframework.stereotype.Service;

@Service
public class DateConvert {
	

	public Date getDateFromDateProto(com.google.type.Date date) {
		Integer year = date.getYear();
		Integer month = date.getMonth();
		Integer days = date.getDay();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DATE, days);
		Date datess = calendar.getTime();
		
        return datess ;
    }
	
	public  com.google.type.Date getDateFromDateProtoInsert(Date date) {
		
		isValid(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) +1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		
		
	
		
	
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
	
	public Date getvalues(Date date) {
		
		String pattern = "yyyy-MM-dd";
		
		DateFormat df = new SimpleDateFormat(pattern);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.get(Calendar.YEAR);
		calendar.get(Calendar.MONTH);
		 calendar.get(Calendar.DAY_OF_MONTH);
	
		Date date2 = calendar.getTime();
		
		String stringdate = df.format(date2);
		
		DateFormat parser = new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			Date date3 = (Date) parser.parse(stringdate);
			return date3;
		} catch (ParseException e) {
			throw new DATE_FORMAT_EXCEPTION("There error in format");
		}

	}
	

	    public void isValid(Date datet) {
	    	
	  
			//Date datet = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
	    	SimpleDateFormat formatterr = new SimpleDateFormat("yyyy-MM-dd");
	    	//String format = formatter.format(datet);

	    		    
	    		    	
//	    		    	Date date = new Date();
//	    		    	
//	    		 LocalDate datex = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
	    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    	//	format = datex.format(formatter);
	    		
	    		String formatbb = formatterr.format( datet);
	    		
	    		 try{
	    		     LocalDate.parse(formatbb, formatter);

	    		    
	    		 }
	    		 catch(DateTimeParseException e){
	    			 throw new DATE_FORMAT_EXCEPTION("There error in format");
	    		 }
	    		 
	    	    }

	 

}
