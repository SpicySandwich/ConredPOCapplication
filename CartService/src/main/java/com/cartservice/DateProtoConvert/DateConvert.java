package com.cartservice.DateProtoConvert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import com.cartservice.Validation.InputValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateConvert {
	
	@Autowired
	private InputValidation inputValidation;
	

	
	public Date getDateFromDateProto(com.google.type.Date date) {

        Integer year = date.getYear();
		Integer month = date.getMonth();
		Integer days = date.getDay();
		
		String stringdate =String.valueOf(
				inputValidation.dateNotNull(year)
				+"-"+inputValidation.dateNotNull(month)
				+"-"+inputValidation.dateNotNull(days));
		
		Date date3 = inputValidation.DateFormatValidation(stringdate);
		
		 Calendar cal = Calendar.getInstance();
		  cal.setTime(date3);
        return cal.getTime();
    }
	
	public static com.google.type.Date getDateFromDateProtoEntity(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		com.google.type.Date datess = com.google.type.Date.newBuilder().setYear(year).setMonth(month).setDay(day).build();
		
        return datess ;
    }
	

	
	
	
	

}
