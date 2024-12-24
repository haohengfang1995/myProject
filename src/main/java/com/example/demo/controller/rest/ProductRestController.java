package com.example.demo.controller.rest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.dto.UserCert;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/xxx")
@CrossOrigin(origins = {"http://localhost:5173"}, allowCredentials = "true")
public class ProductRestController {

	private static final String BASE_DIR = "src/main/webapp/uploads/";
	
	// 初始化目錄
    static {
        try {
            Files.createDirectories(Paths.get(BASE_DIR));
        } catch (IOException e) {
            throw new RuntimeException("初始化目錄失敗：" + e.getMessage());
        }
    }
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<ProductDto>>> getAllproduct(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//判斷有沒有登入會員，沒有的話給全部商品資料
		if(session.getAttribute("userCert") == null) {
			List<ProductDto> productDtos = productService.findAllProduct();
			String message = productDtos.isEmpty()? "找不到商品資訊": "找尋成功";
			return ResponseEntity.ok(ApiResponse.success(message, productDtos));
		}else {
			//有的話給除了自己的商品資料
			UserCert userCert = (UserCert)session.getAttribute("userCert");
			Integer userId = userCert.getUserId();
			List<ProductDto> productDtos = productService.findNotUsProduct(userId);
			String message = productDtos.isEmpty()? "找不到商品資訊": "找尋成功";
			return ResponseEntity.ok(ApiResponse.success(message, productDtos));
		}
	}
	
	
	
    
}
