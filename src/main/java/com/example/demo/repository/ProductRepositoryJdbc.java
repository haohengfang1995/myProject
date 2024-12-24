package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.entity.Product;

public interface ProductRepositoryJdbc {

	//找尋所有商品
	List<Product> findAllProduct();
	
	//找尋除了自己商品列表
	List<Product> findNotUsProduct(Integer userId);
	
	//找尋自己商品
	List<Product> findProductByUserId(Integer userId);
	
	//根據產品Id搜尋產品資訊
	Optional<Product> findProductByProductId(Integer productId);
	
	//商品價格高到低搜尋
	List<Product> findProductByHigh();
	
	//商品價格高到低搜尋除了自己商品
	List<Product> findProductByHighNoSelf(Integer userId);
	
	//商品價格低到高搜尋
	List<Product> findProductByLow();
	
	//商品價格低到高搜尋除了自己商品
	List<Product> findProductByLowNoSelf(Integer userId);
	
	//相同商品地點搜尋
	List<Product> findProductByPlace(String productPlace);
	
	//相同商品地點搜尋除了自己商品
	List<Product> findProductByPlaceNoSelf(String productPlace, Integer userId);
	
	//商品日期新到舊搜尋
	List<Product> findProductByNew();
	
	//商品日期新到舊搜尋自己商品
	List<Product> findProductByNewNoSelf(Integer userId);
	
	//商品日期舊到新搜尋
	List<Product> findProductByOld(); 
	
	//商品日期舊到新搜尋除了自己商品
	List<Product> findProductByOldNoSelf(Integer userId); 

	//相同團體名稱搜尋
	List<Product> findProductByIdolName(String idolName);
	
	//相同團體名稱搜尋除了自己商品
	List<Product> findProductByIdolNameNoSelf(String idolName, Integer userId);
	
	//男團女團搜尋
	List<Product> findProductByGender(String gender);
	
	//男團女團搜尋除了自己商品
	List<Product> findProductByGenderNoSelf(String gender, Integer userId);
	
	//根據產品類型搜尋
	List<Product> findProductByType(String productType);
	
	//根據產品類型搜尋除了自己商品
	List<Product> findProductByTypeNoSelf(String productType, Integer userId);
	
	//根據相同標籤搜尋
	List<Product> findProductByTag(String tag);
	
	//根據相同標籤搜尋除了自己商品
	List<Product> findProductByTagNoSelf(String tag, Integer userId);
	
	//關鍵字搜尋
	List<Product> findProductBySerch(String message);
	
	//關鍵字搜尋除了自己商品
	List<Product> findProductBySerchNoSelf(String message, Integer userId);
	
	
	//新增商品
	void saveProduct(Product product);
	
	//修改商品
	void updateProduct(Product product);
	
	//刪除商品
	void deleteProduct(Integer productId);
	
	
}
