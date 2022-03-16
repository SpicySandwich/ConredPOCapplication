package com.product.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.DAO.ProductDAO;
import com.product.DTO.ProductDTO;
import com.product.Entity.Product;
import com.product.ModeException.ProductExecption;

@Service
public class ProductService implements ProductServiceInt {
	
	@Autowired
	ProductDAO productDAO;
	

	@Transactional
	@Override
	public List<Product> getProduct() {
		
		return productDAO.getProduct();
	}

	@Override
	public Product get(long productid) {
	
		return null;
	}

	@Transactional
	@Override
	public void save(Product product) {
		
		productDAO.save(product);
		
	}

	@Override
	public void delete(int id) {
	
		
	}
	
	
	
	
//	@Autowired
//	private  ProductRepository productRepository;
//	
//	@Autowired
//	private ProductDTOconverter productDTOconverter;
//	
 	
//	@Transactional
//	@Override
//	public Product updateProduct (ProductDTO newProduct) {
//		
//		try {
//		Product currentProduct = this.productRepository.getById( newProduct.getProductid()); 
//		
//			currentProduct.setProductname(newProduct.getProductname());
//			currentProduct.setProductbrand(newProduct.getProductbrand());
//			currentProduct.setProductprice(newProduct.getProductprice());
//			currentProduct.setProductdescription(newProduct.getProductdescription());
//			currentProduct.setProductquantity(newProduct.getProductquantity());  
//		    return productRepository.save(currentProduct);
//		    
//		}catch (Exception e) {
//		
//			throw new ProductExecption("Cannot update Date format");
//		}
//			
//		}
//	
//	@Override
//	public Product getUserByUserId(Long productid) { 
//		return productRepository.findById(productid).orElseThrow(() -> new ProductExecption("Product not found by id of = " + productid ) );
//			
//		  
//	  }
//	
//	@Override
//	public void deletedataByID(Long  productid) {
//
//		try {
//			 productRepository.deleteById(productid);
//			
//		}catch (Exception e) {
//			throw new ProductExecption("Product id is empty or null" + productid );
//		}
//
//			
//		
//		
//	}
//
//
//     @Override
//     public List<Product> showAll() {
//
//	List<Product> productList = null;
//
//		
//		
//		return productList =  productRepository.findAll();
//
//	
//}
//
//
//	@Override
//	public Product addProduct(Product product) {
//		
//	try {
//			Product saveProduct = productRepository.save(product);
//			return saveProduct;
//			
//	}catch (Exception e) {
//		
//		throw new ProductExecption("Please fill up all the field ");
//	}
//	
//	}
     

}
