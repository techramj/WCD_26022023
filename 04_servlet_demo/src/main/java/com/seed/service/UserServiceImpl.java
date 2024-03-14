package com.seed.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.seed.dao.UserDao;
import com.seed.dao.UserDaoImpl;
import com.seed.entity.User;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	public UserServiceImpl(Connection con) {
		userDao = new UserDaoImpl(con);
	}

	@Override
	public boolean isValidUser(String username, String password) {
		if(password == null) {
			return false;
		}
		try {
			User user = userDao.findUserByUsername(username);
			return password.equals(user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUser(String username) {
		try {
			return userDao.findUserByUsername(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
