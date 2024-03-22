package com.seed.service;

import java.util.List;

import com.seed.entity.User;

public interface UserService {
	
	boolean isValidUser(String username, String password);
	User getUser(String username);
	List<String> getFriends(String username);
	

}
