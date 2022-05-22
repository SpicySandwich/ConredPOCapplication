package com.cartgatewayservice.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GuestClient {
	
	private Integer client_guest_id;
	private String client_guest_name;
	private String client_guest_email;
	private ProductEntity productEntity;

	
}
