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
 * This class serves only reiew-purposes.
 *  It registers an ese/ese user and adds a few ads, if database is empty.
 *
 */
@Service
public class ReviewService    {

	@Autowired
	UserDao userDao;


	@Transactional
	public void populateDataBase(){

	}
	
}
