package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.dto.UserCert;
import com.example.demo.model.dto.UserDto;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;






@Controller
@RequestMapping(value = {"/product"})
public class ProductController {
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
	
	//轉到首頁
	@GetMapping
	public String getAllproduct(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		//判斷有沒有登入會員，沒有的話給全部商品資料
		if(session.getAttribute("userCert") == null) {
			List<ProductDto> productDtos = productService.findAllProduct();
			model.addAttribute("productDtos", productDtos);
			return "product";
		}else {
			//有的話給除了自己的商品資料
			UserCert userCert = (UserCert)session.getAttribute("userCert");
			Integer userId = userCert.getUserId();
			List<ProductDto> productDtos = productService.findNotUsProduct(userId);
			model.addAttribute("productDtos", productDtos);
			System.out.println(productDtos);
			return "product";
		}
	}
	
	@GetMapping("/new")
	public String getProductNew(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		//判斷有沒有登入會員，沒有的話給全部商品資料
		if(session.getAttribute("userCert") == null) {
			List<ProductDto> productDtos = productService.findProductByNew();
			model.addAttribute("productDtos", productDtos);
			return "product";
		}else {
			//有的話給除了自己的商品資料
			UserCert userCert = (UserCert)session.getAttribute("userCert");
			Integer userId = userCert.getUserId();
			List<ProductDto> productDtos = productService.findProductByNewNoSelf(userId);
			model.addAttribute("productDtos", productDtos);
			System.out.println(productDtos);
			return "product";
		}
	}
	
	@GetMapping("/old")
	public String getProductOld(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		//判斷有沒有登入會員，沒有的話給全部商品資料
		if(session.getAttribute("userCert") == null) {
			List<ProductDto> productDtos = productService.findProductByOld();
			model.addAttribute("productDtos", productDtos);
			return "product";
		}else {
			//有的話給除了自己的商品資料
			UserCert userCert = (UserCert)session.getAttribute("userCert");
			Integer userId = userCert.getUserId();
			List<ProductDto> productDtos = productService.findProductByOldNoSelf(userId);
			model.addAttribute("productDtos", productDtos);
			System.out.println(productDtos);
			return "product";
		}
	}
	
	@GetMapping("/high")
	public String getProductHigh(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		//判斷有沒有登入會員，沒有的話給全部商品資料
		if(session.getAttribute("userCert") == null) {
			List<ProductDto> productDtos = productService.findProductByHigh();
			model.addAttribute("productDtos", productDtos);
			return "product";
		}else {
			//有的話給除了自己的商品資料
			UserCert userCert = (UserCert)session.getAttribute("userCert");
			Integer userId = userCert.getUserId();
			List<ProductDto> productDtos = productService.findProductByHighNoSelf(userId);
			model.addAttribute("productDtos", productDtos);
			System.out.println(productDtos);
			return "product";
		}
	}
	
	@GetMapping("/low")
	public String getProductLow(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		//判斷有沒有登入會員，沒有的話給全部商品資料
		if(session.getAttribute("userCert") == null) {
			List<ProductDto> productDtos = productService.findProductByLow();
			model.addAttribute("productDtos", productDtos);
			return "product";
		}else {
			//有的話給除了自己的商品資料
			UserCert userCert = (UserCert)session.getAttribute("userCert");
			Integer userId = userCert.getUserId();
			List<ProductDto> productDtos = productService.findProductByLowNoSelf(userId);
			model.addAttribute("productDtos", productDtos);
			System.out.println(productDtos);
			return "product";
		}
	}
	
	@GetMapping("/place/{productPlace}")
	public String getProductPlace(Model model, HttpServletRequest request, @PathVariable("productPlace") String productPlace) {
		HttpSession session = request.getSession();
		//判斷有沒有登入會員，沒有的話給全部商品資料
		if(session.getAttribute("userCert") == null) {
			List<ProductDto> productDtos = productService.findProductByPlace(productPlace);
			model.addAttribute("productDtos", productDtos);
			return "product";
		}else {
			//有的話給除了自己的商品資料
			UserCert userCert = (UserCert)session.getAttribute("userCert");
			Integer userId = userCert.getUserId();
			List<ProductDto> productDtos = productService.findProductByPlaceNoself(productPlace, userId);
			model.addAttribute("productDtos", productDtos);
			System.out.println(productDtos);
			return "product";
		}
	}
	
	@GetMapping("/idolname/{idolName}")
	public String getProductIdolName(Model model, HttpServletRequest request, @PathVariable("idolName") String idolName) {
		HttpSession session = request.getSession();
		//判斷有沒有登入會員，沒有的話給全部商品資料
		if(session.getAttribute("userCert") == null) {
			List<ProductDto> productDtos = productService.findProductbyIdolName(idolName);
			model.addAttribute("productDtos", productDtos);
			return "product";
		}else {
			//有的話給除了自己的商品資料
			UserCert userCert = (UserCert)session.getAttribute("userCert");
			Integer userId = userCert.getUserId();
			List<ProductDto> productDtos = productService.findProductbyIdolNameNoSelf(idolName, userId);
			model.addAttribute("productDtos", productDtos);
			System.out.println(productDtos);
			return "product";
		}
	}
	
	@GetMapping("/gender/{gender}")
	public String getProductGender(Model model, HttpServletRequest request, @PathVariable("gender") String gender) {
		HttpSession session = request.getSession();
		//判斷有沒有登入會員，沒有的話給全部商品資料
		if(session.getAttribute("userCert") == null) {
			List<ProductDto> productDtos = productService.findProductByGender(gender);
			model.addAttribute("productDtos", productDtos);
			return "product";
		}else {
			//有的話給除了自己的商品資料
			UserCert userCert = (UserCert)session.getAttribute("userCert");
			Integer userId = userCert.getUserId();
			List<ProductDto> productDtos = productService.findProductByGenderNoSelf(gender, userId);
			model.addAttribute("productDtos", productDtos);
			System.out.println(productDtos);
			return "product";
		}
	}
	
	@GetMapping("/type/{productType}")
	public String getProductType(Model model, HttpServletRequest request, @PathVariable("productType") String productType) {
		HttpSession session = request.getSession();
		//判斷有沒有登入會員，沒有的話給全部商品資料
		if(session.getAttribute("userCert") == null) {
			List<ProductDto> productDtos = productService.findProductByType(productType);
			model.addAttribute("productDtos", productDtos);
			return "product";
		}else {
			//有的話給除了自己的商品資料
			UserCert userCert = (UserCert)session.getAttribute("userCert");
			Integer userId = userCert.getUserId();
			List<ProductDto> productDtos = productService.findProductByTypeNoSelf(productType, userId);
			model.addAttribute("productDtos", productDtos);
			System.out.println(productDtos);
			return "product";
		}
	}
	
	
	@GetMapping("/tag/{tag}")
	public String getProductTag(Model model, HttpServletRequest request, @PathVariable("tag") String tag) {
		HttpSession session = request.getSession();
		//判斷有沒有登入會員，沒有的話給全部商品資料
		if(session.getAttribute("userCert") == null) {
			List<ProductDto> productDtos = productService.findProductByTag(tag);
			model.addAttribute("productDtos", productDtos);
			return "product";
		}else {
			//有的話給除了自己的商品資料
			UserCert userCert = (UserCert)session.getAttribute("userCert");
			Integer userId = userCert.getUserId();
			List<ProductDto> productDtos = productService.findProductByTagNoSelf(tag, userId);
			model.addAttribute("productDtos", productDtos);
			System.out.println(productDtos);
			return "product";
		}
	}
	
	@GetMapping("/search")
	public String getSearch(Model model, HttpServletRequest request, @RequestParam("search") String search) {
		HttpSession session = request.getSession();
		//判斷有沒有登入會員，沒有的話給全部商品資料
		if(session.getAttribute("userCert") == null) {
			List<ProductDto> productDtos = productService.findProductBySearch(search);
			model.addAttribute("productDtos", productDtos);
			return "product";
		}else {
			//有的話給除了自己的商品資料
			UserCert userCert = (UserCert)session.getAttribute("userCert");
			Integer userId = userCert.getUserId();
			List<ProductDto> productDtos = productService.findProductBySearchNoSelf(search, userId);
			model.addAttribute("productDtos", productDtos);
			System.out.println(productDtos);
			return "product";
		}
	}
	
	
	//查看首頁商品資訊
	@GetMapping("/productsolo/{productId}")
	public String getProductsolo(Model model,@PathVariable("productId") Integer productId) {
//		System.out.println(productId);
		ProductDto productDto = productService.findProductByProductId(productId);
		Integer userId = productDto.getPorductUserId();
//		System.out.println(userId);
		UserDto userDto = userService.findUserById(userId);
//		System.out.println(userDto);
		System.out.println(productDto);
		model.addAttribute("userDto", userDto);
		model.addAttribute("productDto", productDto);
		return "productsolo";
	}
	
	
	//轉到新增商品頁面
	@GetMapping("/add")
	public String getProductAdd(Model model, @ModelAttribute ProductDto productDto) {
		return "productAdd";
	}
	
	//查看商品資訊
	@GetMapping("/detail/{productId}")
	public String updateProduct(Model model,@PathVariable("productId") Integer productId) {
		ProductDto productDto = productService.findProductByProductId(productId);
//		System.out.println(productDto);
		model.addAttribute("productDto", productDto);
		return "productUpdate";
	}
	
	//刪除商品
	@GetMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable("productId") Integer productId) {
		productService.deleteProduct(productId);
		return "redirect:/product/self";
	}
	
	//查看自己的商品
	@GetMapping("/self")
	public String getProductSelf(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserCert userCert = (UserCert)session.getAttribute("userCert");
		List<ProductDto> productDtos = productService.findProductByUserId(userCert.getUserId());
//		System.out.println(productDtos);
		model.addAttribute("productDtos", productDtos);
		return "userProduct";
	}
	
	//新增商品
	@PostMapping("/addproduct")
	public String addProduct(Model model, HttpServletRequest request, @RequestParam("productPhoto") MultipartFile productPhoto
																		,@RequestParam("productName") String productName
																		,@RequestParam("productNarrate") String productNarrate
																		,@RequestParam("productNum") Integer productNum
																		,@RequestParam("productPrice") Integer productPrice
																		,@RequestParam("productPlace") String productPalce
																		,@RequestParam("gender") String gender
																		,@RequestParam("idolName") String idolName
																		,@RequestParam("productType") String productType
																		,@RequestParam("tag") String tag){
		HttpSession session = request.getSession();
		UserCert userCert = (UserCert)session.getAttribute("userCert");
		Integer userid = userCert.getUserId();
		ProductDto productDto = new ProductDto();
		productDto.setPorductUserId(userid);
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		productDto.setProductDate(sqlDate);
		Path filePath = Paths.get(BASE_DIR).resolve(productPhoto.getOriginalFilename());
		try {
			Files.copy(productPhoto.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		}catch (IOException e) {
			e.printStackTrace();
		}
		productDto.setProductPhoto(productPhoto.getOriginalFilename());
	    productDto.setProductName(productName);
	    productDto.setProductNarrate(productNarrate);
	    productDto.setProductNum(productNum);
	    productDto.setProductPrice(productPrice);
	    productDto.setProductPlace(productPalce);
	    productDto.setProductPlace(productPalce);
	    productDto.setGender(gender);
	    productDto.setIdolName(idolName);
	    productDto.setProductType(productType);
	    productDto.setTag(tag);
		productService.addProduct(productDto);
		return "redirect:/product/self";
	}
	
	@PostMapping("/update")
	public String updateProduct(Model model, @ModelAttribute ProductDto productDto) {
		productService.updateProduct(productDto);
		
		return "redirect:/product/self";
	}
	
	
	
	
	
}
