package com.get.revenge.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.get.revenge.dao.UserDAO;


@Service
public class AuthServiceImp  implements AuthService, UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserService userService;
	
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
	com.get.revenge.entities.User userDomain = userService.getUser(username);
	
	return new User(userDomain.getUsername(),
					userDomain.getPassword(),
					getAuthorities(userDomain.getRole()));						
	 }	
	public Collection<? extends GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new SimpleGrantedAuthority(role));
        return authList;
    }	
		
	
	
	
	
}
