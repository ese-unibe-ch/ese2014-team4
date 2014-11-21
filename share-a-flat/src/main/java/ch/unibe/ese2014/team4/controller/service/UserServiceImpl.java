package ch.unibe.ese2014.team4.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.model.Profile;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	
	public Profile getProfileByUsername(String username) {
		
		return userDao.findByUsername(username).getProfile();
	}

	public User getUserByUsername(String username) {
		
		return userDao.findByUsername(username);
	}
	
	public boolean doesEmailAddressAlreadyExist(String email) {
		// TODO Auto-generated method stub
		return !(userDao.findByEmail(email) == null);
	}
	public boolean doesUserAlreadyExists(String username) {
		return!(userDao.findByUsername(username) == null);
	}
	@Transactional
	public User getUser(Long id) {
		User user = userDao.findOne(id);
		if (user == null) {
			throw new InvalidUserException("There is no such user...");
		}
		return user;
	}

}
