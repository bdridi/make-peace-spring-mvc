package com.get.revenge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.get.revenge.entities.Advice;

@Repository
public interface AdviceDAO  
	extends JpaRepository<Advice,Long>{

}
