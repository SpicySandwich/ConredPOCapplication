package com.product.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.product.DTO.ProductDTO;
import com.product.Entity.Product;
import com.product.Repository.ProductRepository;
import com.product.Repository.ReviewRepo;

@Service
public class ProductService implements ProductServiceInt {
	
	@Autowired
	private  ProductRepository productRepository;
	

	
	@Autowired
	private ProductDTOconverter productDTOconverter;
	
 	
	@Transactional
	@Override
	public Product addProduct (ProductDTO newProduct) {
		
		Product currentProduct =productRepository.getById( newProduct.getProductid());
	
		currentProduct.setProductname(newProduct.getProductname());
		currentProduct.setProductbrand(newProduct.getProductbrand());
		currentProduct.setProductprice(newProduct.getProductprice());
		currentProduct.setProductdescription(newProduct.getProductdescription());
		currentProduct.setProductquantity(newProduct.getProductquantity());
//		currentProduct.setProductcurrentdate(newProduct.getProductcurrentdate());
//		currentProduct.setProductexpirationdate(newProduct.getProductexpirationdate());
	    
	    return productRepository.save(currentProduct);
	    
	}
	
	
	@Override
	public ProductDTO getUserByUserId(Long productid) { 
		Product userObj = productRepository.findById(productid).orElse(null);
		  return  productDTOconverter.convertToDto(userObj);
	  }
	
	@Override
	public void deletedataByID(Long  productid) {
		this. productRepository.deleteById(productid);
		
	}


     @Override
     public List<Product> showAll() {
	return productRepository.findAll();
	
}
     

}
