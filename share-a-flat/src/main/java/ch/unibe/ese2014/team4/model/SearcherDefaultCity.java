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
		ArrayList<Ad> adsToAdd = getRelevantAds(searchForm.getMinPrice(),
				searchForm.getMaxPrice(), adsByCity);
		return adsToAdd;
	}
	
	//useful to create queries: http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
		private ArrayList<Ad> getRelevantAds(int minPrice, int maxPrice, List<Ad> adsByCity) {
			ArrayList<Ad> tempAds = new ArrayList<Ad>();
			for (Ad ad: adsByCity){
				if ((minPrice <= ad.getPrice()) && (ad.getPrice() <= maxPrice) && maxPrice!=0)
					tempAds.add(ad);
			}
			return tempAds;
		}

}
