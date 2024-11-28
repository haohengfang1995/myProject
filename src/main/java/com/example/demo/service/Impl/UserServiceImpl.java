package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PasswordInvailException;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepositoryJdbc;
import com.example.demo.service.UserService;
import com.example.demo.utils.Hash;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepositoryJdbc userRepositoryJdbc;
	

	
	@Autowired
	UserMapper userMapper;

	@Override
	public List<UserDto> findAllUser() {
		List<UserDto> userDtos = userRepositoryJdbc.findAll().stream()
								.map(userMapper :: toDto)
								.collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public UserDto findUserById(Integer userId) {
		Optional<User> optuser = userRepositoryJdbc.getUserById(userId);
		User user = optuser.get();
		return userMapper.toDto(user);
	}
	

	@Override
	public UserDto findUserByUserAccountNumber(String accountNumber) {
		Optional<User> optUser = userRepositoryJdbc.getUserByAccountNumber(accountNumber);
		User user = optUser.get();
		return userMapper.toDto(user);
	}

	@Override
	public void addUser(UserDto userDto) {
//		判斷使用者是否已存在
		Optional<User> optUser = userRepositoryJdbc.getUserByAccountNumber(userDto.getUserAccountNumber());
		if(optUser.isPresent()) {
			throw new UserAlreadyExistsException("新增失敗:" + userDto.getUserAccountNumber() + "帳號已存在");
		}
		
		
			
		String hash = Hash.getHash(userDto.getUserPassword());
		String salt = Hash.getSalt();
		String hashsalt = Hash.getPasswordHash(hash, salt);
//		UserDto userdto = new UserDto();
		User user = userMapper.toUser(userDto);
		user.setUserSalt(salt);
		user.setUserPassword(hash);
		user.setUserPasswordHash(hashsalt);
		userRepositoryJdbc.saveUser(user);
	}

	
	
	@Override
	public void updateUserPassword(Integer userId, String userPassword, String userNewPassword) {
		User user = userRepositoryJdbc.getUserById(userId).get();
		String passwordHash = Hash.getHash(userPassword);
		if(!passwordHash.equals(user.getUserPassword())) {
			throw new PasswordInvailException();
		}
		String salt = user.getUserSalt();
		String newPassword = Hash.getPasswordHash(userNewPassword, salt);
		String newPasswordHash = Hash.getPasswordHash(newPassword, salt);
		userRepositoryJdbc.updatePassword(userId, newPassword, newPasswordHash);
	}

	@Override
	public void updateUser(Integer userId,String userPhone, String userEmail) {
		userRepositoryJdbc.updateUser(userId, userPhone, userEmail);
	}

	@Override
	public void deleteUser(Integer userid) {
		userRepositoryJdbc.deleteUser(userid);	
	}

	
	
}
