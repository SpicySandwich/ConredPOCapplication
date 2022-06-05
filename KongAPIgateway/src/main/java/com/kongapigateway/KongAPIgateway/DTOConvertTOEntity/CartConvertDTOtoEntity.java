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
	
	
	
private CartDTO convertCartToDTOFindbyId(Cart cart) {
		
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
private CartDTO convertCartToDTOupdate(Cart cart) {
	
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
	
	private CartDTO convertCartToDTO(Cart cart) {
		
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
	
private CartDTO convertCartToDTODelete(Cart cart) {
		
		CartDTO cartDTO = new CartDTO();
		cartDTO.setPurchase_item(cart.getPurchase_item());
		
		
		return cartDTO;
	}
public CartDTO deleteDTObody(Cart cart) {
	
	return convertCartToDTODelete(cart);
}

	
	public CartDTO insertDTObody(Cart cart) {
		
		return convertCartToDTO(cart);
	}
	
public CartDTO findbyidDTObody(Cart cart) {
		
		return convertCartToDTOFindbyId(cart);
	}
public CartDTO updateDTObody(Cart cart) {
	
	return convertCartToDTOupdate(cart);
}

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
	

}
