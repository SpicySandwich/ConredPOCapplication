package com.kongapigateway.KongAPIgateway.BodyParameter;

import java.util.List;

import com.kongapigateway.KongAPIgateway.DTOConvertTOEntity.CartConvertDTOtoEntity;
import com.kongapigateway.KongAPIgateway.DTOConvertTOEntity.ProductConvertDTOtoEntity;
import com.kongapigateway.KongAPIgateway.DTOModel.CartDTO;
import com.kongapigateway.KongAPIgateway.DTOModel.ProductDTO;
import com.kongapigateway.KongAPIgateway.Model.Cart;
import com.kongapigateway.KongAPIgateway.Model.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodyParameters {
	
	@Autowired
	private CartConvertDTOtoEntity cartConvertDTOtoEntity;
	
	@Autowired
	private ProductConvertDTOtoEntity productConvertDTOtoEntity;
	

	
	
public CartDTO bodyCartDTOinsert(Cart cart) {
		
return cartConvertDTOtoEntity.convertCartToDTOInsert(cart);

}
	
	public CartDTO bodyCartDTOdelete(Cart cart) {
		
return cartConvertDTOtoEntity.convertCartToDTODelete(cart);

}
	
	public CartDTO bodyCartDTOfindbyid(Cart cart) {
		
return cartConvertDTOtoEntity.convertCartToDTOFindbyId(cart);

}
	
	public CartDTO bodyCartDTOupdate(Cart cart) {
		
		return cartConvertDTOtoEntity.convertCartToDTOupdate(cart);

		}
	
public List<CartDTO> bodyCartDTOList(List<Cart> cart) {
		
		return cartConvertDTOtoEntity.ListDTObody(cart);

		}
	


public ProductDTO bodyProductDTOinsert(Product product) {
	
return productConvertDTOtoEntity.insertDTObody(product);

}
	
	public ProductDTO bodyProductDTOdelete(Product product) {
		
return productConvertDTOtoEntity.deleteDTObody(product);

}
	
	public ProductDTO bodyProductDTOfindbyid(Product product) {
		
return productConvertDTOtoEntity.findbyidDTObody(product);

}
	
	public ProductDTO bodyProductDTOupdate(Product product) {
		
		return productConvertDTOtoEntity.updateDTObody(product);

		}
	
public List<ProductDTO> bodyProductDTOList(List<Product> product) {
		
		return productConvertDTOtoEntity.ListDTObodyProduct(product);

		}


	


}
