package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.UserDto;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


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
	public String addUsers(Model model,HttpServletRequest request, @ModelAttribute UserDto userDto, @RequestParam Integer randomPassword) {
		HttpSession session = request.getSession();
		Integer userRandomPassword = (Integer)session.getAttribute("randomPassword");
		System.out.println(userRandomPassword);
		System.out.println(randomPassword);
		if(!userRandomPassword.equals(randomPassword)) {
			model.addAttribute("message", "驗證碼錯誤");
			return "error";
		}
//		System.out.println(userDto);
		userService.addUser(userDto);
		return "redirect:/product";
	}

}
