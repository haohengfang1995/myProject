package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ProductDto;

public interface ProductService {

	//找尋所有商品
	public List<ProductDto> findAllProduct();
	
	//找尋除了自己商品列表
	public List<ProductDto> findNotUsProduct(Integer userId);
	
	//找尋自己商品
	public List<ProductDto> findProductByUserId(Integer userId);
	
	//根據產品Id搜尋產品資訊
	public ProductDto findProductByProductId(Integer productId);
	
	//商品價格高到低搜尋
	public List<ProductDto> findProductByHigh();
	
	//商品價格高到低搜尋除了自己
	public List<ProductDto> findProductByHighNoSelf(Integer userId);
	
	//商品價格低到高搜尋
	public List<ProductDto> findProductByLow();
	
	//商品價格低到高搜尋除了自己
	public List<ProductDto> findProductByLowNoSelf(Integer userId);
	
	//相同商品地點搜尋
	public List<ProductDto> findProductByPlace(String productPlace);
	
	//相同商品地點搜尋除了自己
	public List<ProductDto> findProductByPlaceNoself(String productPlace, Integer userId);
	
	//商品日期新到舊搜尋
	public List<ProductDto> findProductByNew();
	
	//商品日期新到舊搜尋除了自己
	public List<ProductDto> findProductByNewNoSelf(Integer userId);
	
	//商品日期舊到新搜尋
	public List<ProductDto> findProductByOld();
	
	//商品日期舊到新搜尋除了自己
	public List<ProductDto> findProductByOldNoSelf(Integer userId); 
	
	//相同團體名稱搜尋
	public List<ProductDto> findProductbyIdolName(String idolName);
	
	//相同團體名稱搜尋除了自己
	public List<ProductDto> findProductbyIdolNameNoSelf(String idolName, Integer userId);
	
	//男團女團搜尋
	public List<ProductDto> findProductByGender(String gender);
	
	//男團女團搜尋除了自己
	public List<ProductDto> findProductByGenderNoSelf(String gender, Integer userId);
	
	//根據產品類型搜尋
	public List<ProductDto> findProductByType(String productType);
	
	//根據產品類型搜尋除了自己
	public List<ProductDto> findProductByTypeNoSelf(String productType, Integer userId);
	
	//根據相同標籤搜尋
	public List<ProductDto> findProductByTag(String tag);
	
	//根據相同標籤搜尋除了自己
	public List<ProductDto> findProductByTagNoSelf(String tag, Integer userId);
	
	//關鍵字搜尋
	public List<ProductDto> findProductBySearch(String message);
	
	//關鍵字搜尋除了自己
	public List<ProductDto> findProductBySearchNoSelf(String message, Integer userId);
	
	//新增商品
	public void addProduct(ProductDto productDto);
	
	//修改商品
	public void updateProduct(ProductDto productDto);
	
	//刪除商品
	public void deleteProduct(Integer productId);
}
