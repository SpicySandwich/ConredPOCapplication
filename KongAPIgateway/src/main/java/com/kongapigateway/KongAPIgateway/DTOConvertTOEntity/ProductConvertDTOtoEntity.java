package com.kongapigateway.KongAPIgateway.DTOConvertTOEntity;

import java.util.List;
import java.util.stream.Collectors;


import com.kongapigateway.KongAPIgateway.DTOModel.ProductDTO;
import com.kongapigateway.KongAPIgateway.Model.Product;
import com.kongapigateway.KongAPIgateway.Validation.ApiUserValidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductConvertDTOtoEntity {
	
	@Autowired
	private ApiUserValidation validation;
	
private ProductDTO convertProductToDTOFindbyId(Product product) {
		
	ProductDTO  productDTO = new ProductDTO(
			product.getPurchase_item(),
			product.getProductname(),
			product.getProductbrand(),
			product.getProductprice(),
			product.getProductdescription(),
			product.getProductquantity(),
			product.getProductexpirationdate(),
			product.getProductemail()
				);
		
		
		return productDTO;
	}
private ProductDTO convertProductToDTOupdate(Product product) {
	
	ProductDTO productDTO = new ProductDTO(
			product.getPurchase_item(),
			product.getProductname(),
			product.getProductbrand(),
			product.getProductprice(),
			product.getProductdescription(),
			product.getProductquantity(),
			product.getProductexpirationdate(),
			product.getProductemail()
			);
	
	validation.ProductnotNull(productDTO);

	
	return productDTO;
}
	
	private ProductDTO convertProductToDTO(Product product) {
		
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setProductname(product.getProductname());
		productDTO.setProductbrand(product.getProductbrand());
		productDTO.setProductprice(product.getProductprice());
		productDTO.setProductdescription(product.getProductdescription());
		productDTO.setProductquantity(product.getProductquantity());
		productDTO.setProductexpirationdate(product.getProductexpirationdate());
		productDTO.setProductemail(product.getProductemail());
		
		validation.ProductnotNull(productDTO);
		
		
		return productDTO;
	}
	
private ProductDTO convertProductToDTODelete(Product product) {
		
	ProductDTO productDTO = new ProductDTO();
	productDTO.setPurchase_item(product.getPurchase_item());
		
		
		return productDTO;
	}
public ProductDTO deleteDTObody(Product product) {
	
	return convertProductToDTODelete(product);
}

	
	public ProductDTO insertDTObody(Product product) {
		
		return convertProductToDTO(product);
	}
	
public ProductDTO findbyidDTObody(Product product) {
		
		return convertProductToDTOFindbyId(product);
	}
public ProductDTO updateDTObody(Product product) {
	
	return convertProductToDTOupdate(product);
}

public List<ProductDTO>  ListDTObodyProduct(List<Product> product) {
	
	
	List<ProductDTO>productDTO  =product.stream()
	        .map(products -> new ProductDTO(
	        		products .getPurchase_item(),
	        		products .getProductname(),
	        		products .getProductbrand(),
	        		products .getProductprice(),
	        		products .getProductdescription(),
	        		products .getProductquantity(),
	        		products .getProductexpirationdate(),
	        		products.getProductemail()
	        		
	        		))
	        .collect(Collectors.toList());
	
 
return productDTO;
 

}

}
