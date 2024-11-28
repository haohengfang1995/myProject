package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.RoomMapper;
import com.example.demo.model.dto.RoomDto;
import com.example.demo.model.entity.Room;
import com.example.demo.repository.RoomRepositoryJdbc;
import com.example.demo.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	RoomRepositoryJdbc roomRepositoryJdbc;
	
	@Autowired
	RoomMapper roomMapper;
	
	@Override
	public List<RoomDto> findAllRoom() {
		List<RoomDto> roomDtos = roomRepositoryJdbc.findAllRoom().stream()
									.map(roomMapper :: toDto)
									.collect(Collectors.toList());
		return roomDtos;
	}

	@Override
	public List<RoomDto> findAllRoomBuyId(Integer buyUserId) {
		List<RoomDto> roomDtos = roomRepositoryJdbc.findAllRoomBuyId(buyUserId).stream()
									.map(e -> roomMapper.toDto(e))
									.collect(Collectors.toList());
		return roomDtos;
	}

	@Override
	public List<RoomDto> findAllRoomSaleId(Integer saleUserId) {
		List<RoomDto> roomDtos = roomRepositoryJdbc.findAllRoomSaleId(saleUserId).stream()
									.map(e -> roomMapper.toDto(e))
									.collect(Collectors.toList());
		return roomDtos;
	}

	@Override
	public RoomDto findRoomById(Integer roomId) {

		Optional<Room> optRoom = roomRepositoryJdbc.findRoomById(roomId);
		return roomMapper.toDto(optRoom.get());
	}

	@Override
	public void addRoom(RoomDto RoomDto) {
		Room room = roomMapper.toRoom(RoomDto);
		roomRepositoryJdbc.addRoom(room);
	}

	
}
