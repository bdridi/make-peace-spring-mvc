package com.get.revenge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.get.revenge.entities.Revenge;
import com.get.revenge.entities.User;
import com.get.revenge.services.AuthService;
import com.get.revenge.services.UserService;


@Controller 
public class AuthController {
	
	
	@Autowired
	private AuthService authService;
	@Autowired
	private UserService userService;
	
	
	// Login page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
								@RequestParam(value = "logout", required = false) String logout,
								@RequestParam(value = "logged", required = false) String logged,
								@RequestParam(value = "signed", required = false) String signed) {
		  
		ModelAndView model;		  
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			 model = new ModelAndView("redirect:login?logged");
		}
		else {
			model = new ModelAndView("login");
		}
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully."); 
		} 
		if (signed != null) {
			model.addObject("msg", "Congratulation you have created your account ! please sign in."); 
		}
		if (logged != null) {
			model.addObject("msg", "You are already logged in !"); 
		}
		  return model;

	}
	
	// Admin Panel
	@RequestMapping(value = "/admin", method = RequestMethod.GET)  
	public ModelAndView adminPage() {

	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This page is for ROLE_ADMIN only!");
	  model.setViewName("admin");
	  return model; 

	}
	
	// 403 Page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
	    //check if user is login
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (!(auth instanceof AnonymousAuthenticationToken)) {
		  UserDetails userDetails = (UserDetails) auth.getPrincipal();
		  model.addObject("username", userDetails.getUsername());
	    }
	    model.setViewName("403"); 
	    return model;
	    
		}
	
		// Register Page
		@RequestMapping(value="/signup", method=RequestMethod.GET)	
		public ModelAndView signup(@RequestParam(value = "exist", required = false) String exist) { 
			 
			ModelAndView model = new ModelAndView("signup");
			 if (exist != null) {
					model.addObject("msg", "Username already taken ! Please choose another.");  
			}			
			model.addObject("userModel", new User());
			return model;
		}
		
		// saveUser action
		@RequestMapping(value="/saveUser", method=RequestMethod.POST) 
		public ModelAndView saveUser(@ModelAttribute("userModel") @Valid User user,
				BindingResult result) {

			ModelAndView model;			
			if(result.hasErrors()) {					
				 model = new ModelAndView("signup");
				 model.addObject("userModel", user);
			}
			else {
				if (userService.getUser(user.getUsername()) != null ) {
					 
					model = new ModelAndView("redirect:signup?exist");	 
				} else {
				userService.save(user);
				model = new ModelAndView("redirect:login?signed");
				}
			} 		
			return model;			
		}
		
		
	
}
