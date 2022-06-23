package com.product.Validation;


import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.product.DAO_Hibernate_HQL.HibernateProductDAO;
import com.product.Entity.Product;
import com.product.ModelException.DATE_FORMAT_EXCEPTION;
import com.product.ModelException.ProductIDnotFound;
import com.product.ModelException.ProductValueNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiUserValidation {
	
	@Autowired
	private HibernateProductDAO hibernateProductDAO;
	
	public Product ProductnotNull(Product productdto) {
		

		
		if ( productdto.getProductname().trim().isEmpty()
			|| productdto.getProductbrand().trim().isEmpty()
			|| isNullOrZeroDouble( productdto.getProductprice() )
			||  productdto.getProductdescription().trim().isEmpty()
			|| isNullOrZeroInterger(productdto.getProductquantity() )
				) {
			
			throw new ProductValueNotNull("Please input all field");
			
		}
		
		return  productdto;
		
	}
	
	public boolean isNullOrZeroDouble(Double i){
	     return i == null || i.doubleValue() == 0;
	}
	
	public boolean isNullOrZeroInterger(Integer i){
	     return i == null || i.intValue() == 0;
	}
	
	public Integer findIDError(Integer i){
		
		if (null == (Integer)i) 	throw new ProductValueNotNull("ID: " + i + " not found");
   
	      return i;
	}
	
public  Integer forDeleteError(Integer integer) {
	

	if(integer== null ||integer.intValue() == 0) throw new ProductValueNotNull("ID: " + integer + " not found");
	return integer;


}

public Integer ifIDexist(Integer purchase_item) {
	


	if(hibernateProductDAO.getPoductInfo(purchase_item) != null) {
		
		return purchase_item;
		
	}else {
		throw new ProductIDnotFound("ID: "+ purchase_item+ " not found or not existed");
	}
}



public void DateValidationError(String string) {
	 
    DateValidationError(string);
	
	}

public String DateNotNull(String date) {
	  
	    if (date.trim().isEmpty() || date == null) throw new ProductValueNotNull("Date cannot be empty");
	    
	    return date;
	    
	}


public String DateFormatValidation(String input) {
	String dString =  DateNotNull(input);
	 if (!dString.matches(
			 " ^((?:(?:1[6-9]|2[0-9])\\d{2})(-)(?:(?:(?:0[13578]|1[02])(-)31)|((0[1,3-9]|1[0-2])(-)(29|30))))$|^(?:(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(-)02(-)29)$|^(?:(?:1[6-9]|2[0-9])\\d{2})(-)(?:(?:0[1-9])|(?:1[0-2]))(-)(?:0[1-9]|1\\d|2[0-8])$")) 
  throw new DATE_FORMAT_EXCEPTION("Date format is invalid. Example format (yyyy-MM-dd) ");
	return checkDateIfEqualOrPrevious(dString);			 
	  
}

	public String  checkDateIfEqualOrPrevious(String stringdate) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate datep = LocalDate.parse(stringdate, formatter);
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		
		Date date = Date.from(datep.atStartOfDay(defaultZoneId).toInstant());

	       LocalDate currentdate = LocalDate.now();
	       
	       LocalDate expiredDate =currentdate.plusMonths(2);
	       int expiredday = expiredDate.getDayOfMonth();
	       int expiredyear = expiredDate.getYear();
	       int expiredmonth= expiredDate.getMonthValue();

			
			LocalDate localDate2 =LocalDate.of(expiredyear,expiredmonth,expiredday );
			Date checkdate = Date.from(localDate2 .atStartOfDay(defaultZoneId).toInstant());
			
			LocalDate localDate3 =LocalDate.of(expiredyear,expiredmonth,expiredday + 1 );

			    date.getTime();
			    
			    if(date.equals(checkdate) ||date.before(checkdate) ) throw new DATE_FORMAT_EXCEPTION("Expiration date must ahead or equal to " + localDate3 + ".");
				return stringdate;
			 

	}

		

}
