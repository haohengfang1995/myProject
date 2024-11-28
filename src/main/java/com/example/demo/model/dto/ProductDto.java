package com.example.demo.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	
	private Integer productId;
	
	private String productPhoto;
	
	private Integer productPrice;
	
	private String productNarrate;
	
	private String productName;
	
	private Integer productNum;
	
	private String productPlace;
	
	private Date productDate;
	
	private String idolName;
	
	private String gender;
	
	private String productType;
	
	private String tag;
	
	private Integer porductUserId;
}
