package com.kongapigateway.KongAPIgateway.Model;

import java.util.Date;



import lombok.Data;



@Data
public class Product {
	

	      private Integer purchase_item;
	      private String productname;
	      private String productbrand;
	     private Double productprice;
	      private String productdescription;
	      private Integer productquantity;
	      private Date productexpirationdate;

}
