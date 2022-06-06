package com.kongapigateway.KongAPIgateway.Controller;

import java.util.List;

import com.kongapigateway.KongAPIgateway.DTOModel.ProductDTO;
import com.kongapigateway.KongAPIgateway.Model.Product;
import com.kongapigateway.KongAPIgateway.Service.ProductService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<ProductDTO> getData(){
        return productService.getInfo();
    }

    @PostMapping("/add")
    public ProductDTO postData(@RequestBody Product product){
    	ProductDTO productDTO =  productService.saveData(product);
         return productDTO;
    }


    @DeleteMapping("/delete/{purchase_item}")
    public String deleteData(@PathVariable Integer purchase_item, @RequestBody ProductDTO product ){
        productService.deleteData(purchase_item);
   	 return "Successfully deleted ID: " + purchase_item;
    }

    @GetMapping("/find/{purchase_item}")
    public ResponseEntity<ProductDTO> findProduct(@PathVariable Integer purchase_item) {
    	
    	return	productService.findbyid(purchase_item);
    }
    
    
    @PutMapping("/update")
    public ProductDTO  updateProduct(@RequestBody Product product){
    	ProductDTO productDTO =   productService.updateProductr(product);
		return productDTO;
    }
	


}
