package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//使用者憑證
//登入成功之後會得到的憑證資料(只有Getter)

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCert {
	private Integer userId;
	private String userAccountNumber;
	private String userName;
	private String role;
//	@Override
//	public String toString() {
//		return "UserCert [userId=" + userId + ", username=" + userAccountNumber + ", role=" + role + "]";
//	}
	
	
	
	
}
