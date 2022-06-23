package com.kongapigateway.KongAPIgateway.DTOConvertTOEntity;

import java.util.List;
import java.util.stream.Collectors;

import com.kongapigateway.KongAPIgateway.DTOModel.CartDTO;
import com.kongapigateway.KongAPIgateway.Model.Cart;
import com.kongapigateway.KongAPIgateway.Validation.ApiUserValidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartConvertDTOtoEntity {
	
	@Autowired
	private ApiUserValidation validation;
	
	public List<CartDTO>  ListDTObody(List<Cart> cart) {
		
		
		List<CartDTO> cartDTO  =cart.stream()
		        .map(carts -> new CartDTO(
		        		carts.getPurchase_item(),
		        		carts.getProductname(),
		        		carts.getProductbrand(),
		        		carts.getProductprice(),
		        		carts.getProductdescription(),
		        		carts.getProductquantity(),
		        		carts.getProductexpirationdate()
		        		
		        		
		        		))
		        .collect(Collectors.toList());
		
	 
	return cartDTO;
	 

	}
	
	public CartDTO convertCartToDTOFindbyId(Cart cart) {
		
		CartDTO cartDTO = new CartDTO(
				cart.getPurchase_item(),
				cart.getProductname(),
				cart.getProductbrand(),
				cart.getProductprice(),
				cart.getProductdescription(),
				cart.getProductquantity(),
				cart.getProductexpirationdate()
				);
		
		
		return cartDTO;
	}
public CartDTO convertCartToDTOupdate(Cart cart) {
	
	CartDTO cartDTO = new CartDTO(
			cart.getPurchase_item(),
			cart.getProductname(),
			cart.getProductbrand(),
			cart.getProductprice(),
			cart.getProductdescription(),
			cart.getProductquantity(),
			cart.getProductexpirationdate()
			);
	
	validation.CartDTOnotNull(cartDTO);

	
	return cartDTO;
}
	
	public CartDTO convertCartToDTOInsert(Cart cart) {
		
		CartDTO cartDTO = new CartDTO();
		
		cartDTO.setProductname(cart.getProductname());
		cartDTO.setProductbrand(cart.getProductbrand());
		cartDTO.setProductprice(cart.getProductprice());
		cartDTO.setProductdescription(cart.getProductdescription());
		cartDTO.setProductquantity(cart.getProductquantity());
		cartDTO.setProductexpirationdate(cart.getProductexpirationdate());
		
		validation.CartDTOnotNull(cartDTO);
		
		
		return cartDTO;
	}
	
	public CartDTO convertCartToDTODelete(Cart cart) {
		
		CartDTO cartDTO = new CartDTO();
		cartDTO.setPurchase_item(cart.getPurchase_item());
		
		
		return cartDTO;
	}

	

}
