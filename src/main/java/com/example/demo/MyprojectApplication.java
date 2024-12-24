package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@ServletComponentScan
@SpringBootApplication
public class MyprojectApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MyprojectApplication.class, args);
	}

}
