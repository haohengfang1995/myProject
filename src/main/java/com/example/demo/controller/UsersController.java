package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.UserCert;
import com.example.demo.model.dto.UserDto;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping(value = {"/user", "/users"})
public class UsersController {
	
	@Autowired
	private UserService userService;
	
	//使用者個人資訊
	@GetMapping
	public String getUser(Model model, HttpServletRequest request) {
		//從session拿到UserCert 然後取得該用戶資料
		HttpSession session = request.getSession();
		UserCert userCert = (UserCert)session.getAttribute("userCert");
		Integer userId = userCert.getUserId();
		UserDto userDto = userService.findUserById(userId);
//		System.out.println(userDto);
		model.addAttribute("userDto", userDto);
		return "userDetail";	
	}

	@GetMapping(value = {"/update"})
	public String updatePassword() {
		return "userUpdatePassword";
	}
	
	//修改使用者個人資訊
	@PostMapping
	public String userUpdate(Model model, @ModelAttribute UserDto userDto) {
		System.out.println(userDto);
		Integer userId = userDto.getUserId();
		System.out.println(userId);
		String userEmail = userDto.getUserEmail();
		System.out.println(userEmail);
		String userPhone = userDto.getUserPhone();
		System.out.println(userPhone);
		userService.updateUser(userId, userPhone, userEmail);
		return "forward:/";
	}
	
	//修改密碼
	@PostMapping(value = {"/update/password"})
	public String updatePassword(HttpServletRequest request,@RequestParam String userPassword, String newPassword) {
		HttpSession session = request.getSession();
		UserCert userCert = (UserCert)session.getAttribute("userCert");
		Integer userId = userCert.getUserId();
		userService.updateUserPassword(userId, userPassword, newPassword);
		return "forward:/";
		
	}
	
	
}
 