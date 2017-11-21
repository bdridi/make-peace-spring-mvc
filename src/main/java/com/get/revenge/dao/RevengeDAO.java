package com.get.revenge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.get.revenge.entities.Revenge;


@Repository
public interface RevengeDAO 
	extends JpaRepository<Revenge, Long>{
	
}
