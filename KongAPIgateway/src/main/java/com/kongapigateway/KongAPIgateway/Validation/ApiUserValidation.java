package com.kongapigateway.KongAPIgateway.Validation;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import com.kongapigateway.KongAPIgateway.Model.Cart;
import com.kongapigateway.KongAPIgateway.Model.Product;
import com.kongapigateway.KongAPIgateway.ModelException.ProductExecption;
import com.kongapigateway.KongAPIgateway.ModelException.ProductValueNotNull;

import org.springframework.stereotype.Service;

@Service
public class ApiUserValidation {


	public Cart notNull(Cart cart) {
		

		
		if (cart.getProductname().trim().isEmpty()
			|| cart.getProductbrand().trim().isEmpty()
			|| isNullOrZeroDouble(cart.getProductprice() )
			|| cart.getProductdescription().trim().isEmpty()
			|| isNullOrZeroInterger( cart.getProductquantity() )
			
				) {
			
			throw new ProductValueNotNull("Please input all field");
			
		}
		
		return cart;
		
	}
	
	public boolean isNullOrZeroDouble(Double i){
	     return i == null || i.doubleValue() == 0;
	}
	
	public boolean isNullOrZeroInterger(Integer i){
	     return i == null || i.intValue() == 0;
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
		
		    if(date.equals(checkdate)  == true) throw new ProductExecption("Date must not current date or previous date: " + date);
		    if(date.before(checkdate)  == true) throw new ProductExecption("Date must not current date or previous date: " + date);
		 
		 return date;
	      
	}
	
	
	public Date checkdateifNull(Date date) {
		
		  if (date == null) throw new ProductValueNotNull("Date cannot be empty");
		  
		return date ;
		
	}
	

	
	   public boolean deletIDexceptionBol(Integer integer) {
		   Cart cart = new Cart();
	       boolean valid = false;
	       if (
	    		   cart.getPurchase_item()== null ||
	    		   cart.getPurchase_item().intValue() == 0 )  
	    	   throw new ProductValueNotNull("ID: " +cart.getPurchase_item() + " not found");
	       
		return valid;
	  
	   }
	
   public Integer deletIDexception(Integer integer) {
	   Cart cart = new Cart();
	  integer = cart.getPurchase_item();
	  findIDError(integer) ;
       
	return integer;
  
   }
	public Integer findIDError(Integer i){

	      if(i == null || i.intValue() == 0) throw new ProductValueNotNull("ID: " + i + " not found");
	      
	      return i;
	}
	
	

}
