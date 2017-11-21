package com.get.revenge.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.get.revenge.services.RevengeService;

@Controller
public class HomeController{
	
	@Autowired
	private RevengeService revengeService;
	
	// Home page
	@RequestMapping(value="/home")
	public ModelAndView home(Pageable pageable) throws Exception {
		
		ModelAndView model = new ModelAndView("index");
		model.addObject("revenges",revengeService.getRevengesHomePage());
		return model;
	}
	
	// Home page 
	@RequestMapping(value="index")
	public ModelAndView index(Pageable pageable) throws Exception {
		
		ModelAndView model = new ModelAndView("index");
		model.addObject("revenges",revengeService.getRevengesHomePage());
		return model;
	}
}