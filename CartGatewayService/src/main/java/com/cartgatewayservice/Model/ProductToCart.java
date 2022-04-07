package com.cartgatewayservice.Model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductToCart {
	
    private Long productid;
    private String productname;
    private String productbrand;
    private Double productprice;
    private String productdescription;
    private Integer productquantity;
    private Date productcurrentdate;
    private Date productexpirationdate;
    

    

}
