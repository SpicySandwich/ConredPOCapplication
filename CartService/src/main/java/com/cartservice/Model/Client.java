package com.cartservice.Model;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.grpcserver.GuestClientServer.ClientGuestRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_client")
public class Client {
	
	@Column(name="clientid", type = MySqlTypeConstant.BIGINT,isKey = true,isAutoIncrement = true)
	private Integer client_guest_id;
	
	private String client_guest_name;
	private String client_guest_email;
	
	public ClientGuestRequest toGuest() {
		
		return ClientGuestRequest.newBuilder()
				.setClientGuestId(getClient_guest_id())
				.setClientGuestName(getClient_guest_name())
				.setClientGuestEmail(getClient_guest_email())
				.build();
				
	}
	
	public ClientGuestRequest byID() {
		
		return ClientGuestRequest.newBuilder()
				.setClientGuestId(getClient_guest_id())
				.build();
				
	}
	
	public static Client fromClient(ClientGuestRequest clientGuestRequest) {
		
		Client client = new Client();
		
		client.setClient_guest_id(clientGuestRequest.getClientGuestId());
		client.setClient_guest_name(clientGuestRequest.getClientGuestName());
		client.setClient_guest_email(clientGuestRequest.getClientGuestEmail());
		
		return client;
		
	}
	

}
