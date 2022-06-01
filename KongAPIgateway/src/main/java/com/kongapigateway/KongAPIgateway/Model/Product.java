package com.kongapigateway.KongAPIgateway.Model;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kongapigateway.KongAPIgateway.DateDeserializer.DateDeserializer;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Product {
	
private Integer purchase_item;
	      private String productname;
	      private String productbrand;
	     private Double productprice;
	      private String productdescription;
	      private Integer productquantity;
	      
	      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	      @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, lenient = OptBoolean.FALSE)
	     @JsonDeserialize(using = DateDeserializer.class)
	      private Date productexpirationdate;

	      
	      

}
