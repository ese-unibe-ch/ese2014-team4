package ch.unibe.ese2014.team4.Tests;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.User;


public class DaoTests {
	
	@Autowired
	private AdService adSevice;
	
	private AdForm testAdForm1;
	
	private User testUser1;
	
	@Before
	public void setUp() {
		
		testAdForm1.setTitle("testAd1");
		testUser1 = new User();
	}
		
	@Test
	public void adDaoTest() throws InvalidUserException, Exception{
		adSevice.saveAdForm(testAdForm1, testUser1);
		
		List<Ad> testAds1 = adSevice.getAdByTitle("testAd1");
		assertEquals("testAd1", testAds1.get(0).getTitle());		
	}
}
