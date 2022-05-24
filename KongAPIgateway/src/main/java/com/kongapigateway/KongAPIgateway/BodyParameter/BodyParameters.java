package com.kongapigateway.KongAPIgateway.BodyParameter;

import java.util.Calendar;
import java.util.Date;

import com.kongapigateway.KongAPIgateway.Model.Cart;

import com.kongapigateway.KongAPIgateway.Validation.ApiUserValidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodyParameters {
	
	@Autowired
	private ApiUserValidation validation;
	
	public Cart bodyCart(Cart cart) {
		

				cart.getProductname();
				cart.getProductbrand();
				cart.getProductprice();
				cart.getProductdescription();
				cart.getProductquantity();
				dateBody(cart.getProductexpirationdate());
		validation.notNull(cart);
		
		return cart;
		
	}
	
	public Date dateBody(Date date) {
		
		validation.dateChecker(date);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE));

		 Date datesswe = calendar.getTime();
	       
        return datesswe ;
		
		
	}
	
	


}
