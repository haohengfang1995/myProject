package com.example.demo.model.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roomId;
	
	//賣家使用者
	@Column(nullable = true)
	private Integer saleUserId;
	
	//賣家使用者
	@Column(nullable = true)
	private Integer buyUserId;
	
	@Column(nullable = true)
	private Integer productId;
	
	@Column(nullable = true)
	private Date roomDate;
	
	@Column(nullable = true)
	private String productName;
	
	@Column(nullable = true)
	private String productPlace;
	
	@Column(nullable = true)
	private String productPrice;
	
}
