package com.kongapigateway.KongAPIgateway.Validation;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import com.kongapigateway.KongAPIgateway.Model.Cart;
import com.kongapigateway.KongAPIgateway.ModelException.ProductExecption;
import com.kongapigateway.KongAPIgateway.ModelException.ProductValueNotNull;

import org.springframework.stereotype.Service;

@Service
public class ApiUserValidation {


	public Cart notNull(Cart cart) {
		
		if (
				cart.getPurchase_item() == 0
		    || cart.getProductname().trim().isEmpty()
			|| cart.getProductbrand().trim().isEmpty()
			|| cart.getProductprice() == 0
			|| cart.getProductdescription().trim().isEmpty()
			|| cart.getProductquantity() == 0
			
				) {
			
			throw new ProductValueNotNull("Please input all field");
			
		}
		
		return cart;
		
	}
	
	
	
public Date dateChecker(Date date) {
	
	checkdateifNull(date);  
	checkDateIfEqualOrPrevious(date);	
	
		return date;
		
	}
	
	public Date checkDateIfEqualOrPrevious(Date date) {
		
       LocalDate currentdate = LocalDate.now();
		
		int currentDay = currentdate.getDayOfMonth();
		int currentYear = currentdate.getYear();
		int currentMonth = currentdate.getMonthValue();
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		
		LocalDate localDate = LocalDate.of(currentYear, currentMonth, currentDay);
		Date checkdate = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		
		    date.getTime();
		
		 if(date.before(checkdate)  == true) throw new ProductExecption("Date must not current date or previous date: " + date);
		 
		 return date;
	      
	}
	
	
	public Date checkdateifNull(Date date) {
		
		  if (date == null) throw new ProductValueNotNull("Date cannot be empty");
		  
		return date ;
		
	}
	
	
	

}
