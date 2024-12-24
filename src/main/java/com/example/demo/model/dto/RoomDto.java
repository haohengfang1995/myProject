package com.example.demo.model.dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDto {

	private Integer roomId;
	
	private Integer saleUserId;
	
	private Integer buyUserId;
	
	private Integer productId;
	
	private Date roomDate;
	
	private String productName;
	
	private String productPlace;
	
	private String productPrice;
	
	private String buyUserName;
	
	private String saleUserName;
	
	private String productPhoto;
	
	private String passKey;
	
	private List<String> message;
	
}
