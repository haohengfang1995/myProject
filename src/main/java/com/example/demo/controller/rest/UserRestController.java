package com.example.demo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity.User;
import com.example.demo.repository.impl.UserRepositoryJdbcImpl;
import com.example.demo.response.ApiResponse;


@RestController
@RequestMapping("/loco")
@CrossOrigin(origins = {"http://localhost:9091"}, allowCredentials = "true")
public class UserRestController {

	@Autowired
	private UserRepositoryJdbcImpl userRepositoryJdbcImpl;
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<User>>> getMethodName() {
		List<User> users = userRepositoryJdbcImpl.findAll();
		String message = users.isEmpty()? "找不到資料": "找尋成功";
		return ResponseEntity.ok(ApiResponse.success(message, users));
	}
	
//	@DeleteMapping
//	public ResponseEntity<ApiResponse<Integer>> deleteUser(@PathVariable Integer userId){
//		
//	}

}
