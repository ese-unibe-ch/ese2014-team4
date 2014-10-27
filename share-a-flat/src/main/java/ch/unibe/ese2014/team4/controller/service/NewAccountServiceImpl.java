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
//TODO: make sure, that username does not exist.
@Service
public class NewAccountServiceImpl implements NewAccountService {

	@Autowired
	UserDao userDao;

	@Transactional
	public SignupForm saveFrom(SignupForm signupForm)
			throws InvalidUserException {


		User user = new User();
		user.setUserName(signupForm.getUserName());
		user.setEmail(signupForm.getEmail());
		user.setPassword(DigestUtils.shaHex(signupForm.getPassword()));
		user.setProfile(new Profile());
		user = userDao.save(user); // save object to DB

		signupForm.setId(user.getId());

		return signupForm;

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
