package com.cartgatewayservice.DateConverter;

import java.util.Calendar;
import java.util.Date;

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
	


	 

}
