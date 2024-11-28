package com.example.demo.exception;

public class UserNotFoundException extends CertException{
	
	public UserNotFoundException() {
		super("查無此使用者");
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}
}
