package com.get.revenge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.get.revenge.entities.User;

@Repository
public interface UserDAO extends JpaRepository<User,Long>{
	
	public User findByUsername(@Param("username") String username);

}
