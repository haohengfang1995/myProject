package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.dto.UserDto;
import com.example.demo.service.UserService;


@Controller
@RequestMapping(value = {"/add"})
public class UserAddController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String add(Model model) {

		model.addAttribute("userDto", new UserDto());
		return "userAdd";
	}
	
	@PostMapping("/user")
	public String addUsers(Model model,@ModelAttribute UserDto userDto) {
		System.out.println(userDto);
		userService.addUser(userDto);
		return "redirect:/add";
	}

}
