package com.get.revenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.get.revenge.dao.AdviceDAO;
import com.get.revenge.entities.Advice;

@Service
public class AdviceServiceImp implements AdviceService {
	
	@Autowired
	AdviceDAO adviceDAO;
	
	public List<Advice> getAll() {
		
		return adviceDAO.findAll();
	}

	public Advice save(Advice advice) { 
		// TODO Auto-generated method stub
		return adviceDAO.save(advice);
	}

	public Advice findOne(Long id) {
		// TODO Auto-generated method stub
		return adviceDAO.findOne(id);
	}

}
