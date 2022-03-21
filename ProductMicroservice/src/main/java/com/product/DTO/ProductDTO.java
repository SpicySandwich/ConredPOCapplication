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
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	 private Long productid;
      private String productname;
      private String productbrand;
      private Double productprice;
      private String productdescription;
      private Integer productquantity;
      private Date productcurrentdate;
      private Date productexpirationdate;
      


}
