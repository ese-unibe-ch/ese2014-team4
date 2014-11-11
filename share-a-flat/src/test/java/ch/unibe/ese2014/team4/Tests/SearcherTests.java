package ch.unibe.ese2014.team4.Tests;

import java.util.ArrayList;

import org.junit.*;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import ch.unibe.ese2014.team4.controller.pojos.SearchForm;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.AdServiceImpl;
import ch.unibe.ese2014.team4.controller.service.SearcherDefaultCity;
import ch.unibe.ese2014.team4.model.*;
import ch.unibe.ese2014.team4.model.dao.AdDao;

public class SearcherTests {

	private AdDao mockDao;
	private SearchForm searchForm = new SearchForm();
	private AdService adService = new AdServiceImpl();
	private SearcherDefaultCity searcher = new SearcherDefaultCity(searchForm,
			adService);
	private ArrayList<Ad> mockedSearchResult = new ArrayList<Ad>();
	private Ad testAd1 = new Ad();
	private Ad testAd2 = new Ad();
	private Ad testAd3 = new Ad();

	@Before
	public void setUp() {
		mockDao = createStrictMock(AdDao.class);
		adService.setAdDao(mockDao);

		Address testAddess1 = new Address();
		Address testAddess2 = new Address();
		Address testAddess3 = new Address();		

		testAddess1.setCity("City1");
		testAddess2.setCity("City2");
		testAddess3.setCity("City3");
		
		testAddess1.setZipCode(1111);
		testAddess2.setZipCode(2222);
		testAddess3.setZipCode(3333);


		testAd1.setAddress(testAddess1);
		testAd2.setAddress(testAddess2);
		testAd3.setAddress(testAddess3);

		testAd1.setPrice(100);
		testAd2.setPrice(200);
		testAd3.setPrice(300);

		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);
		mockedSearchResult.add(testAd3);
		// replay(mockDao);

	}

	@Test
	public void testByCityOneAd() {
		resetSearchForm();
		String city = "City1";
		searchForm.setCity(city);

		expect(mockDao.findAllByAddressCityIgnoreCase(city)).andReturn(
				mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList();
		assertEquals(testAd1, adsFromSearcher.get(0));
	//	assertEquals(1, adsFromSearcher.size());
		verify(mockDao);
	}

	@Test
	public void testByCityNotCapitalOneAd() {
		ArrayList<Ad> adsFromSearcher = new ArrayList<Ad>();
		resetSearchForm();
		String city = "city1";
		searchForm.setCity(city);

		expect(mockDao.findAllByAddressCityIgnoreCase(city)).andReturn(
				mockedSearchResult);

		replay(mockDao);
		adsFromSearcher = searcher.getAdList();
		assertEquals(testAd1, adsFromSearcher.get(0));
	//	assertEquals(1, adsFromSearcher.size());
		verify(mockDao);

	}

	@Test
	public void testByPriceOneAd() {
		int minPrice = 0, maxPrice = 100;
		resetSearchForm();
		searchForm.setMinPrice(minPrice);
		searchForm.setMaxPrice(maxPrice);

		expect(mockDao.findAll()).andReturn(mockedSearchResult);

		replay(mockDao);
		assertEquals(testAd1, searcher.getAdList().get(0));
		verify(mockDao);
	}
	
	@Test
	public void testByZipOneAd() {
		ArrayList<Ad> adsFromSearcher = new ArrayList<Ad>();
		resetSearchForm();
		String city = "1111";
		searchForm.setCity(city);

		expect(mockDao.findAllByAddressZipCode(1111)).andReturn(
				mockedSearchResult);

		replay(mockDao);
		adsFromSearcher = searcher.getAdList();
		assertEquals(testAd1, adsFromSearcher.get(0));
	//	assertEquals(1, adsFromSearcher.size());
		verify(mockDao);
	}


	private void resetSearchForm() {
		searchForm.setCity("");
		searchForm.setMaxPrice(0);
		searchForm.setMinPrice(0);
		searchForm.setNrOfRoomMates(0);
	}
}
