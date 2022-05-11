package com.kongapigateway.KongAPIgateway.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Cart {
	
	private Integer purchase_item;
	private String productname;
    private String productbrand;
   private Double productprice;
    private String productdescription;
    private Integer productquantity;
    private String productexpirationdate;

}
