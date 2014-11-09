package ch.unibe.ese2014.team4.model;

import java.util.ArrayList;
import java.util.List;

import ch.unibe.ese2014.team4.controller.pojos.SearchForm;
import ch.unibe.ese2014.team4.controller.service.AdService;

public class SearcherDefaultCity implements ISearcher {

	private SearchForm searchForm;
	private AdService adService;

	public SearcherDefaultCity(SearchForm _searchForm, AdService _adService) {
		searchForm = _searchForm;
		adService = _adService;
	}

	public ArrayList<Ad> getAdList() {

		java.util.List<Ad> adsByCity = adService.getAdByCity(searchForm
				.getCity().trim().toLowerCase());
		ArrayList<Ad> adsToAdd = getRelevantAds(adsByCity);
		return adsToAdd;
	}

	// useful to create queries:
	// http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
	private ArrayList<Ad> getRelevantAds(List<Ad> adsByCity) {
		ArrayList<Ad> tempAds = new ArrayList<Ad>();
		checkPrice(adsByCity, tempAds);
		checkZip(adsByCity, tempAds);
		checkNrRoomMates(adsByCity, tempAds);
		return tempAds;
	}

	private void checkNrRoomMates(List<Ad> adsByCity, ArrayList<Ad> tempAds) {
		for (Ad ad : adsByCity) {
			if ((searchForm.getNrOfRoomMates() == ad.getNrOfRoomMates() || searchForm
					.getNrOfRoomMates() == 0))
				tempAds.add(ad);
		}
	}

	private void checkZip(List<Ad> adsByCity, ArrayList<Ad> tempAds) {
		for (Ad ad : adsByCity) {
			if ((searchForm.getZipCode() == ad.getAddress().getZipCode())||searchForm.getZipCode()==0)
				tempAds.add(ad);
		}
	}

	private void checkPrice(List<Ad> adsByCity, ArrayList<Ad> tempAds) {
		for (Ad ad : adsByCity) {
			if ((searchForm.getMinPrice() <= ad.getPrice())
					&& (ad.getPrice() <= searchForm.getMaxPrice())
					&& searchForm.getMaxPrice() != 0)
				tempAds.add(ad);
		}
	}

}
