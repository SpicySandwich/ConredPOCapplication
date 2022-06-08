package com.product.Validation;


import com.product.DAO.ProductDAO;
import com.product.Entity.Product;
import com.product.ModeException.ProductIDnotFound;
import com.product.ModeException.ProductValueNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiUserValidation {
	
	@Autowired
	private ProductDAO productDAO;
	
	public Product ProductnotNull(Product productdto) {
		

		
		if ( productdto.getProductname().trim().isEmpty()
			|| productdto.getProductbrand().trim().isEmpty()
			|| isNullOrZeroDouble( productdto.getProductprice() )
			||  productdto.getProductdescription().trim().isEmpty()
			|| isNullOrZeroInterger(productdto.getProductquantity() )
				) {
			
			throw new ProductValueNotNull("Please input all field");
			
		}
		
		return  productdto;
		
	}
	
	public boolean isNullOrZeroDouble(Double i){
	     return i == null || i.doubleValue() == 0;
	}
	
	public boolean isNullOrZeroInterger(Integer i){
	     return i == null || i.intValue() == 0;
	}
	
	public Integer findIDError(Integer i){
		
		if (null == (Integer)i) 	throw new ProductValueNotNull("ID: " + i + " not found");
   
	      return i;
	}
	
public  Integer forDeleteError(Integer integer) {
	

	if(integer== null ||integer.intValue() == 0) throw new ProductValueNotNull("ID: " + integer + " not found");
	return integer;


}

public Integer ifIDexist(Integer purchase_item) {
	


	if(productDAO.getPoductInfo(purchase_item) != null) {
		
		return purchase_item;
		
	}else {
		throw new ProductIDnotFound("ID: "+ purchase_item+ " not found or not existed");
	}
}

		

}
