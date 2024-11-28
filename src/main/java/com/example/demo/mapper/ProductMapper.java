package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.entity.Product;

@Component
public class ProductMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ProductDto toDto(Product product) {
		ProductDto productDto = modelMapper.map(product, ProductDto.class);
		productDto.setPorductUserId(product.getProductUserId());;
		return productDto;
	}
	
	public Product toProduct(ProductDto productDto) {
		return modelMapper.map(productDto, Product.class);
	}
	
}
