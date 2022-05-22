package com.cartservice.Model;


import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	
	private Integer client_guest_id;
	private String client_guest_name;
	private String client_guest_email;
    private ProductEntity productEntity;
    
    
    
    
    
	
	
//	public int toDeleteTest() {
//		
//		return ClientGuestRequest.newBuilder()
//				.getClientGuestId();
//	
//	}
//	
//	
//	public ClientGuestRequest toGuest() {
//		
//		return ClientGuestRequest.newBuilder()
//				.setClientGuestId(getClient_guest_id())
//				.setClientGuestName(getClient_guest_name())
//				.setClientGuestEmail(getClient_guest_email())
//
//				.build();
//				
//	}
//	
//	public ClientGuestRequest byID() {
//		
//		return ClientGuestRequest.newBuilder()
//				.setClientGuestId(getClient_guest_id())
//				.build();
//				
//	}
	
//	public static Client fromClient(ClientGuestRequest clientGuestRequest) {
//		
//		Client client = new Client();
//		
//		client.setClient_guest_id(clientGuestRequest.getClientGuestId());
//		client.setClient_guest_name(clientGuestRequest.getClientGuestName());
//		client.setClient_guest_email(clientGuestRequest.getClientGuestEmail());
//		List<Product> clients = clientGuestRequest.getPurchaseItemList().stream().map(Product::fromProduct).collect(Collectors.toList());
//       client.setPurchase_item(clients);
//		
//		return client;
//		
//	}
	
	

}
