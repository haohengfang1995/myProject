package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.RoomDto;

public interface RoomService {

	//找尋所有房間
	List<RoomDto> findAllRoom();
	
	//根據買家Id找房間
	List<RoomDto> findAllRoomBuyId(Integer buyUserId);
	
	//根據賣家Id找房間
	List<RoomDto> findAllRoomSaleId(Integer saleUserId);
	
	//新增房間
	void addRoom(RoomDto RoomDto);
	
	//根據房間Id找尋
	RoomDto findRoomById(Integer roomId);
}
