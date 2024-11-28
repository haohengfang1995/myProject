package com.example.demo.exception;

public class PasswordInvailException extends CertException{
	
	public PasswordInvailException() {
		super("密碼不正確");
	}
	public PasswordInvailException(String message) {
		super(message);
	}
}
