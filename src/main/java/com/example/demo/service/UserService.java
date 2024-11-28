package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.UserDto;


public interface UserService {

	//找尋所有使用者
	public List<UserDto> findAllUser();
	
	//找單筆使用者根據ID
	public UserDto findUserById(Integer userId);
	
	//根據帳號找使用者
	public UserDto findUserByUserAccountNumber(String accountNumber);
	
	//新增使用者
	public void addUser(UserDto userDto);
	
	//更改密碼
	public void updateUserPassword(Integer userId, String userPassword, String userNewPassword);
	
	//修改使用者資料
	public void updateUser(Integer userId, String userPhone, String userEmail);
	
	//刪除使用者
	public void deleteUser(Integer userId);
	
}
