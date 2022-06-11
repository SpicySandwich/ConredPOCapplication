package com.kongapigateway.KongAPIgateway.Validation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kongapigateway.KongAPIgateway.DTOModel.CartDTO;
import com.kongapigateway.KongAPIgateway.DTOModel.ProductDTO;
import com.kongapigateway.KongAPIgateway.Model.Cart;
import com.kongapigateway.KongAPIgateway.Model.Product;
import com.kongapigateway.KongAPIgateway.ModelException.DATE_FORMAT_ERROR;
import com.kongapigateway.KongAPIgateway.ModelException.ProductExecption;
import com.kongapigateway.KongAPIgateway.ModelException.ProductValueNotNull;

import org.springframework.stereotype.Service;

@Service
public class ApiUserValidation {
	
	public CartDTO CartDTOnotNull(CartDTO cartdto) {
		

		
		if (cartdto.getProductname().trim().isEmpty()
			|| cartdto.getProductbrand().trim().isEmpty()
			|| isNullOrZeroDouble(cartdto.getProductprice() )
			|| cartdto.getProductdescription().trim().isEmpty()
			|| isNullOrZeroInterger( cartdto.getProductquantity() )
			
				) {
			
			throw new ProductValueNotNull("Please input all field");
			
		}
		
		return cartdto;
		
	}

	public ProductDTO ProductnotNull(ProductDTO productdto) {
		

		
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
	

	   public boolean deletIDexceptionBol(Integer integer) {
		   Cart cart = new Cart();
	       boolean valid = false;
	       if (
	    		   cart.getPurchase_item()== null ||
	    		   cart.getPurchase_item().intValue() == 0 )  
	    	   throw new ProductValueNotNull("ID: " +cart.getPurchase_item() + " not found");
	       
		return valid;
	  
	   }
	   
	   public Integer deleteTrue(Integer integer) {
		   
		   if (integer != null) {
			
			   return integer;
		}else {
			return deletIDexception(integer);
		}
		   
	   }
	
   public Integer deletIDexception(Integer integer) {
	   Cart cart = new Cart();
	  integer = cart.getPurchase_item();
	  findIDError(integer) ;
       
	return integer;
  
   }
	public Integer findIDError(Integer i){
	
		if (null == (Integer)i) 	throw new ProductValueNotNull("ID: " + i + " not found");
   
	      return i;
	}
	
public  Integer forDeleteError(Integer integer) {
	

	if(integer== null ||integer.intValue() == 0) throw new ProductValueNotNull("ID: " + integer + " not found");
	return integer;


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
	  String DateFormatPattern = 
			  "([20]{2}[0-9]{2})"+
  		    		"([-]{1})" +
  		    		 "([0]{1}[1-9]{1}|[1]{1}[0-2]{1}|[1-9]{1})"+
  		    		"([-]{1})" +
  		    		"([1-9]{1}|[0]{1}[1-9]{1}|[1]{1}[0-9]{1}|[2]{1}[0-9]{1}|[3]{1}[0-1]{1})" ;
	  
	  Pattern pattern = Pattern.compile(DateFormatPattern);
	  Matcher matcher = pattern.matcher(dString);
	  
	  if (!matcher.matches())  throw new DATE_FORMAT_ERROR("Date format is invalid. Example format (yyyy-MM-dd) ");
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
			    
			    if(date.equals(checkdate) || date.before(checkdate)) throw new ProductExecption("Expiration date must ahead or equal to " + localDate3 + ".");
				return stringdate;
			 

	}




	


}
