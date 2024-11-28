package com.example.demo.model.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	
	@Column(nullable = false)
	private String userName;
	
	@Column(name = "user_phone", nullable = false, unique = true)
	private String userPhone;
	
	@Column(name = "user_date", nullable = false)
	private Date userDate;
	
	@Column(name = "user_account_number", nullable = false, unique = true)
	private String userAccountNumber;
	
	@Column(name = "user_password", nullable = false)
	private String userPassword;
	
	@Column(name = "user_salt", nullable = false)
	private String userSalt;
	
	@Column(name = "user_password_hash", nullable = false)
	private String userPasswordHash;
	
	@Column(name = "user_email", nullable = false, unique = true)
	private String userEmail;

	@Column(name = "user_active", columnDefinition = "boolean default false")
	private Boolean userActive;
	
	@Column(name = "user_role", columnDefinition = "varchar(100) default 'normal_user'")
	private String userRole;
	
	
	
}
