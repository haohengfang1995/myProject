package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatDto {

	private Integer chatId;
	
	private String message;
	
	private Integer roomId;
	
	public ChatDto(String message, Integer roomId) {
		super();
        this.roomId = roomId;
        this.message = message;
    }

	
}
