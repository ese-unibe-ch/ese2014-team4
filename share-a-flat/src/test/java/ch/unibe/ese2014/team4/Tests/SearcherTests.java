package ch.unibe.ese2014.team4.Tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.*;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.SearchForm;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.AdServiceImpl;
import ch.unibe.ese2014.team4.model.*;
import ch.unibe.ese2014.team4.model.dao.AdDao;

public class SearcherTests {

	private AdDao mockDao;
	private SearchForm searchForm = new SearchForm();
	private AdService adService = new AdService() {
		
		public void setAdDao(AdDao mockDao) {
			// TODO Auto-generated method stub
			
		}
		
		public AdForm saveAdForm(AdForm adForm, User owner)
				throws InvalidUserException, Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
		public Collection<Ad> getNewestAds(int days) {
			// TODO Auto-generated method stub
			return null;
		}
		
		public List<Ad> getAdByTitle(String title) {
			// TODO Auto-generated method stub
			return null;
		}
		
		public List<Ad> getAdByPrice(int price) {
			// TODO Auto-generated method stub
			return null;
		}
		
		public List<Ad> getAdByCity(String city) {
			// TODO Auto-generated method stub
			return null;
		}
		
		public Ad getAd(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
	}; 
	private ISearcher searcher = new SearcherDefaultCity(searchForm, adService);

	@Before
	public void setUp() {
		adService = new AdServiceImpl();
		mockDao = createStrictMock(AdDao.class);
		adService.setAdDao(mockDao);
	}

	@Test
	public void testOneAd() {
		searchForm.setCity("city1");
		searchForm.setMinPrice(0);
		searchForm.setMaxPrice(100);
	
		ArrayList<Ad> result = new ArrayList<Ad>();
		Address testAddess = new Address();
		String city = "city1";
		Ad testAd1 =  new Ad();
		testAd1.setPrice(100);
		testAd1.setAddress(testAddess);
		result.add(testAd1);
		/*
		 * String adName = "testAd 1"; int price = 100;
		 */
		expect(mockDao.findAllByAddressCity(city)).andReturn(result);

		replay(mockDao);
		assertEquals(searcher.getAdList().get(0), testAd1);
		verify(mockDao);
	}
}
