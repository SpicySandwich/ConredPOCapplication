package com.product.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.product.DAO.ProductDAO;
import com.product.DAO.ProductDAOImpl;
import com.product.DTO.ProductDTO;
import com.product.Entity.Product;
import com.product.KafkaProducer.ProductProducer;
import com.product.ModeException.ProductExecption;
import com.product.ModeException.ProductIDnotFound;
import com.product.ModeException.ProductInternalError;
import com.product.Validation.ApiUserValidation;

@Service
public class ProductService implements ProductServiceInt {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ModelMapper modelMapper;
	
@Autowired
 private ApiUserValidation apiUserValidation;
	
	
	private ProductDTO convertProductDTOtoProduct(Product product) {

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProductDTO productdto = new ProductDTO();
		productdto = modelMapper.map(product, ProductDTO.class);
		return productdto;
		
	}	

	@Transactional
	@Override
	public List<ProductDTO> getProduct() {
	

			return productDAO.getProduct()
					.stream()
	                .map(this::convertProductDTOtoProduct)
	                .collect(Collectors.toList());	

	}
	@Transactional
	@Override
	public ProductDTO getPoductInfo(@NonNull Integer purchase_item){
	return convertProductDTOtoProduct(productDAO.getPoductInfo(apiUserValidation.ifIDexist(purchase_item)));
		

	}
	
	@Transactional
	@Override
	public ProductDTO delete(Integer purchase_item) {
		return convertProductDTOtoProduct(productDAO.delete(apiUserValidation.ifIDexist(purchase_item)));
		 
	}
	
	@Transactional
	@Override
	public ProductDTO save( Product product) {
			 return convertProductDTOtoProduct((productDAO.save(apiUserValidation.ProductnotNull(product))));		 

	}

	@Transactional
   @Override
	public Object updateProduct(ProductDTO newProduct) {
			
		Product currentProduct = this.productDAO.getPoductInfo( apiUserValidation.ifIDexist(newProduct.getPurchase_item())); 
	
			currentProduct.setProductname(newProduct.getProductname());
			currentProduct.setProductbrand(newProduct.getProductbrand());
			currentProduct.setProductprice(newProduct.getProductprice());
			currentProduct.setProductdescription(newProduct.getProductdescription());
			currentProduct.setProductquantity(newProduct.getProductquantity()); 
			currentProduct.setProductexpirationdate(newProduct.getProductexpirationdate());
			
			apiUserValidation.ProductnotNull(currentProduct);
			 
		  return productDAO.updateProduct(currentProduct);
	}
	





     

}
