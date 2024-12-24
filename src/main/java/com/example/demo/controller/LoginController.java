package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.exception.CertException;
import com.example.demo.model.dto.UserCert;
import com.example.demo.repository.UserRepositoryJdbc;
import com.example.demo.service.CertService;
import com.example.demo.service.Impl.UserServiceImpl;
import com.example.demo.utils.Hash;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//會員登入控制
@Controller
@RequestMapping(value = {"/login"})
public class LoginController {
	
	@Autowired
	private UserServiceImpl userServieImpl;
	
	@Autowired
	private UserRepositoryJdbc userRepositoryJdbc;
	
//	@Autowired
//	private HttpSession session;
	@Autowired
	private CertService certService;
	Hash hash = new Hash();
	
	//導到登入頁面
	@GetMapping
	//@ResponseBody
	public String login() {
		return "login";
	}
	

	//也可以選擇HttpSession session 或 	HttpServletRequest request
	@PostMapping("/userlogin")
//	@ResponseBody
	public String creatCert(Model model,HttpServletRequest request,@RequestParam String userAccountNumber, String userPassword) {
		UserCert userCert = null;
//		Optional<User> optuser = userRepositoryJdbc.getUserByAccountNumber(userAccountNumber);
//		User user = optuser.get();
//		String a = user.getUserPassword();
//		String a = userServieImpl.findUserByUserAccountNumber(userAccountNumber).getUserPassword();
//		String b = Hash.getHash(userPassword);
//		return a + "--------------"+ b;
		//驗證帳號密碼並取得憑證
		try {
		userCert = certService.getCert(userAccountNumber, userPassword);
		}catch(CertException e) {
		model.addAttribute("message", e.getStackTrace());
		return "error";
		}
		//將憑證放入session 變數中 方便其他程式進行取用
		HttpSession session = request.getSession();
		session.setAttribute("userCert", userCert);//把憑證加入到session
		session.setAttribute("locale", request.getLocale());//取得用戶端地點資料
		model.addAttribute("message", "登入成功");
		
		//檢查session中的Url是否有資料，有的話跳轉到原本的頁面沒有的話轉到登錄成功
		if(session.getAttribute("redirectUrl") != null) {
			String url = session.getAttribute("redirectUrl").toString();
			System.out.println(url);
			session.setAttribute("redirectURL", null);//清空url資料‹
			return "redirect:" + url;
		}else {
			return "redirect:/product";
		}
	}
}
