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
public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	@Column(columnDefinition = "varchar(200) default 'null'")
	private String productPhoto;
	
	@Column(nullable = true)
	private Integer productPrice;
	
	@Column(nullable = true)
	private String productNarrate;
	
	@Column(nullable = true)
	private String productName;
	
	
	@Column(nullable = true)
	private Integer productNum;
	
	
	@Column(nullable = true)
	private String productPlace;
	
	@Column(nullable = true)
	private Date productDate;
	
	@Column(nullable = true)
	private String idolName;
	
	@Column(nullable = true)
	private String gender;
	
	@Column(nullable = true)
	private String productType;
	
	@Column
	private String tag;
	
	
	@Column(nullable = true)
	private Integer productUserId;

	
	
}
