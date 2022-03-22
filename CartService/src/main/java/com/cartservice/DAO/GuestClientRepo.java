package com.cartservice.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.cartservice.Model.GuestClient;

@Mapper
public interface GuestClientRepo  {
	
	@Select("select * from tb_guest_client")
    public List <GuestClient > findAll();

    @Select("SELECT * FROM tb_guest_client WHERE clientid = #{clientid}")
    public GuestClient findById(Long id);

    @Delete("DELETE FROM tb_guest_client WHERE clientid = #{clientid}")
    public int deleteById(Long id);

    @Insert("INSERT INTO tb_guest_client(clientid, firstname, lastname,email,currentdate) " +
        " VALUES (#{clientid}, #{firstname}, #{lastname}, #{email}, #{currentdate} )")
    public int insert(GuestClient guestClient);

    @Update("Update tb_guest_client set firstname=#{firstname}, " +
        "lastname=#{lastname}, email=#{email}, currentdate=#{currentdate}  where clientid=#{clientid} ")
    public int update(GuestClient guestClient);
    
}
