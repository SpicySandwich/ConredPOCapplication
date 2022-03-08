package com.product.DTO;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductDTO {
	
	  
	
//	@JsonIgnore
	@JsonProperty(value = "productid")  
	private Long productid;

	@NotNull
    @Size(min = 2, message = "Please enter product name")
	@JsonProperty(value = "productname")
      private String productname;
      
	@NotNull
    @Size(min = 2, message = "Please enter product brand")
	@JsonProperty(value = "productbrand")
      private String productbrand;

	@NotNull
	@JsonProperty(value = "productprice")
      private Double productprice;

	@NotNull
    @Size(min = 4, message = "Please enter product decription")
	@JsonProperty(value = "productdescription")
      private String productdescription;
      
	@NotNull
	@JsonProperty(value = "productquantity")
      private Integer productquantity;
      
	@NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "productcurrentdate")
      private Date productcurrentdate;
      
	@NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "productexpirationdate")
      private Date productexpirationdate;
	


}
