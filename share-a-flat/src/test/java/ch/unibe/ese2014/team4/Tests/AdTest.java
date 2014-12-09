package ch.unibe.ese2014.team4.Tests;




import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.AdType;
import ch.unibe.ese2014.team4.controller.service.AccountService;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.Visit;
import ch.unibe.ese2014.team4.model.dao.UserDao;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:config/springMVC.xml","classpath*:config/springData.xml", "classpath*:config/springSecurity.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class AdTest {

    @Autowired
    AdService adService;

    @Autowired
    AccountService accountService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    UserDao userDao;
	
    AdForm form;
    User owner;
    
    @Before
    public void setAd() throws InvalidUserException, Exception{
    	form = new AdForm();
    	owner= new User();
    	owner.setUsername("testUser");
    	userDao.save(owner);
    	form.setTitle("testTitle");
    	form.setAdType(AdType.FLAT);
    	form.setCharges(100);
    	form.setCity("Bern");
    	form.setZipCode(3000);
    	form.setStreet("teststrasse");
    	form.setStreetNumber("2");
    	form.setAvailableDate("10-10-2000");
    	adService.saveAdForm(form, owner);

    }
    
    @Test
    public void isAdThere(){
    	assertNotNull(adService.getAdsOfUserByUser(userService.getUserByUsername("testUser")));
    }
    @Test
    public void checkTitle(){
    	assertEquals("testTitle", adService.getAd(form.getId()).getTitle());
    }
    @Test
    public void deleteAdTest() throws InvalidUserException, Exception{
    	form = new AdForm();
    	User owner= new User();
    	owner.setUsername("deleteuser");
    	userDao.save(owner);
    	
    	form.setAdType(AdType.FLAT);
    	form.setCharges(100);
    	form.setCity("Bern");
    	form.setZipCode(3000);
    	form.setStreet("teststrasse");
    	form.setStreetNumber("2");
    	form.setAvailableDate("10-10-2000");
    	form = adService.saveAdForm(form, owner);
    	
    	adService.deleteAd(form.getId());
    	assertNull(adService.getAd(form.getId()));
    }
    
    @Test
    public void isBookmarked(){
    	
    	Ad ad = adService.getAd(form.getId());
    	User user = new User();
    	user.setUsername("testuser");	
    	adService.bookMarkAdforUser(ad.getId(),user);
    	assertEquals(ad, adService.getAd(user.getBookmarks().get(0)));
    }

    @Test
    public void setVisit() throws InvalidUserException, Exception{
    	List<String> listDate = new ArrayList<String>();
    	List<String> listStart = new ArrayList<String>();
    	List<String> listEnd = new ArrayList<String>();
    	listDate.add("11-12-1122");
    	listStart.add("10:00");
    	listEnd.add("15:00");
    	form.setVisitDate(listDate);
    	form.setStartTime(listStart);
    	form.setEndTime(listEnd);
    	adService.saveAdForm(form, owner);
    	Ad ad = adService.getAd(form.getId());
    	Visit visit = ad.getVisitList().get(0);
    	assertTrue(ad.getVisitList().size()>0);
    	assertEquals( "11-12-1122, 10:00 - 15:00", visit.toString());
    	
    	
    	adService.registerUserForVisit(visit.getId(), owner);
    	assertEquals("testUser", visit.getVisitorList().get(0).getUsername());
    	assertEquals(visit, adService.getVisitsUserRegistered(owner).get(0));
    }
    


}

