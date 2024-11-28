package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.mapper.UserMapper;

@SpringBootTest
class UsertoDtoTests {

		
	@Autowired
	private UserMapper userMapper;
	
	@Test
	void contextLoads() {
	}

}
