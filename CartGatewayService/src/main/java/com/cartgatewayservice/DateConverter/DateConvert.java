package com.cartgatewayservice.DateConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cartgatewayservice.RestModelException.DATE_FORMAT_EXCEPTION;
import com.cartgatewayservice.RestModelException.EXISTING_EMAIL_EXCEPTION;

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
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
	

		com.google.type.Date datess = com.google.type.Date.newBuilder()
				.setYear(calendar.get(Calendar.YEAR))
				.setMonth(calendar.get(Calendar.MONTH) +1)
				.setDay(calendar.get(Calendar.DAY_OF_MONTH))
				.build();

        return datess ;
    }
	
	public  com.google.type.Date getDateFromDateProtoForUpdate(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		com.google.type.Date datess = com.google.type.Date.newBuilder()
				.setYear(calendar.get(Calendar.YEAR))
				.setMonth(calendar.get(Calendar.MONTH))
				.setDay(calendar.get(Calendar.DAY_OF_MONTH))
				.build();
		
		
        return datess ;
    }
	


	
	public void DateFormatValidation(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) +1;
		int days = calendar.get(Calendar.DAY_OF_MONTH);
		
		try {
			
		    LocalDate invLocDat = LocalDate.of(year,month,days);
	
		    System.out.println("Created LocalDate: " + invLocDat);
		} catch (DateTimeException dte) {
			  throw new EXISTING_EMAIL_EXCEPTION("There error in format");
		}
		
	}

	 

}
