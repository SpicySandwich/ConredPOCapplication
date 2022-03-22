package com.cartservice.Model;

import java.util.Date;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tb_guest_client")
public class GuestClient {
	
	
	@Column(name="clientid", type = MySqlTypeConstant.BIGINT,isKey = true,isAutoIncrement = true)
	private Long clientid;
	
	@Column(name="firstname", type =  MySqlTypeConstant.VARCHAR, length = 10)
	private String firstname;
	
	@Column(name="lastname",  type =  MySqlTypeConstant.VARCHAR, length = 10)
	private String lastname;
	
	@Column(name="email",  type =  MySqlTypeConstant.VARCHAR, length = 20)
	private String email;
	
	@Column(name="currentdate", type = MySqlTypeConstant.DATETIME)
	private Date currentdate;

}
