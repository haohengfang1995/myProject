package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.entity.User;

public interface UserRepositoryJdbc {
	
	//找全部使用者
	List<User> findAll();
	
	//根據使用者Id找單筆資料
	Optional<User> getUserById(Integer userId);
	
	//根據帳號找尋使用者
	Optional<User> getUserByAccountNumber(String userAccountNumber);
	
	//新增使用者
	void saveUser(User user);
	
	//修改密碼
	void updatePassword(Integer userId, String userPassword, String userPasswordHash);
	
	//修改電話信箱
	void updateUser(Integer userId, String userPhone, String userEmail);
	
	//刪除使用者
	void deleteUser(Integer userId);
	
	
	
	
	
	
	
}
