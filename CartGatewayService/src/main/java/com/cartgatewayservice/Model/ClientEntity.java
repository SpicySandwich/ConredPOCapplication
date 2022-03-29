package com.cartgatewayservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {
	
	private Integer client_guest_id;
	private String client_guest_name;
	private String client_guest_email;

}
