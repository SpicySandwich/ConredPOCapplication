package com.product.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column
      private Long productid;
     
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
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      @Column(columnDefinition = "timestamp default current_timestamp", insertable = false, updatable = false)
      private Date productcurrentdate;
      
      @NotNull
      @Future
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      @Column(updatable = false)
      private Date productexpirationdate;
      
      
      
  

}
