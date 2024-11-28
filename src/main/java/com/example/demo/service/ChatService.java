package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ChatDto;

public interface ChatService {

	//根據roomid找尋訊息
	List<ChatDto> findChatByRoomId(Integer roomId);
	
	//新增訊息
	void addChat(ChatDto chatDto); 
}
