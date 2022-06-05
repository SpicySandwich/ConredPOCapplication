package com.kongapigateway.KongAPIgateway.BodyParameter;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.kongapigateway.KongAPIgateway.DTOConvertTOEntity.CartConvertDTOtoEntity;
import com.kongapigateway.KongAPIgateway.DTOModel.CartDTO;
import com.kongapigateway.KongAPIgateway.Model.Cart;
import com.kongapigateway.KongAPIgateway.Model.Product;
import com.kongapigateway.KongAPIgateway.Validation.ApiUserValidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodyParameters {
	
	@Autowired
	private CartConvertDTOtoEntity cartConvertDTOtoEntity;
	
	@Autowired
	private ApiUserValidation validation;
	
	
public CartDTO bodyCartDTOinsert(Cart cart) {
		
return cartConvertDTOtoEntity.insertDTObody(cart);

}
	
	public CartDTO bodyCartDTOdelete(Cart cart) {
		
return cartConvertDTOtoEntity.deleteDTObody(cart);

}
	
	public CartDTO bodyCartDTOfindbyid(Cart cart) {
		
return cartConvertDTOtoEntity.findbyidDTObody(cart);

}
	
	public CartDTO bodyCartDTOupdate(Cart cart) {
		
		return cartConvertDTOtoEntity.updateDTObody(cart);

		}
	
public List<CartDTO> bodyCartDTOList(List<Cart> cart) {
		
		return cartConvertDTOtoEntity.ListDTObody(cart);

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
