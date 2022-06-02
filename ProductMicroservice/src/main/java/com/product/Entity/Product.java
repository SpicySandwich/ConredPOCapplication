package com.product.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.product.DateDeserializer.DateDeserializer;

import org.hibernate.annotations.DynamicUpdate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "tb_product")
@DynamicUpdate
public class Product  {

      
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
      @Column
      private Integer purchase_item;
     
      @NotBlank
      @NotNull
      @Column
      private String productname;
      
      @NotBlank
      @NotNull
      @Column
      private String productbrand;

      @NotNull
      @Column
      private Double productprice;
 
      @NotBlank
      @NotNull
      @Column
      private String productdescription;
      
      @NotNull
      @Column
      private Integer productquantity;
    
      
      @NotNull
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
      @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, lenient = OptBoolean.FALSE)
     @JsonDeserialize(using = DateDeserializer.class)
      private Date productexpirationdate;
      
      
      
  

}
