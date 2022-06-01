package com.cartservice.DateProtoConvert;

import java.time.LocalDate;
import java.time.ZoneId;
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
		
LocalDate currentdate = LocalDate.now();

LocalDate expiredDate =currentdate.plusMonths(2);
int expiredday = expiredDate.getDayOfMonth();
int expiredyear = expiredDate.getYear();
int expiredmonth= expiredDate.getMonthValue();

        Integer year = date.getYear();
		Integer month = date.getMonth() -1;
		Integer days = date.getDay();
		
		
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DATE, days);
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate localDate2 =LocalDate.of(expiredyear,expiredmonth,expiredday );
		Date checkdate2 = Date.from(localDate2 .atStartOfDay(defaultZoneId).toInstant());

		
		Date datesswe = calendar.getTime();
		

		if(    datesswe.equals(checkdate2)  || 
				datesswe.before(checkdate2)  || 
				year == 0|| month == 0|| days == 0) throw new NumberFormatException();
   
		
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
