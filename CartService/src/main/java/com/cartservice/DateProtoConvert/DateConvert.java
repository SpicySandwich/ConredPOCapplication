package com.cartservice.DateProtoConvert;


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
		Integer month = date.getMonth() -1;
		Integer days = date.getDay();
		
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DATE, days);
		
		Date datesswe = inputValidation.DateFormatValidation(calendar.getTime());
		
		
	
        return datesswe ;
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
