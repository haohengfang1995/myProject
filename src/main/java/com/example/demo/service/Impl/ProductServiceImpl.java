package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.entity.Product;
import com.example.demo.repository.ProductRepositoryJdbc;
import com.example.demo.service.ProductService;




@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepositoryJdbc productRepositoyJdbc;
	
	@Autowired
	ProductMapper productMapper;
	
	//找尋所有商品
	@Override
	public List<ProductDto> findAllProduct() {
		List<ProductDto> productDtos = productRepositoyJdbc.findAllProduct().stream()
										.map(e ->productMapper.toDto(e))
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findNotUsProduct(Integer userId) {
		List<ProductDto> productDtos = productRepositoyJdbc.findNotUsProduct(userId).stream()
										.map(e -> productMapper.toDto(e))
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductByUserId(Integer userId) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByUserId(userId).stream()
										.map(e -> productMapper.toDto(e))
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public ProductDto findProductByProductId(Integer productId) {
		Optional<Product> optProduct = productRepositoyJdbc.findProductByProductId(productId);
		Product product = optProduct.get();
//		System.out.println(product);
		return productMapper.toDto(product);
	}

	@Override
	public List<ProductDto> findProductByHigh() {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByHigh().stream()
										.map(e -> productMapper.toDto(e))
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductByLow() {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByLow().stream()
										.map(e -> productMapper.toDto(e))
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductByPlace(String productPlace) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByPlace(productPlace).stream()
										.map(productMapper :: toDto)
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductByNew() {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByNew().stream()
										.map(productMapper :: toDto)
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductByOld() {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByOld().stream()
										.map(productMapper :: toDto)
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductbyIdolName(String idolName) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByIdolName(idolName).stream()
										.map(productMapper :: toDto)
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductByGender(String gender) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByGender(gender).stream()
									.map(productMapper :: toDto)
									.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductByType(String productType) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByType(productType).stream()
										.map(productMapper :: toDto)
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductByTag(String tag) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByTag(tag).stream()
										.map(productMapper :: toDto)
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductBySearch(String message) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductBySerch(message).stream()
										.map(productMapper :: toDto)
										.collect(Collectors.toList());
		
		return productDtos;
	}
	
	

	@Override
	public List<ProductDto> findProductByHighNoSelf(Integer userId) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByHighNoSelf(userId).stream()
										.map(e -> productMapper.toDto(e))
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductByLowNoSelf(Integer userId) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByLowNoSelf(userId).stream()
										.map(productMapper :: toDto)
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductByPlaceNoself(String productPlace, Integer userId) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByPlaceNoSelf(productPlace, userId).stream()
										.map(productMapper :: toDto)
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductByNewNoSelf(Integer userId) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByNewNoSelf(userId).stream()
										.map(e -> productMapper.toDto(e))
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductByOldNoSelf(Integer userId) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByOldNoSelf(userId).stream()
										.map(productMapper :: toDto)
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductbyIdolNameNoSelf(String idolName, Integer userId) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByIdolNameNoSelf(idolName, userId).stream()
										.map(productMapper :: toDto)
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductByGenderNoSelf(String gender, Integer userId) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByGenderNoSelf(gender, userId).stream()
										.map(e -> productMapper.toDto(e))
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductByTypeNoSelf(String productType, Integer userId) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByTypeNoSelf(productType, userId).stream()
										.map(productMapper :: toDto)
										.collect(Collectors.toList());
		System.out.println("serviceimpl:" + productDtos);
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductByTagNoSelf(String tag, Integer userId) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductByTagNoSelf(tag, userId).stream()
										.map(e -> productMapper.toDto(e))
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public List<ProductDto> findProductBySearchNoSelf(String message, Integer userId) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductBySerchNoSelf(message, userId).stream()
										.map(productMapper :: toDto)
										.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public void addProduct(ProductDto productDto) {
		Product product = productMapper.toProduct(productDto);
		productRepositoyJdbc.saveProduct(product);
	}

	@Override
	public void updateProduct(ProductDto productDto) {
		Product product = productMapper.toProduct(productDto);
		productRepositoyJdbc.updateProduct(product);	
	}

	@Override
	public void deleteProduct(Integer productId) {
		productRepositoyJdbc.deleteProduct(productId);	
	}
	
}
