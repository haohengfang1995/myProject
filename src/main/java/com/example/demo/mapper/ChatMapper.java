package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.dto.ChatDto;
import com.example.demo.model.entity.Chat;


@Component
public class ChatMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public ChatDto toDto(Chat chat) {
		return modelMapper.map(chat, ChatDto.class);
	}
	
	public Chat toChat(ChatDto chatDto) {
		return modelMapper.map(chatDto, Chat.class);
	}
}
