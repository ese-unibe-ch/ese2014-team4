package ch.unibe.ese2014.team4.controller.service;

import java.util.ArrayList;
import java.util.List;

import ch.unibe.ese2014.team4.controller.pojos.SearchForm;
import ch.unibe.ese2014.team4.model.Ad;

/**
 * 
 * @author team4 get a list of ads from data base and sort is out according to
 *         the search criteria
 *
 */
public class SearcherDefaultCity implements ISearcher {

	private SearchForm searchForm;
	private AdService adService;

	public SearcherDefaultCity(SearchForm _searchForm, AdService _adService) {
		searchForm = _searchForm;
		adService = _adService;

	}

	/**
	 * checks if a city name or a zipcode or nothing has been put in the search
	 * according gets a list of ads from data base and send it on to be checked
	 * according to the other search parameters
	 */
	public ArrayList<Ad> getAdList() {
		int zip = 0;
		ArrayList<Ad> adsToSort = new ArrayList<Ad>();
		zip = parseCityZip(searchForm.getCity());
		if (zip > 0) {
			adsToSort = adService.getAdByZip(searchForm.getZipCode());
		} else {
			if (searchForm.getCity() != "") {
				adsToSort = adService.getAdByCity(searchForm.getCity());
			} else {
				adsToSort = adService.getAll();
			}
		}
		return getRelevantAds(adsToSort);
	}

	// useful to create queries:
	// http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
	private ArrayList<Ad> getRelevantAds(ArrayList<Ad> adsToSort) {

		if (searchForm.getMinPrice() != 0 || searchForm.getMaxPrice() != 0) {
			checkPrice(adsToSort);
		}
		if (searchForm.getNrOfRoomMates() != 0) {
			checkNrRoomMates(adsToSort);
		}
		return adsToSort;
	}

	private void checkPrice(List<Ad> adsToSort) {
		for (Ad ad : adsToSort) {
			if (searchForm.getMinPrice() > ad.getPrice()
					|| searchForm.getMaxPrice() < ad.getPrice())
				adsToSort.remove(ad);
		}
	}

	private void checkNrRoomMates(ArrayList<Ad> adsToSort) {
		for (Ad ad : adsToSort) {
			if ((searchForm.getNrOfRoomMates() != ad.getNrOfRoomMates() && searchForm
					.getNrOfRoomMates() != 0))
				adsToSort.remove(ad);
		}
	}

	private int parseCityZip(String city) {
		int zip;
		try {
			zip = Integer.parseInt(city);
		} catch (NumberFormatException e) {
			return 0;
		}
		return zip;
	}
}
