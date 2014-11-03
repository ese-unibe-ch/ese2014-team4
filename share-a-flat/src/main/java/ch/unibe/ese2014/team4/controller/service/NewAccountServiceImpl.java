package ch.unibe.ese2014.team4.controller.service;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.model.Profile;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.ProfileDao;
import ch.unibe.ese2014.team4.model.dao.UserDao;

//TODO: set newly created user as logged in: http://stackoverflow.com/questions/7900994/programmatically-login-in-a-user-using-spring-security
@Service
public class NewAccountServiceImpl implements NewAccountService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	ProfileDao profileDao;

	@Transactional
	public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException {

		if (doesUserAlreadyExists(signupForm.getUsername()) ) {
			throw new InvalidUserException("username already exists.");	
		};
		
		if(!signupForm.getPasswordRepeated().equals(signupForm.getPassword())) {
			throw new InvalidUserException("Repeated Password is not the same as the Password entered before");
		}
		
		User user = new User();
		
		user.setUsername(signupForm.getUsername());
		user.setEmail(signupForm.getEmail());
		user.setPassword(DigestUtils.shaHex(signupForm.getPassword()));
		user = userDao.save(user); // save object to DB
		
		
		Profile profile = new Profile();
		profile.setOwner(user);
		
		//profile.setProfileImage(getDefaultProfileImage());
		profileDao.save(profile);
		
		user.setProfile(profile);
		
		user = userDao.save(user); // update user to contain its profile
		signupForm.setId(user.getId());

		return signupForm;
		
	}
	//doesnt work
	private byte[] getDefaultProfileImage(){
		File file = new File("/share-a-flat/img/defaultProfileImage.png");
		byte[] byteImg=null;
		InputStream input=null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			byteImg= IOUtils.toByteArray(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return byteImg;
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
