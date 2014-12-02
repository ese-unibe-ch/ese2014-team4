package ch.unibe.ese2014.team4.Tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.*;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.AdServiceImpl;
import ch.unibe.ese2014.team4.controller.service.SearchServiceImpl;
import ch.unibe.ese2014.team4.model.*;

import ch.unibe.ese2014.team4.model.dao.AdDao;

public class OrderTests {

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

		testAddess1.setCity("City1");

		testAddess1.setZipCode(1111);

		testAd1.setAddress(testAddess1);
		testAd2.setAddress(testAddess1);
		testAd3.setAddress(testAddess1);

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
		testAd3.setNrOfRooms(3);

		testAd1.setAvailableDate("01-01-2011");
		testAd2.setAvailableDate("01-01-2012");
		testAd3.setAvailableDate("01-01-2013");
	}

	@Test
	public void testByCityWithPriceSort() {
		resetSearchForm();

		mockedSearchResult.add(testAd3);
		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);

		String city = "City1";
		searchForm.setCityOrZip(city);
		searchForm.setOrderBy("price");

		expect(mockDao.findAllByAddressCityOrderByBruttoAsc(city)).andReturn(
				mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd1.getId(), adsFromSearcher.get(0).getId());
		assertEquals(testAd2.getId(), adsFromSearcher.get(1).getId());
		assertEquals(testAd3.getId(), adsFromSearcher.get(2).getId());
		verify(mockDao);
	}

	@Test
	public void testByCityWithPriceSortDifferentOrder() {
		resetSearchForm();

		testAd1.setNetto(400);
		testAd1.setCharges(0);
		testAd1.setBrutto();

		mockedSearchResult.add(testAd3);
		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);

		String city = "City1";
		searchForm.setCityOrZip(city);
		searchForm.setOrderBy("price");

		expect(mockDao.findAllByAddressCityOrderByBruttoAsc(city)).andReturn(
				mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd2.getId(), adsFromSearcher.get(0).getId());
		assertEquals(testAd3.getId(), adsFromSearcher.get(1).getId());
		assertEquals(testAd1.getId(), adsFromSearcher.get(2).getId());
		verify(mockDao);
	}

	@Test
	public void testByCityWithAvailableDateSort() {
		resetSearchForm();

		mockedSearchResult.add(testAd3);
		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);

		String city = "City1";
		searchForm.setCityOrZip(city);
		searchForm.setOrderBy("availableDate");

		expect(
				mockDao.findAllByAddressCityIgnoreCaseOrderByAvailableDateDesc(city))
				.andReturn(mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd1.getId(), adsFromSearcher.get(0).getId());
		assertEquals(testAd2.getId(), adsFromSearcher.get(1).getId());
		assertEquals(testAd3.getId(), adsFromSearcher.get(2).getId());
		verify(mockDao);
	}

	@Test
	public void testByCityWithAvailableDateSortDifferentOrder() {
		resetSearchForm();

		testAd1.setAvailableDate("01-01-2014");

		mockedSearchResult.add(testAd3);
		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);

		String city = "City1";
		searchForm.setCityOrZip(city);
		searchForm.setOrderBy("availableDate");

		expect(
				mockDao.findAllByAddressCityIgnoreCaseOrderByAvailableDateDesc(city))
				.andReturn(mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd2.getId(), adsFromSearcher.get(0).getId());
		assertEquals(testAd3.getId(), adsFromSearcher.get(1).getId());
		assertEquals(testAd1.getId(), adsFromSearcher.get(2).getId());
		verify(mockDao);
	}

	@Test
	public void testByZipWithPriceSort() {
		resetSearchForm();

		mockedSearchResult.add(testAd3);
		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);

		String city = "1111";
		searchForm.setCityOrZip(city);
		searchForm.setOrderBy("price");

		expect(mockDao.findAllByAddressZipCodeOrderByBruttoAsc(1111))
				.andReturn(mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd1.getId(), adsFromSearcher.get(0).getId());
		assertEquals(testAd2.getId(), adsFromSearcher.get(1).getId());
		assertEquals(testAd3.getId(), adsFromSearcher.get(2).getId());
		verify(mockDao);
	}

	@Test
	public void testByZipWithPriceSortDifferentOrder() {
		resetSearchForm();

		testAd1.setNetto(400);
		testAd1.setCharges(0);
		testAd1.setBrutto();

		mockedSearchResult.add(testAd3);
		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);

		String city = "1111";
		searchForm.setCityOrZip(city);
		searchForm.setOrderBy("price");

		expect(mockDao.findAllByAddressZipCodeOrderByBruttoAsc(1111))
				.andReturn(mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd2.getId(), adsFromSearcher.get(0).getId());
		assertEquals(testAd3.getId(), adsFromSearcher.get(1).getId());
		assertEquals(testAd1.getId(), adsFromSearcher.get(2).getId());
		verify(mockDao);
	}
	
	@Test
	public void testByZipWithAvailableDateSort() {
		resetSearchForm();

		mockedSearchResult.add(testAd3);
		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);

		String city = "1111";
		searchForm.setCityOrZip(city);
		searchForm.setOrderBy("availableDate");

		expect(
				mockDao.findAllByAddressZipCodeOrderByAvailableDateDesc(1111))
				.andReturn(mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd1.getId(), adsFromSearcher.get(0).getId());
		assertEquals(testAd2.getId(), adsFromSearcher.get(1).getId());
		assertEquals(testAd3.getId(), adsFromSearcher.get(2).getId());
		verify(mockDao);
	}

	@Test
	public void testByZipWithAvailableDateSortDifferentOrder() {
		resetSearchForm();

		testAd1.setAvailableDate("01-01-2014");

		mockedSearchResult.add(testAd3);
		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);

		String city = "1111";
		searchForm.setCityOrZip(city);
		searchForm.setOrderBy("availableDate");

		expect(
				mockDao.findAllByAddressZipCodeOrderByAvailableDateDesc(1111))
				.andReturn(mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd2.getId(), adsFromSearcher.get(0).getId());
		assertEquals(testAd3.getId(), adsFromSearcher.get(1).getId());
		assertEquals(testAd1.getId(), adsFromSearcher.get(2).getId());
		verify(mockDao);
	}
	
	@Test
	public void testGetAllAvailableDateSort() {
		resetSearchForm();

		mockedSearchResult.add(testAd3);
		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);
		
		searchForm.setOrderBy("availableDate");
		
		expect(
				mockDao.findAll())
				.andReturn(mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd1.getId(), adsFromSearcher.get(0).getId());
		assertEquals(testAd2.getId(), adsFromSearcher.get(1).getId());
		assertEquals(testAd3.getId(), adsFromSearcher.get(2).getId());
		verify(mockDao);
	}

	@Test
	public void testGetAllAvailableDateSortDifferentOrder() {
		resetSearchForm();

		testAd1.setAvailableDate("01-01-2014");

		mockedSearchResult.add(testAd3);
		mockedSearchResult.add(testAd1);
		mockedSearchResult.add(testAd2);
		
		searchForm.setOrderBy("availableDate");
		
		expect(
				mockDao.findAll())
				.andReturn(mockedSearchResult);

		replay(mockDao);
		ArrayList<Ad> adsFromSearcher = searcher.getAdList(searchForm);
		assertEquals(testAd2.getId(), adsFromSearcher.get(0).getId());
		assertEquals(testAd3.getId(), adsFromSearcher.get(1).getId());
		assertEquals(testAd1.getId(), adsFromSearcher.get(2).getId());
		verify(mockDao);
	}
	


	private void resetSearchForm() {
		searchForm.setCityOrZip("");
		searchForm.setMaxPrice(0);
		searchForm.setMinPrice(0);
		searchForm.setMinNrOfFlatMates(0);
		searchForm.setAvailableDate("");
		searchForm.setOrderBy("newestFirst");
	}
}
