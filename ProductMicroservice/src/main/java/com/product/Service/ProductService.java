package com.product.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.product.DTO.ProductDTO;
import com.product.Entity.Product;
import com.product.ModeException.ProductExecption;
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
	public Product updateProduct (ProductDTO newProduct) {
		
		Product currentProduct =productRepository.getById( newProduct.getProductid()); 
		try {
			currentProduct.setProductname(newProduct.getProductname());
			currentProduct.setProductbrand(newProduct.getProductbrand());
			currentProduct.setProductprice(newProduct.getProductprice());
			currentProduct.setProductdescription(newProduct.getProductdescription());
			currentProduct.setProductquantity(newProduct.getProductquantity());  
		    return productRepository.save(currentProduct);
			
		}catch (IllegalArgumentException e) {
			throw new ProductExecption("011"," The id your try to update is cannot be found, Kindly input existing Id" + e.getMessage());
		}catch (Exception e) {
			throw new ProductExecption("012","Error getting finding list in data" + e.getMessage());
		}
	    
	}
	
	
	@Override
	public ProductDTO getUserByUserId(Long productid) { 
		Product userObj = productRepository.findById(productid).orElse(null);
			
		  try {
			  return  productDTOconverter.convertToDto(userObj);
				
			}catch (IllegalArgumentException e) {
				throw new ProductExecption("003","The id you input is empty" + e.getMessage());
			}
			catch (java.util.NoSuchElementException e) {
				throw new ProductExecption("004","The id your try to delete is cannot be found, Kindly input existing Id" + e.getMessage());
			}catch (Exception e) {
				throw new ProductExecption("005","Error getting finding list in data" + e.getMessage());
			}
		  
		  
		  
	  }
	
	@Override
	public void deletedataByID(Long  productid) {

		try {
			 productRepository.deleteById(productid);
		}catch (IllegalArgumentException e) {
			throw new ProductExecption("001"," The id your try to delete is cannot be found, Kindly input existing Id" + e.getMessage());
		}catch (Exception e) {
			throw new ProductExecption("002","Error getting finding list in data" + e.getMessage());
		}
		
		
	}


     @Override
     public List<Product> showAll() {

	List<Product> productList = null;
	try {
		
		
		productList =  productRepository.findAll();
	}
	catch (Exception e) {
		throw new ProductExecption("106","Error getting finding list in data" + e.getMessage());
	}

	
	return productList;
	
	
	
}


	@Override
	public Product addProduct(Product product) {
		
		if(product.getProductname().isEmpty() || product.getProductname().length() == 0 ) {
			throw new ProductExecption("108","Please inputproduct name");
		}
	
		try {
	
			Product saveProduct = productRepository.save(product);
			return saveProduct;
			
		}catch (IllegalArgumentException e) {
			throw new ProductExecption("109","given product is null" + e.getMessage());
			
		}catch (Exception e) {
			
			throw new ProductExecption("110","Error getting finding list in data" + e.getMessage());
		}
	
	}
     

}
