package com.seed.dao;

import java.sql.SQLException;
import java.util.List;

import com.seed.entity.User;

public interface UserDao {
	
	public User findUserByUsername(String username) throws SQLException;
	public User findUserByUserid(int userId) throws SQLException;
	public void save(User user) throws SQLException;
	public void update(String username, User user) throws SQLException;
	public void delete(String username) throws SQLException;
	public List<User> findAll() throws SQLException;
	public List<String> findFriends(String username) throws SQLException;

}
