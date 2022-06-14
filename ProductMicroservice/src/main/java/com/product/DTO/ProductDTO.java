package com.product.DTO;

import java.io.Serializable;
import java.util.Date;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.product.JsonDeserializer.DateDeserializer;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	 
	 @JsonProperty("purchase_item")
	 private Integer purchase_item;
	 
	 @JsonProperty("productname")
     private String productname;
	 
	 @JsonProperty("productbrand")
     private String productbrand;
	 
	 @JsonProperty("productprice")
     private Double productprice;
	 
	 @JsonProperty("productdescription")
     private String productdescription;
	 
	 @JsonProperty("productquantity")
     private Integer productquantity;
   
     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
     @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, lenient = OptBoolean.FALSE)
    @JsonDeserialize(using = DateDeserializer.class)
     @JsonProperty("productexpirationdate")
     private Date productexpirationdate;
      


}
