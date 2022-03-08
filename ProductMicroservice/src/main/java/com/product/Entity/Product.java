package com.product.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.kafka.annotation.EnableKafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "dbproduct")
@DynamicUpdate
public class Product  {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "productid")
      private Long productid;

      @NotNull
      @Size(min = 2, message = "Please enter product name")
      @Column(nullable = false, length = 50)
      private String productname;
      
      @NotNull
     @Size(min = 2, message = "Please enter product brand")
      @Column(nullable = false, length = 50)
      private String productbrand;

      @NotNull
      @Column(nullable = false)
      private Double productprice;

      @NotNull
     @Size(min = 4, message = "Please enter product decription")
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
