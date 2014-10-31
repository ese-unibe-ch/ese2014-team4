package ch.unibe.ese2014.team4.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.unibe.ese2014.team4.model.Profile;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	
	public Profile getMyProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserByUsername(String username) {
		
		return userDao.findByUsername(username);
	}

}
