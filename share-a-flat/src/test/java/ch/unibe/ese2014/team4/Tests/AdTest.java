package ch.unibe.ese2014.team4.Tests;



import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.AdType;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.service.AccountService;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.Address;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.AdDao;
import ch.unibe.ese2014.team4.model.dao.UserDao;
import static org.easymock.EasyMock.createStrictMock;
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
    
    @Before
    public void setAd() throws InvalidUserException, Exception{
    	form = new AdForm();
    	User owner= new User();
    	owner.setUsername("testUser");
    	userDao.save(owner);
    	
    	form.setAdType(AdType.FLAT);
    	form.setCharges(100);
    	form.setCity("Bern");
    	form.setZipCode(3000);
    	form.setAvailableDate("10-10-2000");
    	adService.saveAdForm(form, owner);


    }
    
    @Test
    public void isAdThere(){
    	assertEquals("testUser", adService.getAd(new Long(1)).getOwner().getUsername());
    }
    
    @Test(expected = ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException.class)
    public void testInvalidUserException() {

    }

    


}

