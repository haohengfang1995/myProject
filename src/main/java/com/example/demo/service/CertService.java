package com.example.demo.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PasswordInvailException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.dto.UserCert;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepositoryJdbc;
import com.example.demo.utils.Hash;

//憑證服務
@Service
public class CertService {
	@Autowired
	private UserRepositoryJdbc userRepositoryJdbc;
	
	//登入後可以取得憑證
	public  UserCert getCert(String userAccountName, String userPassword) {
		//是否有這個會員
		Optional<User> optuser = userRepositoryJdbc.getUserByAccountNumber(userAccountName);
		User user = optuser.get();
		if(user == null) {
			throw new UserNotFoundException();
		}
		
		//密碼是否正確
		String passwordHash = Hash.getHash(userPassword); 
		
		//要用equals 不能用 !=  因為在記憶體是比較儲存位置
		if(!passwordHash.equals(user.getUserPassword())) {
			throw new PasswordInvailException();
		}
		UserCert userCert = new UserCert(user.getUserId(), user.getUserAccountNumber(), user.getUserName(), user.getUserRole());
		System.out.println(userCert);
		return userCert;
	}
}
