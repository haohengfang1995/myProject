package com.example.demo.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
//	@NotNull(message = "{userDto.userId.notNull}")
	private Integer userId;
	
//	@NotNull(message = "{userDto.userName.notNull}")
	private String userName;
	
//	@NotNull(message = "{userDto.userPhone.notNull}")
	private String userPhone;
	
//	@NotNull(message = "{userDto.userDate.notNull}")
	private Date userDate;
	
//	@NotNull(message = "{userDto.userAccountNumber.notNull}")
	private String userAccountNumber;
	
//	@NotNull(message = "{userDto.userPassword.notNull}")
	private String userPassword;
	
//	@NotNull(message = "{userDto.userEmail.notNull}")
	private String userEmail;
	

}
