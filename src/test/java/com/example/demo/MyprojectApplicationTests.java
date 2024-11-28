package com.example.demo;

import java.sql.Date;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepositoryJdbc;

import java.sql.Date;

@SpringBootTest
class MyprojectApplicationTests {
	
	@Autowired
	private UserMapper usermapper;
	
	@Test
	void contextLoads() {

	}

}
