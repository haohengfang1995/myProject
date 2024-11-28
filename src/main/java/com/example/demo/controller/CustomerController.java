package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepositoryJdbc;
import com.example.demo.service.UserService;


//控制所有使用者後台
@Controller
@RequestMapping(value = {"/customer","customers"})
public class CustomerController {
	
	@Autowired
	private UserRepositoryJdbc userRepositoryJdbc;
	
	
	@Autowired
	private UserService userService;
	
	//取得所有使用者
	@GetMapping
//	@ResponseBody
	public String getUsers(Model model, @ModelAttribute User user, UserDto userDto) {
		List<User> users = userRepositoryJdbc.findAll();
		model.addAttribute("users", users);
		return "control";
	}
	//刪除使用者
	@GetMapping("/delete/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {
		userRepositoryJdbc.deleteUser(userId);
		return "redirect:/customers";
	}
//	@PostMapping("/add")
//	public String addUsers(Model model,@ModelAttribute UserDto userDto) {
//		System.out.println(userDto);
//		userService.addUser(userDto);
//		return "redirect:/users";
//	}


}
