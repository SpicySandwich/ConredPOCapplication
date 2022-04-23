package com.product.Entity;

import javax.persistence.*;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_client")
public class ClientGuest {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer client_guest_id;
	
    private String client_guest_name;
    
    private String client_guest_email;
    
    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="fk_clientguestproduct",referencedColumnName = "client_guest_id")
    private List<Product> purchase_item;

}
