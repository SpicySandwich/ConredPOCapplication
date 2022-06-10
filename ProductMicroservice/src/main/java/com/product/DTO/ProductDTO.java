package com.product.DTO;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	 
	private Integer purchase_item;
      private String productname;
      private String productbrand;
      private Double productprice;
      private String productdescription;
      private Integer productquantity;
      private Date productexpirationdate;
      


}
