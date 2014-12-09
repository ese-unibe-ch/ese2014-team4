package ch.unibe.ese2014.team4.Tests;

import java.util.ArrayList;
import org.junit.*;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.AdServiceImpl;
import ch.unibe.ese2014.team4.controller.service.SearchServiceImpl;
import ch.unibe.ese2014.team4.model.*;
import ch.unibe.ese2014.team4.model.dao.AdDao;

public class SearcherTests {

	private AdDao mockDao;
	private SearchForm searchForm = new SearchForm();
	private AdService adService = new AdServiceImpl();
	private SearchServiceImpl searcher = new SearchServiceImpl();
	
	private ArrayList<Ad> mockedSearchResult;
	private Ad testAd1 = new Ad();
	private Ad testAd2 = new Ad();
	private Ad testAd3 = new Ad();


	@Before
	public void setUp() {
		mockedSearchResult = new ArrayList<Ad>();
		searcher.setAdService(adService);
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
	
		testAd1.setNetto(100);
		testAd2.setNetto(200);
		testAd3.setNetto(300);
		
		testAd1.setCharges(0);
		testAd2.setCharges(0);
		testAd3.setCharges(0);
		
		testAd1.setBrutto();
		testAd2.setBrutto();
		testAd3.setBrutto();

		
		testAd1.setNrOfFlatMates(1);
		testAd2.setNrOfFlatMates(2);
		testAd3.setNrOfFlatMates(3);
		
		testAd1.setNrOfRooms(1);
		testAd2.setNrOfRooms(2);
		testAd3.setNrOfRooms(2);
		testAd1.setId(new Long(0));
		testAd2.setId(new Long(1));
		testAd3.setId(new Long(3));

		testAd1.setAvailableDate("01-01-2011");
		testAd2.setAvailableDate("01-01-2012");
		testAd3.setAvailableDate("01-01-2013");

	}
	
	

	@Test
	public void testByCity() {
		resetSearchForm();

		mockedSearchResult.add(testAd1);

		String city = "city1";
		searchForm.setCityOrZip(city);

		expect(mockDao.findAllByAddressCityIgnoreCase(city)).andReturn(
				mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd1, adsFromSearcher.get(0));
		verify(mockDao);
	}

	@Test
	public void testByZip() {
		resetSearchForm();

		mockedSearchResult.add(testAd1);

		String city = "1111";
		searchForm.setCityOrZip(city);

		expect(mockDao.findAllByAddressZipCode(1111)).andReturn(
				mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd1, adsFromSearcher.get(0));
		verify(mockDao);
	}
	
	@Test
	public void testByNrRoomMates() {
		resetSearchForm();

		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);
		mockedSearchResult.add(testAd3);
		
		searchForm.setMinNrOfFlatMates(2);
		searchForm.setMaxNrOfFlatMates(2);

		expect(mockDao.findAll()).andReturn(
				mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd2, adsFromSearcher.get(0));
		assertEquals(1, adsFromSearcher.size());
		verify(mockDao);
	}
	
	@Test
	public void testByNrRooms() {
		resetSearchForm();

		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);
		mockedSearchResult.add(testAd3);
		
		searchForm.setMinNrOfRooms(2);
		searchForm.setMaxNrOfRooms(2);

		expect(mockDao.findAll()).andReturn(
				mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd2, adsFromSearcher.get(1));
		assertEquals(testAd3, adsFromSearcher.get(0));
		assertEquals(2, adsFromSearcher.size());
		verify(mockDao);
	}

	@Test
	public void testByPriceOneAd() {
		resetSearchForm();

		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);
		mockedSearchResult.add(testAd3);

		searchForm.setMinPrice(0);
		searchForm.setMaxPrice(100);

		expect(mockDao.findAll()).andReturn(mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd1, adsFromSearcher.get(0));
		assertEquals(1, adsFromSearcher.size());
		verify(mockDao);
	}

	@Test
	public void testByPriceTwoAds() {
		resetSearchForm();

		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);
		mockedSearchResult.add(testAd3);

		searchForm.setMinPrice(0);
		searchForm.setMaxPrice(250);


		expect(mockDao.findAll()).andReturn(mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd1, adsFromSearcher.get(1));
		assertEquals(testAd2, adsFromSearcher.get(0));
		assertEquals(2, adsFromSearcher.size());
		verify(mockDao);
	}

	@Test
	public void testByPriceAndCityWithResult() {
		resetSearchForm();

		mockedSearchResult.add(testAd2);

		String city = "City2";
		searchForm.setCityOrZip(city);

		searchForm.setMinPrice(0);
		searchForm.setMaxPrice(200);

		expect(mockDao.findAllByAddressCityIgnoreCase(city)).andReturn(
				mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(1, adsFromSearcher.size());
		verify(mockDao);
	}
	
	
	@Test
	public void testByPriceAndCityNoResult() {
		resetSearchForm();

		mockedSearchResult.add(testAd2);

		String city = "City2";
		searchForm.setCityOrZip(city);

		searchForm.setMinPrice(0);
		searchForm.setMaxPrice(100);


		expect(mockDao.findAllByAddressCityIgnoreCase(city)).andReturn(
				mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(0, adsFromSearcher.size());
		verify(mockDao);
	}
	
	@Test
	public void testByPriceAndRoomsWithResults() {
		resetSearchForm();

		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);
		mockedSearchResult.add(testAd3);

		searchForm.setMinNrOfRooms(2);
		searchForm.setMaxNrOfRooms(2);
		searchForm.setMinPrice(0);
		searchForm.setMaxPrice(200);

		expect(mockDao.findAll()).andReturn(
				mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd2, adsFromSearcher.get(0));
		assertEquals(1, adsFromSearcher.size());
		verify(mockDao);
	}
	
	@Test
	public void testByPriceAndRoomsNoResults() {
		resetSearchForm();

		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);
		mockedSearchResult.add(testAd3);

		searchForm.setMinNrOfRooms(2);
		searchForm.setMinPrice(0);
		searchForm.setMaxPrice(150);

		expect(mockDao.findAll()).andReturn(
				mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(0, adsFromSearcher.size());
		verify(mockDao);
	}
	
	@Test
	public void testByPriceAndFlatMatesWithResult() {
		resetSearchForm();

		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);
		mockedSearchResult.add(testAd3);
		
		searchForm.setMinNrOfFlatMates(2);
		searchForm.setMaxNrOfFlatMates(2);
		searchForm.setMinPrice(0);
		searchForm.setMaxPrice(300);

		expect(mockDao.findAll()).andReturn(
				mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd2, adsFromSearcher.get(0));
		assertEquals(1, adsFromSearcher.size());
		verify(mockDao);
	}
	
	@Test
	public void testByPriceAndFlatMatesNoResult() {
		resetSearchForm();

		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);
		mockedSearchResult.add(testAd3);
		
		searchForm.setMinNrOfFlatMates(2);
		searchForm.setMinPrice(0);
		searchForm.setMaxPrice(100);

		expect(mockDao.findAll()).andReturn(
				mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(0, adsFromSearcher.size());
		verify(mockDao);
	}
	
	@Test
	public void testByCityAndPriceAndFlatMatesWithResult() {
		resetSearchForm();

		mockedSearchResult.add(testAd3);
		
		String city = "City3";
		searchForm.setCityOrZip(city);
		searchForm.setMinNrOfFlatMates(3);
		searchForm.setMaxNrOfFlatMates(3);
		searchForm.setMinPrice(0);
		searchForm.setMaxPrice(300);

		expect(mockDao.findAllByAddressCityIgnoreCase(city)).andReturn(
				mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(1, adsFromSearcher.size());
		verify(mockDao);
	}
	
	@Test
	public void testByCityAndPriceAndFlatMatesNoResult() {
		resetSearchForm();

		mockedSearchResult.add(testAd3);
		
		String city = "City3";
		searchForm.setCityOrZip(city);
		searchForm.setMinNrOfFlatMates(2);
		searchForm.setMinPrice(0);
		searchForm.setMaxPrice(300);

		expect(mockDao.findAllByAddressCityIgnoreCase(city)).andReturn(
				mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(0, adsFromSearcher.size());
		verify(mockDao);
	}
	
	@Test
	public void testByAvialableDateRangeOneAds() {
		resetSearchForm();

		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);
		mockedSearchResult.add(testAd3);
		
		searchForm.setAvailableDate("01-02-2012");

		expect(mockDao.findAll()).andReturn(
				mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd3, adsFromSearcher.get(0));

		assertEquals(1, adsFromSearcher.size());
		verify(mockDao);
	}
	
	@Test
	public void testByAvialableDateRangeThreeAds() {
		resetSearchForm();

		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);
		mockedSearchResult.add(testAd3);
		
		searchForm.setAvailableDate("01-01-2011");

		expect(mockDao.findAll()).andReturn(
				mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(3, adsFromSearcher.size());
		verify(mockDao);
	}
	

	private void resetSearchForm() {
		searchForm.setCityOrZip("");
		searchForm.setMaxPrice(0);
		searchForm.setMinPrice(0);
		searchForm.setMinNrOfFlatMates(0);
		searchForm.setMaxNrOfFlatMates(0);
		searchForm.setAvailableDate("");
		searchForm.setOrderBy("newestFirst");

	}
}
