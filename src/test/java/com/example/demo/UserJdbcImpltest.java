package com.example.demo;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dto.RoomDto;
import com.example.demo.repository.UserRepositoryJdbc;
import com.example.demo.service.Impl.RoomServiceImpl;

@SpringBootTest
class UserJdbcImpltest {
	
	@Autowired
	private UserMapper usermapper;
	
	@Autowired
	private UserRepositoryJdbc userRepositoryJdbc;
	
	@Autowired
	private RoomServiceImpl roomServiceImpl;

	
	
	@Test
	void contextLoads() {
		LocalDate date = LocalDate.now();
		Date sqldate = Date.valueOf(date);
		
		RoomDto roomDto = roomServiceImpl.findRoomById(1);
		System.out.println("測試找一個" + userRepositoryJdbc.getUserByAccountNumber("abc"));
	}

}
