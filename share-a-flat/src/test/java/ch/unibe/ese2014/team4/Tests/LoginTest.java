package ch.unibe.ese2014.team4.Tests;



import java.security.Principal;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.service.LoginService;
import ch.unibe.ese2014.team4.controller.service.NewAccountService;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.UserDao;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:springMVC.xml","classpath*:springData.xml", "classpath*:springSecurity.xml"})
//@TestExecutionListeners(listeners={ServletTestExecutionListener.class,
//        DependencyInjectionTestExecutionListener.class,
//        DirtiesContextTestExecutionListener.class,
//        TransactionalTestExecutionListener.class,
//        WithSecurityContextTestExcecutionListener.class})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class LoginTest {

    @Autowired
    UserDao userDao;

    @Autowired
    NewAccountService nacS;
    
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
//    @Test
//    @WithUserDetails
//    public void isNewUserLoggedIn() {
//
//    	System.out.println(sch.getContext().getAuthentication());
//    	//assertEquals(loggedInUser,"testUser");
//    	
//    	
//    }
    
    @Test
    public void testFindUserByEmail() {
    	String EMAIL =  "test@email.ch";
      
        User findUser = userDao.findByEmail(EMAIL);
        assertEquals(findUser.getEmail(), EMAIL);
    }

}


///**
// * Tests not yet ready.
// * @author Bachtler
// */
//
//@Configuration("classpath*:springMVC.xml")
//public class LoginTest {
//  
//   static ApplicationContext applicationContext = null; //Manages all dependency injection-related things.
//   static LoginService loginService = null;
//
//	
//   @BeforeClass
//   public static void setup()
//   {
//       //Create application context instance
//       applicationContext = new ClassPathXmlApplicationContext("springSecurity.xml");
//       loginService = applicationContext.getBean(LoginService.class);
//   } 
//   
//   @Test
//   public void createNewUserTest(){
//	   
//	   
//   }
//}
