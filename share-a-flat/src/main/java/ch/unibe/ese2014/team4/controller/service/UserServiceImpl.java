package ch.unibe.ese2014.team4.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.exceptions.ProfileException;
import ch.unibe.ese2014.team4.model.Profile;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	//currently not needed?
	public Profile getProfileByUsername(String username) throws ProfileException {
		Profile profile = userDao.findByUsername(username).getProfile();
		if (profile==null) throw new ProfileException("Profile of " + username +" not found");
		return profile;
	}
	/**
	 * @exception InvalidUserException
	 */
	public User getUserByUsername(String username) {
		User user =  userDao.findByUsername(username);
		if (user==null) throw new InvalidUserException("user not found");
		return user;
	}
	
	public boolean doesEmailAddressAlreadyExist(String email) {
		// TODO Auto-generated method stub
		return !(userDao.findByEmail(email) == null);
	}
	public boolean doesUserAlreadyExists(String username) {
		return!(userDao.findByUsername(username) == null);
	}
	/**
	 * @exception InvalidUserException
	 */
	public User getUser(Long id) {
		User user = userDao.findOne(id);
		if (user == null) {
			throw new InvalidUserException("There is no such user...");
		}
		return user;
	}

}
