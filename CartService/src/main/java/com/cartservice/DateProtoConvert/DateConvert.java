package com.cartservice.DateProtoConvert;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;


import org.springframework.stereotype.Service;

@Service
public class DateConvert {
	
	public Date getDateFromDateProto(com.google.type.Date date) {
		
LocalDate currentdate = LocalDate.now();
		
		int currentDay = currentdate.getDayOfMonth();
		int currentYear = currentdate.getYear();
		int currentMonth = currentdate.getMonthValue();
		
		Integer year = date.getYear();
		Integer month = date.getMonth();
		Integer days = date.getDay();
		
		
		
		Calendar calendar = Calendar.getInstance();
		//calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DATE, days);
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		
		LocalDate localDate = LocalDate.of(currentYear, currentMonth, currentDay);
		Date checkdate = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		
		Date datesswe = calendar.getTime();
	
		if(datesswe.before(checkdate)  == true) {

			throw new NumberFormatException();
		    }
		
        if (year == 0|| month == 0|| days == 0) {
				
			throw new NullPointerException();
		}

		
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
