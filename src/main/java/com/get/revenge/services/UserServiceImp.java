package com.get.revenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.get.revenge.dao.UserDAO;
import com.get.revenge.entities.User;

@Service
public class UserServiceImp implements UserService{
	
	
	@Autowired
	private UserDAO userDAO;


	public void save(com.get.revenge.entities.User user) {
		
		userDAO.save(user);	
		
	}

	public User getUser(String username) {
		
		return userDAO.findByUsername(username);
	}

}
