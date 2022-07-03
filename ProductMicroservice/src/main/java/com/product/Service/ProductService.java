package com.product.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.DAO_Hibernate_HQL.HibernateProductDAO;
import com.product.DAO_Hibernate_HQL.HibernateProductDAOImpl;
import com.product.DTO.ProductDTO;
import com.product.Entity.Product;
import com.product.KafkaProducer.ProductProducerKafkaTopic;
import com.product.ModelException.ProductExecption;
import com.product.ModelException.ProductIDnotFound;
import com.product.ModelException.ProductInternalError;
import com.product.ServiceEmail.EmailIml;
import com.product.Validation.ApiUserValidation;

@Service
public class ProductService implements ProductServiceInt {
	
	@Autowired
	private HibernateProductDAO hibernateProductDAO;
	
	@Autowired
	private ModelMapper modelMapper;
	
@Autowired
 private ApiUserValidation apiUserValidation;

@Autowired
private EmailIml emailIml;
	
	
	private ProductDTO convertProductDTOtoProduct(Product product) {

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProductDTO productdto = new ProductDTO();
		productdto = modelMapper.map(product, ProductDTO.class);
		return productdto;
		
	}	

	@Transactional
	@Override
	public List<ProductDTO> getProduct() {
	

			return hibernateProductDAO.getProduct()
					.stream()
	                .map(this::convertProductDTOtoProduct)
	                .collect(Collectors.toList());	

	}
	@Transactional
	@Override
	public ProductDTO getPoductInfo(@NonNull Integer purchase_item){
	return convertProductDTOtoProduct(hibernateProductDAO.getPoductInfo(apiUserValidation.ifIDexist(purchase_item)));
		

	}
	
	@Transactional
	@Override
	public ProductDTO delete(Integer purchase_item) {
		return convertProductDTOtoProduct(hibernateProductDAO.delete(apiUserValidation.ifIDexist(purchase_item)));
		 
	}
	
	@Transactional
	@Override
	public ProductDTO save( Product product) {

		ProductDTO productDTO =  convertProductDTOtoProduct((hibernateProductDAO.save(apiUserValidation.ProductnotNull(product))));		 
//		emailIml.transerToReceiver(productDTO.getProductemail().toString());
//		emailIml.transerTobody(productDTO.toString());
		return productDTO;
	}

	@Transactional
   @Override
	public Object updateProduct(ProductDTO newProduct) {
			
		Product currentProduct = this.hibernateProductDAO.getPoductInfo( apiUserValidation.ifIDexist(newProduct.getPurchase_item())); 
	
			currentProduct.setProductname(newProduct.getProductname());
			currentProduct.setProductbrand(newProduct.getProductbrand());
			currentProduct.setProductprice(newProduct.getProductprice());
			currentProduct.setProductdescription(newProduct.getProductdescription());
			currentProduct.setProductquantity(newProduct.getProductquantity()); 
			currentProduct.setProductexpirationdate(newProduct.getProductexpirationdate());
			
			apiUserValidation.ProductnotNull(currentProduct);
			 
		  return hibernateProductDAO.updateProduct(currentProduct);
	}
	





     

}
