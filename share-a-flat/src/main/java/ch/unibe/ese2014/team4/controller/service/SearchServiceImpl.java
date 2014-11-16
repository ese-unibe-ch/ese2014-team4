package ch.unibe.ese2014.team4.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.unibe.ese2014.team4.controller.pojos.SearchForm;
import ch.unibe.ese2014.team4.model.Ad;

/**
 * 
 * @author team4 get a list of ads from data base and sort is out according to
 *         the search criteria
 *
 */
@Service
public class SearchServiceImpl implements SearchService {

	private SearchForm searchForm;
	
	@Autowired
	private AdService adService;


	/**
	 * checks if a city name or a zipcode or nothing has been put in the search
	 * then gets the list of ads from data base and send it on to be checked
	 * according to the other search parameters
	 */
	public ArrayList<Ad> getAdList(SearchForm sf) {
		this.searchForm = sf;

		int zip = 0;
		ArrayList<Ad> adsToSort = new ArrayList<Ad>();
		zip = parseCityZip(searchForm.getCityOrZip());
		
		if (zip > 0) {
			adsToSort = adService.getAdByZip(zip);
		} else {
			if (searchForm.getCityOrZip() != "") {
				adsToSort = adService.getAdByCity(searchForm.getCityOrZip());
			} else {
				adsToSort = adService.getAllAds();
			}
		}
		return getRelevantAds(adsToSort);
	}

	/**
	 * checks which search-fields have been filled
	 * accordingly sends the list to help methods to remove irrelevant ads
	 * @param adsToSort list of ads from data base 
	 * @return list of ads according to the search parameters
	 */
	private ArrayList<Ad> getRelevantAds(ArrayList<Ad> adsToSort) {

		if (searchForm.getMinPrice() != 0 || searchForm.getMaxPrice() != 0) {
			checkPrice(adsToSort);
		}
		if (searchForm.getNrOfFlatMates() != 0) {
			checkNrFlatMates(adsToSort);
		}
		
		if (searchForm.getNrOfRooms()!=0)
			checkNrRooms(adsToSort);
		
		return adsToSort;
	}

	
	private void checkPrice(ArrayList<Ad> adsToSort) {
		ArrayList<Ad> adsToSortCopy = new ArrayList<Ad>();
		for (Ad ad : adsToSort)
			adsToSortCopy.add(ad);
		
		for (Ad ad : adsToSortCopy) {
			if (searchForm.getMinPrice() > ad.getPrice()
					|| searchForm.getMaxPrice() < ad.getPrice())
				adsToSort.remove(ad);
		}
	}

	private void checkNrFlatMates(ArrayList<Ad> adsToSort) {
		ArrayList<Ad> adsToSortCopy = new ArrayList<Ad>();
		for (Ad ad : adsToSort)
			adsToSortCopy.add(ad);
		
		for (Ad ad : adsToSortCopy) {
			if (searchForm.getNrOfFlatMates() != ad.getNrOfFlatMates())
				adsToSort.remove(ad);
		}
	}
	
	private void checkNrRooms(ArrayList<Ad> adsToSort) {
		ArrayList<Ad> adsToSortCopy = new ArrayList<Ad>();
		for (Ad ad : adsToSort)
			adsToSortCopy.add(ad);
		
		for (Ad ad : adsToSortCopy) {
			if (searchForm.getNrOfRooms() != ad.getNrOfRooms())
				adsToSort.remove(ad);
		}		
	}

/**
 * checks if the input was a city name or a zip code
 * if zip code - parse it to int
 * @param city the user input in search-field "city or zip"
 * @return 0 if it wasn't a number. Else a zipcode
 */
	private int parseCityZip(String city) {
		int zip;
		try {
			zip = Integer.parseInt(city);
		} catch (NumberFormatException e) {
			return 0;
		}
		return zip;
	}

	public void setAdService(AdService as) {
		this.adService = as;
		
	}
}
