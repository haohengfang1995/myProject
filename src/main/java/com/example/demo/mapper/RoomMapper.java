package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.dto.RoomDto;
import com.example.demo.model.entity.Room;

@Component
public class RoomMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public RoomDto toDto(Room room) {
		return modelMapper.map(room, RoomDto.class);
	}
	
	public Room toRoom(RoomDto roomDto) {
		return modelMapper.map(roomDto, Room.class);
	}
}
