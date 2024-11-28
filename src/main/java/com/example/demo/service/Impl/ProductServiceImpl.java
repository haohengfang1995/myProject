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
	public List<ProductDto> findProdcutByLow() {
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
		List<ProductDto> productDtos = productRepositoyJdbc.findProductbyIdolName(idolName).stream()
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
	public List<ProductDto> findProductBySerch(String message) {
		List<ProductDto> productDtos = productRepositoyJdbc.findProductBySerch(message).stream()
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
