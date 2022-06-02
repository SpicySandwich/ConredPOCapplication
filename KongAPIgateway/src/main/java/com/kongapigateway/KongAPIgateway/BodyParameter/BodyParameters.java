package com.kongapigateway.KongAPIgateway.BodyParameter;

import java.util.Calendar;
import java.util.Date;

import com.kongapigateway.KongAPIgateway.Model.Cart;
import com.kongapigateway.KongAPIgateway.Model.Product;
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
		validation.CartnotNull(cart);
		
		return cart;
		
	}
	
	public Cart FindbodyCart(Cart cart) {
		

		cart.getPurchase_item();
		cart.getProductname();
		cart.getProductbrand();
		cart.getProductprice();
		cart.getProductdescription();
		cart.getProductquantity();
		dateBody(cart.getProductexpirationdate());
validation.CartnotNull(cart);

return cart;

}
	
	public Product bodyProduct(Product product) {
		
		product.getProductname();
		product.getProductbrand();
		product.getProductprice();
		product.getProductdescription();
		product.getProductquantity();
		dateBody(product.getProductexpirationdate());
		validation.ProductnotNull(product);
	
		
		return product;
		
		
	}
	
	public Product FindbodyCart(Product product) {
		
		
		product.getProductname();
		product.getProductbrand();
		product.getProductprice();
		product.getProductdescription();
		product.getProductquantity();
		dateBody(product.getProductexpirationdate());
		validation.ProductnotNull(product);
		return product;
		
	
	}
	
	
	
	public Date dateBody(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE) -1);

		 Date datesswe = calendar.getTime();
	       
        return datesswe ;
		
		
	}
	
	


}
