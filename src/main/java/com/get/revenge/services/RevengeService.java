package com.get.revenge.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.get.revenge.entities.Advice;
import com.get.revenge.entities.Revenge;

public interface RevengeService {
	
	public List<Revenge> getAll();
	
	public void save(Revenge revenge);
	
	public Revenge findOne(Long id);
	
	public Page<Revenge> getRevengesHomePage();
	
	public Page<Revenge> getRevengesPage(int page);
	
	public void addNewAdvice(Long id, Advice advice);

}
