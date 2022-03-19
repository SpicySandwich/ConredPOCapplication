package com.product.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.product.DAO.ProductDAO;
import com.product.DTO.ProductDTO;
import com.product.Entity.Product;
import com.product.KafkaProducer.ProductProducer;
import com.product.ModeException.ProductExecption;
import com.product.ModeException.ProductInternalError;

@Service
public class ProductService implements ProductServiceInt {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	ProductProducer productProducer;
	
	

	@Transactional
	@Override
	public List<Product> getProduct() {
	
		return productDAO.getProduct();

	}

	@Transactional
	@Override
	public Product getPoductInfo(@NonNull Long productid){
		
try {
	productProducer.sendMessageDTO("Product viewed id:" +productid);

	return productDAO.getPoductInfo(productid);
	
} catch (Exception  e) {
	productProducer.sendMessageException(new ProductInternalError("Internal error will send to kafka topic"+productid));
	throw new ProductExecption("Product not found by id: " + productid );
	
}
			
		
	
	}


	@Transactional
	@Override
	public void save( Product product) {
	
	
		try {
			
			productDAO.save(product);
			 productProducer.sendMessageDTO("Added a product : " +product);
			 
		} catch (Exception e) {
			
	//internal error to kafka
			productProducer.sendMessageException(new ProductInternalError("Internal error for adding product will send to kafka topic"+product));
	//exception handling
		throw new ProductExecption("Please fill up all the field ");
			 
		}

	}

	@Transactional
	@Override
	public void delete(Long productid) {
	try {
		productDAO.delete(productid);
		  productProducer.sendMessageDTO("Deteted id:" +productid);
	
	}catch (Exception e) {
		
		productProducer.sendMessageException(new ProductInternalError("Internal error for delete will send to kafka topic"+productid));
		throw new ProductExecption("Product id your tring to delete is invalid for id:" + productid );
	}
	}

	
	@Transactional
   @Override
	public Object updateProduct(ProductDTO newProduct) {
		
		Product currentProduct = this.productDAO.getPoductInfo( newProduct.getProductid()); 
		try {
			currentProduct.setProductname(newProduct.getProductname());
			currentProduct.setProductbrand(newProduct.getProductbrand());
			currentProduct.setProductprice(newProduct.getProductprice());
			currentProduct.setProductdescription(newProduct.getProductdescription());
			currentProduct.setProductquantity(newProduct.getProductquantity());  
			
			 productProducer.sendMessageDTO("Updated Product : "+ newProduct);
			 
		    return productDAO.updateProduct(currentProduct);
		    
		}catch (Exception e) {
			productProducer.sendMessageException(new ProductInternalError("Internal error for update will send to kafka topic"+currentProduct));
				throw new ProductExecption("Id your trying to update is invalid");
			}
	}	


     

}
