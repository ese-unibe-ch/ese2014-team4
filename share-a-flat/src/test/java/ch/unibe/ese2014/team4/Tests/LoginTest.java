package ch.unibe.ese2014.team4.Tests;



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

import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.service.AccountService;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.UserDao;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:config/springMVC.xml","classpath*:config/springData.xml", "classpath*:config/springSecurity.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class LoginTest {

    @Autowired
    UserDao userDao;

    @Autowired
    AccountService nacS;
    
    @Autowired
    UserService userService;
    
    
    

		
	@BeforeClass
	public static void setup()
	{

	} 
	    
    
    @Before
    public void setUser(){
    	SignupForm form = new SignupForm();
    	form.setUsername("testUser");
    	form.setEmail("test@email.ch");
    	form.setPassword("testPassword");
    	form.setPasswordRepeated("testPassword");
    	nacS.saveFrom(form);

    }
    
    @Test
    public void isUserThere(){
    	assertTrue(userService.doesUserAlreadyExists("testUser"));
    }
    
    @Test(expected = ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException.class)
    public void testInvalidUserException() {
    	SignupForm form = new SignupForm();
    	form.setUsername("testUser");
    	form.setEmail("test@email.ch");
    	form.setPassword("testPassword");
    	form.setPasswordRepeated("testPassword");
    	nacS.saveFrom(form);
    }

    
    @Test
    public void testFindUserByEmail() {
    	String EMAIL =  "test@email.ch";
      
        User findUser = userDao.findByEmail(EMAIL);
        assertEquals(findUser.getEmail(), EMAIL);
        assertEquals("testUser", findUser.getUsername());
    }
    
    @Test
    public void testAutority(){
    	User user = userDao.findByUsername("testUser");
    	assertEquals("testUser", user.getUsername());
    	assertTrue (userDao.findByUsername("testUser").getAuthorities().contains(new SimpleGrantedAuthority("ROLE_REGISTERED")));
    	assertFalse (userDao.findByUsername("testUser").getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }
    
    @Test
    public void testActivation(){
    	User user = userDao.findByUsername("testUser");
    	nacS.activateAccount(user, DigestUtils.shaHex(user.getEmail()));
    	assertTrue (userDao.findByUsername("testUser").getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER")));
    	assertEquals (1, userDao.findByUsername("testUser").getAuthorities().size());
    }

}

