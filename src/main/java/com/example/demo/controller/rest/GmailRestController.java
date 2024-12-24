package com.example.demo.controller.rest;

import java.security.SecureRandom;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.ApiResponse;
import com.example.demo.service.GmailService;
import com.google.api.services.gmail.Gmail;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/mail")
public class GmailRestController {

	private static final Logger Logger = LoggerFactory.getLogger(GmailRestController.class);

	@PostMapping()
	public ResponseEntity<ApiResponse<String>> getMail(HttpServletRequest httpRequest,
			@RequestBody Map<String, String> request) {

		HttpSession session = httpRequest.getSession();

		SecureRandom secureRandom = new SecureRandom();

		// 生成範圍在 1000 到 9999 的四位數
		int min = 1000;
		int max = 9999;

		// 使用 nextInt 生成範圍內的隨機數
		Integer randomPassword = secureRandom.nextInt(max - min + 1) + min;
		session.setAttribute("randomPassword", randomPassword);

		String userEmail = request.get("userEmail");
		System.out.print(userEmail);
		try {
			Gmail service = GmailService.getGmailService();
			GmailService.sendMessage(service, "me", GmailService.createEmail(userEmail, "驗證碼", "驗證碼" + randomPassword));
			System.out.println("郵件已成功寄出！");
		} catch (Exception e) {
			Logger.info(e.toString());
			e.printStackTrace();
			System.out.println("郵件寄送失敗：" + e.getMessage());
		}
		return ResponseEntity.ok(ApiResponse.success("傳送成功", null));
	}

}
