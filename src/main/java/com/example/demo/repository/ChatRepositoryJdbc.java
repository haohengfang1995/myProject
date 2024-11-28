package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.entity.Chat;

public interface ChatRepositoryJdbc {
	
	//根據roomid找訊息
	List<Chat> findChatByRoomId(Integer roomId);
	
	//新增訊息
	void addChat(Chat chat);

}
