package com.example.demo.exception;

public class UserAlreadyExistsException extends CertException{
	
	public UserAlreadyExistsException(String Message) {
		super(Message);
	}
	
	public UserAlreadyExistsException() {
		super("此使用者已存在");
	}
		
}
