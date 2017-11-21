package com.get.revenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.get.revenge.dao.RevengeDAO;
import com.get.revenge.entities.Advice;
import com.get.revenge.entities.Revenge;

@Service("revengeService")
public class RevengeServiceImp implements RevengeService{
	
	final int POSTS_PER_PAGE = 2;
	@Autowired
	private RevengeDAO revengeDAO;
	
	// Get all revenges list 
	public List<Revenge> getAll() {
	
		List<Revenge> revenges = revengeDAO.findAll();
		return revenges;		
	}
	// Save a revenge
	public void save(Revenge revenge) {	
		
		if(revenge != null) {
			revengeDAO.save(revenge);
		}
	}
	// Find a revenge by it's ID
	public Revenge findOne(Long id) {
		// TODO Auto-generated method stub
		return revengeDAO.findOne(id);
	}

	public Page<Revenge> getRevengesHomePage() {
		
		return revengeDAO.findAll(new PageRequest(0, 4));
		
	}

	public Page<Revenge> getRevengesPage(int page) {
		
		return revengeDAO.findAll(new PageRequest(page,POSTS_PER_PAGE));
	}
	public void addNewAdvice(Long id, Advice advice) {
		
		Revenge revenge = revengeDAO.findOne(id);
		revenge.getAdvices().add(advice);
		revengeDAO.save(revenge);
	}

	

}
