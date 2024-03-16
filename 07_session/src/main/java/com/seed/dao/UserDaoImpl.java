package com.seed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public User findUserByUserid(int userId) throws SQLException{
		String sql ="select * from users where username =?";
		User user = new User();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, userId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					user.setUserId(rs.getInt("user_id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setPassword(rs.getString("password"));
					user.setUsername(rs.getString("username"));
					user.setEmail(rs.getString("email"));
				}
			}
		}
		return user;
	}

	@Override
	public void save(User user) {
		String sql = "INSERT INTO USERS(USERID, USER_NAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) values (seq_user.nextval,?,?,?,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());
			int rowCount = ps.executeUpdate();
			System.out.println(rowCount+" row inserted");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
		

	@Override
	public void update(String username, User user) {
		String sql = "update users set first_name =?, last_name =?, password=?,email = ? where username =?";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getUsername());
			int rowCount = ps.executeUpdate();
			
			System.out.println(rowCount+" row inserted");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String username) {
		String sql = "delete from users where username = ?";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			
			ps.setString(1, username);
			int rowCount = ps.executeUpdate();
			
			System.out.println(rowCount+" row inserted");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> findAll() throws SQLException{
		String sql ="select * from users";
		List<User> users = new ArrayList<User>();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					User user = new User();
					user.setUserId(rs.getInt("user_id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setPassword(rs.getString("password"));
					user.setUsername(rs.getString("username"));
					user.setEmail(rs.getString("email"));
					
					users.add(user);
				}
			}
		}
		return users;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<String> findFriends(String username) throws SQLException {
		String sql= "select friend from friends where username =?";
		List<String> list = new ArrayList<String>();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					list.add(rs.getString(1));
				}
			}
		}
		return list;
	}

}
