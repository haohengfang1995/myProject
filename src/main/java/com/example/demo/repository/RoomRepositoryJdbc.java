package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.entity.Room;

public interface RoomRepositoryJdbc {

	//找尋所有房間
	List<Room> findAllRoom();
	
	//根據房間id找房間
	Optional<Room> findRoomById(Integer roomId);
	
	//根據買家id找房間
	List<Room> findAllRoomBuyId(Integer buyUserId);
	
	//根據賣家id找房間
	List<Room> findAllRoomSaleId(Integer saleUserId);
	
	//新增房間
	void addRoom(Room room);
	
	

}
