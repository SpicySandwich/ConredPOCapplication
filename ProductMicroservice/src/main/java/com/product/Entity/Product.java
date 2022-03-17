package com.product.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
      @GeneratedValue(strategy = GenerationType.AUTO)
      @Column(name = "productid")
      private Long productid;

      @NotNull
      @Column(nullable = false, length = 50)
      private String productname;
      
      @NotNull
      @Column(nullable = false, length = 50)
      private String productbrand;

      @NotNull
      @Column(nullable = false)
      private Double productprice;

      @NotNull
      @Column(nullable = false, length = 200)
      private String productdescription;
      
      @NotNull
      @Column(nullable = false)
      private Integer productquantity;
      
      @NotNull
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      @Column(nullable = false, updatable = false)
      private Date productcurrentdate;
      
      @NotNull
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      @Column(nullable = false, updatable = false)
      private Date productexpirationdate;
      
      
      
  

}
