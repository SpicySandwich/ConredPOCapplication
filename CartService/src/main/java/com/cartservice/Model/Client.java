package com.cartservice.Model;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

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
	

}
