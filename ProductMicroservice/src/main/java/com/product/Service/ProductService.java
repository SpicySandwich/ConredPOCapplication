package com.product.Service;

import java.util.List;
import java.util.Optional;
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
import com.product.Entity.ClientGuest;
import com.product.Entity.Product;
import com.product.KafkaProducer.ProductProducer;
import com.product.ModeException.ProductExecption;
import com.product.ModeException.ProductIDnotFound;
import com.product.ModeException.ProductInternalError;

@Service
public class ProductService implements ProductServiceInt {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ProductProducer productProducer;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProductDAOImpl productDaoimpl;
	
	
	private ProductDTO convertProductDTOtoProduct(Product product) {

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProductDTO productdto = new ProductDTO();
		productdto = modelMapper.map(product, ProductDTO.class);
		return productdto;
		
	}	

	@Transactional
	@Override
	public List<ProductDTO> getProduct() {
	
		try {
			return productDAO.getProduct()
					.stream()
	                .map(this::convertProductDTOtoProduct)
	                .collect(Collectors.toList());	
			
		} catch (Exception e) {
			
			productProducer.sendMessageException(new ProductInternalError("Internal error for list of data will send to kafka topic"));
			throw new ProductExecption("Product List not found " );
		
		}
	

	}
	@Transactional
	@Override
	public ProductDTO getPoductInfo(@NonNull Integer purchase_item){
		
try {
	productProducer.sendMessageDTO("Product viewed id:" +purchase_item);

	return convertProductDTOtoProduct(productDAO.getPoductInfo(purchase_item));
	
} catch (Exception  e) {
	productProducer.sendMessageException(new ProductInternalError("Internal error for viewing data will send to kafka topic"+purchase_item));
	throw new ProductIDnotFound("Product not found by id: " + purchase_item );
	
}
			

	}
	
	@Transactional
	@Override
	public ProductDTO delete(Integer purchase_item) {
	try {
		 productProducer.sendMessageDTO("Deteted id:" +purchase_item);
		 
		return convertProductDTOtoProduct(productDAO.delete(purchase_item));
		 
	
	}catch (Exception e) {
		
		productProducer.sendMessageException(new ProductInternalError("Internal error for delete will send to kafka topic "+purchase_item));
		throw new ProductExecption("Product id your tring to delete is invalid for id: " + purchase_item );
	}
	}
	
	@Transactional
	@Override
	public ProductDTO save( Product product) {
	
	
		try {
				
			productDAO.save(product);
			 productProducer.sendMessageDTO("Added a product : " +product);
			 return convertProductDTOtoProduct(product);
	
			 
		} 	
		catch (Exception e) {
			
			productProducer.sendMessageException(new ProductInternalError("Internal error for adding product will send to kafka topic"+product));
		throw new ProductExecption("Please fill up all the field ");
			 
		}
		

	}



	
	@Transactional
   @Override
	public Object updateProduct(ProductDTO newProduct) {
		
		Product currentProduct = this.productDAO.getPoductInfo( newProduct.getPurchase_item()); 
		try {
			currentProduct.setProductname(newProduct.getProductname());
			currentProduct.setProductbrand(newProduct.getProductbrand());
			currentProduct.setProductprice(newProduct.getProductprice());
			currentProduct.setProductdescription(newProduct.getProductdescription());
			currentProduct.setProductquantity(newProduct.getProductquantity());  
			
			 productProducer.sendMessageDTO("Updated Product : "+ newProduct);
			 
		  
		    
		}catch (Exception e) {
			productProducer.sendMessageException(new ProductInternalError("Internal error for update will send to kafka topic"+currentProduct));
				throw new ProductExecption("Id your trying to update is invalid");
			}
		
		  return productDAO.updateProduct(currentProduct);
	}
	
	//test
	
	public ClientGuest getById2(Integer number) {
		
		Optional<ClientGuest> cOptional =  Optional.ofNullable(productDaoimpl.getPoductInfo2(number));
		
		return cOptional.get();
	}
	
	public ClientGuest create (ClientGuest clientGuest2) {
		
		ClientGuest clientGuest = new ClientGuest();
		clientGuest.setClient_guest_name(clientGuest2.getClient_guest_name());
		clientGuest.setClient_guest_email(clientGuest2.getClient_guest_email());
		clientGuest.setPurchase_item(clientGuest2.getPurchase_item());
		
		return productDaoimpl.saveClient(clientGuest);
		
		
	}




     

}
