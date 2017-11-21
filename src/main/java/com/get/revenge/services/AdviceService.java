package com.get.revenge.services;

import java.util.List;

import com.get.revenge.entities.Advice;
import com.get.revenge.entities.Revenge;


public interface AdviceService {
	
	
	public List<Advice> getAll();
	
	public Advice save(Advice advice);
	
	public Advice findOne(Long id);

}
