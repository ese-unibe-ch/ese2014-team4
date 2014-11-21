package ch.unibe.ese2014.team4.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.AdType;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.NewAccountService;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.model.dao.UserDao;
import ch.unibe.ese2014.team4.model.dao.AdDao;

/**
 * This class serves only reiew-purposes.
 *  It registers an ese/ese user and adds a few ads, if database is empty.
 *
 */
@Service
public class DemoService    {

	@Autowired
	UserDao userDao;

	@Autowired
	UserService userService;
	
	@Autowired
	NewAccountService nas;
	
	@Autowired
	AdDao adDao;
	
	@Autowired
	AdService as;

	@Transactional
	public void populateDataBase(){
		if(!userService.doesUserAlreadyExists("ese")){
			setESEUser();
		}
		
		if(adDao.count()<3){
			setAds();
		}
			
		
		else{System.out.println("hat mehr");}
	}
	
	private void setESEUser(){
		SignupForm s = new SignupForm();
		s.setEmail("ese@ese.ch");
		s.setUsername("ese");
		s.setPassword("ese");
		s.setPasswordRepeated("ese");
		nas.saveFrom(s);
	}
	
	private void setAds(){
		AdForm a1 = new AdForm();
		a1.setAdType(AdType.ROOM);
		a1.setTitle("Best Room ever!");
		a1.setCity("Bern");
		a1.setZipCode(3000);
		a1.setNrOfFlatMates(1);
		
		AdForm a2 = new AdForm();
		a2.setAdType(AdType.FLAT);
		a2.setTitle("Best Flat ever!");
		a2.setCity("Bern");
		a2.setZipCode(3000);
		a2.setNrOfRooms(2);
		
		AdForm a3 = new AdForm();
		a3.setAdType(AdType.FLAT);
		a3.setTitle("Cool Flat!");
		a3.setCity("Zürich");
		a3.setZipCode(1234);
		a3.setNrOfRooms(2);
		try {
			as.saveAdForm(a1, userDao.findByUsername("ese"));
			as.saveAdForm(a2, userDao.findByUsername("ese"));
			as.saveAdForm(a3, userDao.findByUsername("ese"));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
