package com.seed.service;

import com.seed.entity.User;

public interface UserService {
	
	boolean isValidUser(String username, String password);
	User getUser(String username);
	

}
