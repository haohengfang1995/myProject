package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.UserRepositoryJdbc;
import com.example.demo.service.UserService;

@SpringBootTest
class UserServiceTests {
	
	@Autowired
	private UserService userService ;
	@Autowired
	private UserRepositoryJdbc userRepositoryJdbc;
	
	@Test
	void contextLoads() {

//		System.out.println(userService.findAllUser());
	}

}
