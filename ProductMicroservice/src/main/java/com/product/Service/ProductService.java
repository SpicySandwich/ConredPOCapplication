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

	@Transactional
	@Override
	public Product getPoductInfo(long productid) {
		
		try {
		return productDAO.getPoductInfo(productid);
		
		}catch (Exception e) {
		
			throw new ProductExecption("Product not found by id of = " + productid );
		}
	
	}

	@Transactional
	@Override
	public void save(Product product) {

		if(product != null) {
			
			throw new ProductExecption("Please fill up all the field ");
			
		}else {
			
			productDAO.save(product);
		}
	
	}

	@Transactional
	@Override
	public void delete(long productid) {
	try {
		productDAO.delete(productid);
	}catch (Exception e) {
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
		    return productDAO.updateProduct(currentProduct);
		}catch (Exception e) {
			
				throw new ProductExecption("Id your trying to update is invalid");
			}
	}	


     

}
