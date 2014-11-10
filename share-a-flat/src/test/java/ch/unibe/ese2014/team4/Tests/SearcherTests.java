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
	private AdService adService = new AdServiceImpl();;
	private SearcherDefaultCity searcher = new SearcherDefaultCity(searchForm,
			adService);
	private ArrayList<Ad> mockedSearchedResult = new ArrayList<Ad>();
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

		mockedSearchedResult.add(testAd1);
		mockedSearchedResult.add(testAd2);
		mockedSearchedResult.add(testAd3);
	}

	@Test
	public void testByCityOneAd() {
		String city = "city1";
		searchForm.setCity(city);
		searchForm.setMinPrice(0);
		searchForm.setMaxPrice(100);

		expect(mockDao.findAllByAddressCity(city)).andReturn(
				mockedSearchedResult);

		replay(mockDao);
		assertEquals(testAd1, searcher.getAdList().get(0));
		assertEquals(1, searcher.getAdList().size());
		verify(mockDao);
	}
}
