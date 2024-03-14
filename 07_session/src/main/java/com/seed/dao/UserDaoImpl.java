package com.seed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.seed.entity.User;

public class UserDaoImpl implements UserDao {
	
	private Connection connection;
	
	public UserDaoImpl() {}
	
	public UserDaoImpl(Connection con) {
		this.connection = con;
	}

	@Override
	public User findUserByUsername(String username) throws SQLException{
		String sql ="select * from users where username =?";
		User user = new User();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					user.setUserId(rs.getInt("user_id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setPassword(rs.getString("password"));
					user.setUsername(username);
					user.setEmail(rs.getString("email"));
				}
			}
		}
		return user;
	}

	@Override
	public User findUserByUserid(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String username, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
