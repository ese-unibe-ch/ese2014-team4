package ch.unibe.ese2014.team4.controller.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.UserDao;


/**
 * Provides a UserDetails token used by String Security to check credentials.
 * 
 *
 */
@Service
public class LoginService implements  UserDetailsService {

	@Autowired
	UserDao userDao;


	@Transactional
	public UserDetails loadUserByUsername(String username){
		User user = userDao.findByUsername(username);
		
		if (user==null){throw new InvalidUserException("User does not exist.");}

		
		ArrayList<GrantedAuthority> list = translateRole(user.getRole());
		org.springframework.security.core.userdetails.User securityUser;
		securityUser = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), list);
		return securityUser;
	}
	
	private ArrayList<GrantedAuthority> translateRole(String roleString){
		ArrayList<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		list.add(new SimpleGrantedAuthority("ROLE_USER"));
		return list;
	}
	
}
