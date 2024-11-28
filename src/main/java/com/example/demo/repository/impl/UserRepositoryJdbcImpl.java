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

import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepositoryJdbc;

@Repository
@PropertySource("classpath:sql.properties")//自動到src/main/respurces 找到 sql.propertis
public class UserRepositoryJdbcImpl implements UserRepositoryJdbc{

	private static final Logger Logger = LoggerFactory.getLogger(UserRepositoryJdbcImpl.class);
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("${user.sql.findAll}")
	private String findAllSql;
	
	@Value("${user.sql.getUserById}")
	private String getUserByIdSql;
	
	@Value("${user.sql.getUserByAccountNumber}")
	private String getUserByAccountNumberSql;
	
	@Value("${user.sql.saveUser}")
	private String saveUserSql;
	
	@Value("${user.sql.updatePassword}")
	private String updatePasswordSql;
	
	@Value("${user.sql.updateUser}")
	private String updateUserSql;
	
	@Value("${user.sql.deleteUser}")
	private String deleteUserSql;
	
	
	@Override
	public List<User> findAll() {
//		String sql = "select * from user";
		return jdbcTemplate.query(findAllSql, new BeanPropertyRowMapper<>(User.class));
	}

	@Override
	public Optional<User> getUserById(Integer userId) {
//		String sql = "select * from user where user_id = ?";
		try {
			User user = jdbcTemplate.queryForObject(getUserByIdSql, new BeanPropertyRowMapper<>(User.class),userId);
//			System.out.println(user);
			return Optional.of(user);
		}catch(DataAccessException e) {
			Logger.info(e.toString());
		}
		return Optional.empty();
	}

	@Override
	public Optional<User> getUserByAccountNumber(String userAccountNumber) {
		try {
			User user = jdbcTemplate.queryForObject(getUserByAccountNumberSql, new BeanPropertyRowMapper<>(User.class),userAccountNumber);
			return Optional.of(user);
		}catch(DataAccessException e) {
			Logger.info(e.toString());
		}
		return Optional.empty();
	}

	@Override
	public void saveUser(User user) {
//		String sql = "insert into user(salt,user_accountnumber, user_date, user_email, user_name, user_password, user_passwordhash, user_phone) values(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			int rowcount = jdbcTemplate.update(saveUserSql, user.getUserSalt(), user.getUserAccountNumber(), user.getUserDate(), user.getUserEmail()
					,user.getUserName(), user.getUserPassword(),user.getUserPasswordHash(), user.getUserPhone()
					);
			if (rowcount != 1) {
				throw new RuntimeException("新增失敗");
			}
		}catch(DataAccessException e) {
			Logger.info(e.toString());
		}
	}

	@Override
	public void updatePassword(Integer userId, String userPassword, String userPasswordHash) {
//		String sql = "update user set user_password = ?, user_passwordhash = ? where user_id = ?";
		try {
			int rowcount = jdbcTemplate.update(updatePasswordSql,userPassword, userPasswordHash, userId);
			if(rowcount != 1) {
				throw new RuntimeException("更新失敗");
			}
		}catch(DataAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(Integer userId, String userPhone, String userEmail) {
//		user.sql.updateUser = update user set user_phone = ?, user_email = ? where user_id = ?;
		try {
			int rowcount = jdbcTemplate.update(updateUserSql,userPhone, userEmail, userId);
			if(rowcount != 1) {
				throw new RuntimeException("更新失敗");
			}
		}catch(DataAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(Integer userId) {
//		String sql = "delete from user where user_id = ?";
		int rowcount = jdbcTemplate.update(deleteUserSql, userId);
		try {
			if(rowcount != 1) {
				throw new RuntimeException("刪除失敗");
			}
		}catch (DataAccessException e) {
			e.printStackTrace();
		}
		
	}

}
