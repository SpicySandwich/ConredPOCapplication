package com.kongapigateway.KongAPIgateway.Model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

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
	      private Date productexpirationdate;

}
