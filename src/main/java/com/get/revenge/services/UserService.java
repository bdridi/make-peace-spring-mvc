package com.get.revenge.services;

import com.get.revenge.entities.User;

public interface UserService {
	
	public void save(User user);
	
	public User getUser(String username);
	

}
