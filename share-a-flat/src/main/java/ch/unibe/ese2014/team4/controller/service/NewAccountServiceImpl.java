package ch.unibe.ese2014.team4.controller.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.model.Profile;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.UserDao;


@Service
public class NewAccountServiceImpl implements NewAccountService {

	@Autowired
	UserDao userDao;

	@Transactional
	public SignupForm saveFrom(SignupForm signupForm)
			throws InvalidUserException {

		if (doesUserAlreadyExists(signupForm.getUsername()) ){
			throw new InvalidUserException("username already exists.");
			
		};
		User user = new User();
		
		user.setUsername(signupForm.getUsername());
		user.setEmail(signupForm.getEmail());
		user.setPassword(DigestUtils.shaHex(signupForm.getPassword()));
		user.setProfile(new Profile());
		user = userDao.save(user); // save object to DB

		signupForm.setId(user.getId());

		return signupForm;

	}

	private boolean doesUserAlreadyExists(String username) {
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
