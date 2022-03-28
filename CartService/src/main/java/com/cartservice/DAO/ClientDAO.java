package com.cartservice.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.cartservice.Model.Client;


@Mapper
public interface ClientDAO {
	
	@Select("select * from tb_client")
    public List <Client> findAll();
	
	@Insert("INSERT INTO tb_client(client_guest_id, client_guest_name, client_guest_email) " +
		      " VALUES (#{client_guest_id}, #{client_guest_name}, #{client_guest_email} )")
 //   @Options(useGeneratedKeys = true, keyColumn = "client_guest_id", keyProperty = "client_guest_id")
	public int insert(Client clientGuestRequest);


}
