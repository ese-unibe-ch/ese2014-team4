package ch.unibe.ese2014.team4.controller.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.UserDao;


@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	UserService userService;
	
    @Autowired
    ApplicationContext appContext;
    
    @Autowired
    JavaMailSender mailSender;

	@Transactional
	public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException {

		if (userService.doesUserAlreadyExists(signupForm.getUsername()) ) {
			throw new InvalidUserException("Username is already in use. Select another username.");	
		}
		
		if (userService.doesEmailAddressAlreadyExist(signupForm.getEmail())) {
			throw new InvalidUserException("Email-address is already in use. Do you already have an account?");	
		}
		

		//doublecheck, javascript already testing this client-side.
		if (signupForm.getPasswordRepeated().equals(signupForm.getPassword())) {
			
			User user = new User();
			
			user.setUsername(signupForm.getUsername());
			user.setEmail(signupForm.getEmail());
			user.setPassword(DigestUtils.shaHex(signupForm.getPassword()));
			user.setProfileImage(getDefaultProfileImage());
			user = userDao.save(user); // save object to DB
			signupForm.setId(user.getId());
		} else {
			throw new InvalidUserException("Repeated Password is not the same as the Password entered before");
		}
		
		
		
		
		return signupForm;		
	}

	private byte[] getDefaultProfileImage(){

		File file=null;
		try {
			file = appContext.getResource("classpath:img/defaultProfileImage.png").getFile();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		byte[] byteImg=null;
		InputStream input=null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			byteImg= IOUtils.toByteArray(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return byteImg;
	}


	public void loginManually(User user) {
		Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	public void sendValidationMail(User user, String baseURL){
		String validationString = generateValidationString(user);
		String validationLink ="localhost:8080"+ appContext.getApplicationName() + "/submitValidationString?validationString="+validationString+"&userName="+user.getUsername();
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(user.getEmail());
		message.setFrom(user.getEmail());
		message.setText(validationLink);
		mailSender.send(message);
		System.out.println(validationLink);
	}
	public void activateAccount(User user, String validationString){
		if (validationString.equals(generateValidationString(user))){
			user.getAuthorities().clear();
			user.getAuthorities().add(new SimpleGrantedAuthority("ROLE_USER"));

			
			userDao.save(user);
		}
		else{throw new InvalidUserException("email-validation failed");}
	}
	
	private String generateValidationString(User user){
		return DigestUtils.shaHex(user.getEmail());
	}
}
