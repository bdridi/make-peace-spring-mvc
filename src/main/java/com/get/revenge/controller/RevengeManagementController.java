package com.get.revenge.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.get.revenge.entities.Advice;
import com.get.revenge.entities.Revenge;
import com.get.revenge.services.AdviceService;
import com.get.revenge.services.RevengeService;
import com.get.revenge.services.UserService;

@Controller
public class RevengeManagementController {
	
	private static final Logger logger = LoggerFactory.getLogger(RevengeManagementController.class);

		
		
	@Autowired
	private RevengeService revengeService;
	@Autowired
	private UserService userService;
	@Autowired
	private AdviceService adviceService;
	
	// Page add a new Revenge wish
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView add() {
		
		ModelAndView model = new ModelAndView("addRevenge");
		model.addObject("revengeModel", new Revenge());
		return model;
		
	}
	
	// SaveRevenge Action
	@RequestMapping(value="/saveRevenge", method=RequestMethod.POST)
	public ModelAndView saveRevenge(@ModelAttribute("revengeModel") @Valid Revenge revenge,
			BindingResult result) {
		System.out.println("saveRevenge action ");
		ModelAndView model;
		
		if(result.hasErrors()) {
			System.out.println("form has errors ");
			 model = new ModelAndView("addRevenge");
			 System.out.println("redirecting to form  ");
			 model.addObject("revengeModel", revenge);	
		}
		else {
			 revengeService.save(revenge);
			 model = new ModelAndView("redirect:home");			
		}		
		return model;
		
	}
	
	// Page revenge details
	@RequestMapping(value="/details", method=RequestMethod.GET)
	public ModelAndView details(@RequestParam("id") Long id,
								@RequestParam(value = "advised", required = false) String advised) {	
			
		ModelAndView model = new ModelAndView("details");
		if (advised != null) {
			model.addObject("msg", "Thank you ! We wish your advice helps ");
		}		
		Revenge revenge = revengeService.findOne(id);
		model.addObject("revenge", revenge);
		return model;		
	}
	
	// Page Revenges List 
	@RequestMapping(value="/list")
	public ModelAndView list(Pageable pageable,
			@RequestParam(value="page",defaultValue="0") int page
			) throws Exception {
		
		Page<Revenge> revenges = revengeService.getRevengesPage(page);
		ModelAndView model = new ModelAndView("list");
		model.addObject("page", page);				
		int previous = 0; int next = 1;
		if( page > 0 )
			previous = page - 1;
		if (page < revenges.getTotalPages())
			next = page + 1;		
		List<String> pages = new ArrayList<String>();		
		for(int i=0;i<revenges.getTotalPages();i++)
			pages.add(String.valueOf(i));		
		model.addObject("previous", previous);
		model.addObject("next", next);
		model.addObject("currentPage", page);
		model.addObject("pages", pages);
		model.addObject("revenges",revenges);
		return model;
	}
	
	
	// Save Advice action
	@RequestMapping(value="/saveAdvice", method=RequestMethod.POST)
	public ModelAndView saveAdvice(HttpServletRequest request) {
		
		ModelAndView model;
		// Check if anonymous user or authenticated
	 	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			logger.info("User Authenticated ");
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			String advice = request.getParameter("advice");
			Long revenge_id = Long.valueOf(request.getParameter("revenge_id"));
			logger.info("advice :  "+advice);
			logger.info("revenge id :  "+revenge_id); 
			Advice adviceObj = new Advice(advice,userService.getUser(userDetails.getUsername()));
			adviceObj = adviceService.save(adviceObj);
			revengeService.addNewAdvice(revenge_id, adviceObj);	
			model = new ModelAndView("redirect:details?id="+revenge_id+"&advised");	
		}else {
			model = new ModelAndView("redirect:login");
		}		  			
		return model;
	}
}
