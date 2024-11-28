package com.example.demo.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 
 * 網址： //hash?password=1234
 * 得到: salt + hashpassword(password+salt)
 * 
 */


public class Hash {
	
	
	//產生雜湊
	public static String getHash(String password) {
		try{
			//加密演算法：SHA-256
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			//進行加密
			byte[] bytes = md.digest(password.getBytes());
			//將byte[] 透過Base64 編碼方便儲存
			return Base64.getEncoder().encodeToString(bytes);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	//產生鹽巴
	public static String getSalt() {
		SecureRandom secureRandom = new SecureRandom();
		byte [] salt = new byte[16];
		secureRandom.nextBytes(salt);
		return Base64.getEncoder().encodeToString(salt);
	}
	
	//產生含鹽雜湊
	public static String getPasswordHash(String password, String salt) {
		try{
			//加密演算法：SHA-256
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			//加鹽
			md.update(salt.getBytes());
			//進行加密
			byte[] bytes = md.digest(password.getBytes());
			//將byte[] 透過Base64 編碼方便儲存
			return Base64.getEncoder().encodeToString(bytes);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
