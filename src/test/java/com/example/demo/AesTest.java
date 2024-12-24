package com.example.demo;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.utils.KeyUtil;

@SpringBootTest
public class AesTest {
	

	@Test
	void test() {
		String message = "生日快樂";
		System.out.println("加密前:" + message);
		try {
			SecretKey secretKey = KeyUtil.generateAESKey();
			System.out.println(KeyUtil.encryptWithAESKey(secretKey, message));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
