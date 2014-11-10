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

		String city1 = "city1";
		String city2 = "city2";
		String city3 = "city3";

		testAddess1.setCity(city1);
		testAddess2.setCity(city2);
		testAddess3.setCity(city3);

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
		String city = "city1";
		searchForm.setCity(city);

		expect(mockDao.findAllByAddressCity(city))
				.andReturn(mockedSearchResult);

		replay(mockDao);
		assertEquals(testAd1, searcher.getAdList().get(0));
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
	
	private void resetSearchForm() {
		searchForm.setCity("");
		searchForm.setMaxPrice(0);
		searchForm.setMinPrice(0);
		searchForm.setNrOfRoomMates(0);
	}
}
