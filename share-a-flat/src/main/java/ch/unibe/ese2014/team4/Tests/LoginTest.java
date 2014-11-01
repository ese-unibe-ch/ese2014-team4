package ch.unibe.ese2014.team4.Tests;
import java.util.ArrayList;
import java.util.List;
 




import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import ch.unibe.ese2014.team4.controller.service.LoginService;

 /**
  * Tests not yet ready.
  * @author Bachtler
  *
  */
@Configuration("classpath*:spring-test.xml")
public class LoginTest {
   
    static ApplicationContext applicationContext = null; //Manages all dependency injection-related things.
    static LoginService loginService = null;
    @Test
    public void testTest(){
    	assert 5 ==new Integer(5);
    }
	
    @BeforeClass
    public static void setup()
    {
        //Create application context instance
        applicationContext = new ClassPathXmlApplicationContext("/WEB-INF/config/springSecurity.xml");
        loginService = applicationContext.getBean(LoginService.class);
    }
     

    @Test
    public void testValidRole()
    {
        //Get the user by username from configured user details service
        UserDetails userDetails = loginService.loadUserByUsername ("m");
        Authentication authToken = new UsernamePasswordAuthenticationToken (userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);
        
        roleTester();
    }
    
    @PreAuthorize("hasRole('ROLE_USER')")
    private void roleTester(){
    	
    }
/*
    @Test (expected = AccessDeniedException.class)
    public void testInvalidRole()
    {
        UserDetails userDetails = userDetailsService.loadUserByUsername ("lokesh");
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new GrantedAuthorityImpl("ROLE_INVALID"));
        Authentication authToken = new UsernamePasswordAuthenticationToken (userDetails.getUsername(), userDetails.getPassword(), authorities);
        SecurityContextHolder.getContext().setAuthentication(authToken);
        DemoService service = (DemoService) applicationContext.getBean("demoService");
        service.method();
    }
     

    @Test (expected = AccessDeniedException.class)
    public void testInvalidUser()
    {
        UserDetails userDetails = userDetailsService.loadUserByUsername ("admin");
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new GrantedAuthorityImpl("ROLE_INVALID"));
        Authentication authToken = new UsernamePasswordAuthenticationToken (userDetails.getUsername(), userDetails.getPassword(), authorities);
        SecurityContextHolder.getContext().setAuthentication(authToken);
        DemoService service = (DemoService) applicationContext.getBean("demoService");
        service.method();
    }
     */
}