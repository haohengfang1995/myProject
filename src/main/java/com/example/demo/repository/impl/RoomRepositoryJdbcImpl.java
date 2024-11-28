package com.example.demo.repository.impl;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Room;
import com.example.demo.repository.RoomRepositoryJdbc;

@Repository
@PropertySource("classpath:sql.properties")
public class RoomRepositoryJdbcImpl implements RoomRepositoryJdbc{

	private static final Logger Logger = LoggerFactory.getLogger(RoomRepositoryJdbcImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Value("${room.sql.findAllRoomSql}")
	private String findAllRoomSql;
	
	@Value("${room.sql.findAllRoomBuyIdSql}")
	private String findAllRoomBuyIdSql;
	
	@Value("${room.sql.findAllRoomSaleIdSql}")
	private String findAllRoomSaleIdSql;
	
	@Value("${room.sql.addRoomSql}")
	private String addRoomSql;
	
	@Value("${room.sql.findRoomByIdSql}")
	private String findRoomByIdSql;
	
	@Override
	public List<Room> findAllRoom() {
		String sql = "select * from room";
		return jdbcTemplate.query(findAllRoomSql, new BeanPropertyRowMapper<>(Room.class));
	}

	@Override
	public List<Room> findAllRoomBuyId(Integer buyUserId) {
		String sql = "select * from room where buy_user_id = ? order by room_date desc";
		return jdbcTemplate.query(findAllRoomBuyIdSql, new BeanPropertyRowMapper<>(Room.class), buyUserId);
	}

	@Override
	public List<Room> findAllRoomSaleId(Integer saleUserId) {
		String sql = "select * from room where sale_user_id = ? order by room_date desc";
		return jdbcTemplate.query(findAllRoomSaleIdSql, new BeanPropertyRowMapper<>(Room.class), saleUserId);
	}

	@Override
	public void addRoom(Room room) {
		String sql = "insert into room(buy_user_id, sale_user_id, product_id, room_date, product_name, product_place, product_price) values(?, ?, ?, ?, ?, ?, ?)";
		try {
			int rowcount = jdbcTemplate.update(addRoomSql, room.getBuyUserId(), room.getSaleUserId(), room.getProductId(), room.getRoomDate(), room.getProductName(), room.getProductPlace(), room.getProductPrice());
			if(rowcount != 1) {
				throw new RuntimeException("新增失敗");
			}
		}catch (DataAccessException e) {
			Logger.info(e.toString());
		}
	}

	@Override
	public Optional<Room> findRoomById(Integer roomId) {
		String sql = "select * from room where room_id = ?";
		try {
//			System.out.println("rep:" + roomId);
			Room room = jdbcTemplate.queryForObject(findRoomByIdSql, new BeanPropertyRowMapper<>(Room.class), roomId);
//			System.out.println("room:" + room);
			return Optional.of(room);
		}catch (DataAccessException e) {
			Logger.info(e.toString());
		}
		return Optional.empty();
	}



}
