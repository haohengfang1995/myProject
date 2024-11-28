package com.example.demo.repository.impl;


import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Chat;
import com.example.demo.repository.ChatRepositoryJdbc;

@Repository
@PropertySource("classpath:sql.properties")
public class ChatRepositoryJdbcImpl implements ChatRepositoryJdbc{

	private static final Logger Logger = LoggerFactory.getLogger(ChatRepositoryJdbcImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Value("${chat.sql.findChatByRoomIdSql}")
	private String findChatByRoomIdSql;
	@Value("${chat.sql.addChatSql}")
	private String addChatSql;
	
	@Override
	public List<Chat> findChatByRoomId(Integer roomId) {
		String sql = "select * form chat where room_id = ?";
		try {
			return jdbcTemplate.query(findChatByRoomIdSql, new BeanPropertyRowMapper<>(Chat.class), roomId);
		}catch (DataAccessException e) {
			Logger.info(e.toString());
			return Collections.emptyList();
		}
	}

	@Override
	public void addChat(Chat chat) {
		String sql = "insert into chat(message, room_id) values(?, ?)";
		try {
			int rowcount = jdbcTemplate.update(addChatSql, chat.getMessage(), chat.getRoomId());
			if(rowcount != 1) {
				throw new RuntimeException("新增失敗");
			}
		}catch (DataAccessException e) {
			Logger.info(e.toString());
		}
	}

}
