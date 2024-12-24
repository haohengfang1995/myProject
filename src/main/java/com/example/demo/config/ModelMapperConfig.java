package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Springboot 在啟動前會先完成此配置
public class ModelMapperConfig {

	//由	Springboot 來管理此物件(IOC)
	//若有必要其他程式可以透過@Autowired來取得該實體
	
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
}
