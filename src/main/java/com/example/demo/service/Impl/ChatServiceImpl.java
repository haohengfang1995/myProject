package com.example.demo.service.Impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.ChatMapper;
import com.example.demo.model.dto.ChatDto;
import com.example.demo.model.entity.Chat;
import com.example.demo.repository.ChatRepositoryJdbc;
import com.example.demo.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService{

	@Autowired
	private ChatRepositoryJdbc chatRepositoryJdbc;
	
	@Autowired
	private ChatMapper chatMapper;
	
	@Override
	public List<ChatDto> findChatByRoomId(Integer roomId) {
		List<Chat> chats = chatRepositoryJdbc.findChatByRoomId(roomId);
		if(!chats.isEmpty()) {
			List<ChatDto> chatDtos = chats.stream().map(chatMapper :: toDto).collect(Collectors.toList());
			return chatDtos;
		}
//		List<ChatDto> chatDtos = chatRepositoryJdbc.findChatByRoomId(roomId).stream()
//									.map(chatMapper :: toDto)
//									.collect(Collectors.toList());
		return Collections.emptyList();
	}

	@Override
	public void addChat(ChatDto chatDto) {
		chatRepositoryJdbc.addChat(chatMapper.toChat(chatDto));
	}

}
