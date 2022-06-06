package com.kongapigateway.KongAPIgateway.Validation;

import com.kongapigateway.KongAPIgateway.DTOModel.CartDTO;
import com.kongapigateway.KongAPIgateway.DTOModel.ProductDTO;
import com.kongapigateway.KongAPIgateway.Model.Cart;
import com.kongapigateway.KongAPIgateway.Model.Product;
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


	


}
