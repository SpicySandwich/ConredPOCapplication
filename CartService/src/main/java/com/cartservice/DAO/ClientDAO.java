package com.cartservice.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.cartservice.Model.Client;
import com.cartservice.Model.ItemPurchase;

@Mapper
public interface ClientDAO {
	
	@Select("select * from tb_client")
    public  List <Client> findAll();
	
	@Insert("INSERT INTO tb_client(client_guest_id, client_guest_name, client_guest_email,purchase_item) " +
		      " VALUES (#{client_guest_id}, #{client_guest_name}, #{client_guest_email}, #{purchase_item}  )")
  @Options(useGeneratedKeys = true, keyColumn = "client_guest_id", keyProperty = "client_guest_id")
	public int insert(Client clientGuestRequest);
	
	@Delete("DELETE FROM tb_client WHERE client_guest_id = #{client_guest_id}")
	public Client deleteById(Integer client_guest_id);

	
	@Select("SELECT * FROM tb_client  WHERE client_guest_id = #{client_guest_id}")
	 public Client findById(Integer client_guest_id);
	 
	 @Select("SELECT productid as productid, productname, productbrand,productprice,productdescription,productquantity,productcurrentdate,productexpirationdate FROM tb_client  WHERE client_guest_id = #{client_guest_id}")
	 public ItemPurchase findById2(Integer client_guest_id);
	
	 @Update("Update tb_client set client_guest_name=#{client_guest_name}, " +
		        "client_guest_email=#{client_guest_email}, purchase_item=#{purchase_item}  where client_guest_id = #{client_guest_id} ")
		   void update(Client guestClient);

	 @Select("SELECT EXISTS(SELECT 1 FROM tb_client WHERE client_guest_email=#{client_guest_emaill})")
	 boolean checkEmailExists(String client_guest_email);

}
