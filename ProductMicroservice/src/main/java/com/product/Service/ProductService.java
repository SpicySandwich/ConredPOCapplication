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
		
		try {
		Product currentProduct = this.productRepository.getById( newProduct.getProductid()); 
		
			currentProduct.setProductname(newProduct.getProductname());
			currentProduct.setProductbrand(newProduct.getProductbrand());
			currentProduct.setProductprice(newProduct.getProductprice());
			currentProduct.setProductdescription(newProduct.getProductdescription());
			currentProduct.setProductquantity(newProduct.getProductquantity());  
		    return productRepository.save(currentProduct);
		    
		}catch (Exception e) {
		
			throw new ProductExecption("Product List is emptyl");
		}
			
		}
	
	@Override
	public Product getUserByUserId(Long productid) { 
		return productRepository.findById(productid).orElseThrow(() -> new ProductExecption("Product not found" + productid ) );
			
		  
	  }
	
	@Override
	public void deletedataByID(Long  productid) {

		try {
			 productRepository.deleteById(productid);
			
		}catch (Exception e) {
			throw new ProductExecption("Product id is empty or null" + productid );
		}

			
		
		
	}


     @Override
     public List<Product> showAll() {

	List<Product> productList = null;

		
		
		return productList =  productRepository.findAll();

	
}


	@Override
	public Product addProduct(Product product) {
		
	
			Product saveProduct = productRepository.save(product);
			return saveProduct;
			
	}
     

}
