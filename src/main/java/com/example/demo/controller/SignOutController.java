package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping(value = {"/singout"})
public class SignOutController{
	
	@GetMapping
	public String getMethodName(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
//		session.invalidate();//所有session 失效 Id會重發
		session.setAttribute("userCert", null);
		model.addAttribute("message", "登出成功");
		return "result";
			
	}
	

}
