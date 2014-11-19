package ch.unibe.ese2014.team4.controller.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.unibe.ese2014.team4.controller.pojos.AdType;
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

	private SearchForm searchForm = new SearchForm();

	@Autowired
	private AdService adService;

	/**
	 * checks if a city name or a zipcode or nothing has been put in the search
	 * then gets the list of ads from data base and send it on to be checked
	 * according to the other search parameters
	 * 
	 * @throws ParseException
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
	 * checks which search-fields have been filled accordingly sends the list to
	 * help methods to remove irrelevant ads
	 * 
	 * @param adsToSort
	 *            list of ads from data base
	 * @return list of ads according to the search parameters
	 * @throws ParseException
	 */
	private ArrayList<Ad> getRelevantAds(ArrayList<Ad> adsToSort) {

		if (searchForm.getMinPrice() != 0 || searchForm.getMaxPrice() != 0) {
			checkPrice(adsToSort);
		}

		if (searchForm.getNrOfFlatMates() != 0) {
			checkNrFlatMates(adsToSort);
		}

		if (searchForm.getNrOfRooms() != 0) {
			checkNrRooms(adsToSort);
		}

		if (searchForm.getAdType() != null) {
			checkType(adsToSort);
		}

		if (searchForm.getAvailableDate() != null) {
			checkAvailableDate(adsToSort);
		}

		return adsToSort;
	}

	private void checkAvailableDate(ArrayList<Ad> adsToSort) {
		ArrayList<Ad> adsToSortCopy = new ArrayList<Ad>();
		for (Ad ad : adsToSort)
			adsToSortCopy.add(ad);

		for (Ad ad : adsToSortCopy)
			try {
				{
					if ((convertStringToDate(searchForm.getAvailableDate()))
							.compareTo(ad.getAvailableDate()) < 0)
						adsToSort.remove(ad);
				}
			} catch (ParseException e) {
				e.printStackTrace();

			}

	}

	private Date convertStringToDate(String str) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;

		try {
			date = formatter.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	private void checkPrice(ArrayList<Ad> adsToSort) {
		ArrayList<Ad> adsToSortCopy = new ArrayList<Ad>();
		for (Ad ad : adsToSort)
			adsToSortCopy.add(ad);

		// for (Ad ad : adsToSortCopy) {
		// if (searchForm.getMinPrice() > ad.getPrice()
		// || searchForm.getMaxPrice() < ad.getPrice())
		// adsToSort.remove(ad);
		// }

		for (Ad ad : adsToSortCopy) {
			if (searchForm.getMinPrice() > ad.getBrutto()
					|| searchForm.getMaxPrice() < ad.getBrutto())
				adsToSort.remove(ad);
		}
	}

	private void checkNrFlatMates(ArrayList<Ad> adsToSort) {
		ArrayList<Ad> adsToSortCopy = new ArrayList<Ad>();
		for (Ad ad : adsToSort)
			adsToSortCopy.add(ad);

		for (Ad ad : adsToSortCopy) {
			if (searchForm.getNrOfFlatMates() != ad.getNrOfFlatMate())
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

	private void checkType(ArrayList<Ad> adsToSort) {
		ArrayList<Ad> adsToSortCopy = new ArrayList<Ad>();
		for (Ad ad : adsToSort)
			adsToSortCopy.add(ad);

		for (Ad ad : adsToSortCopy) {
			if (searchForm.getAdType() == AdType.ROOM) {
				if (ad.getType() != AdType.ROOM)
					adsToSort.remove(ad);
			} else if (searchForm.getAdType() == AdType.FLAT) {
				if (ad.getType() != AdType.FLAT)
					adsToSort.remove(ad);
			}
		}
	}

	/**
	 * checks if the input was a city name or a zip code if zip code - parse it
	 * to int
	 * 
	 * @param city
	 *            the user input in search-field "city or zip"
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

	@Autowired
	EntityManagerFactory factory;

	/**
	 * next-generation search.
	 */
	public ArrayList<Ad> getAdList2(SearchForm sf) {
		String queryString = "";
		Query query = factory.createEntityManager().createQuery(queryString);

		return null;
	}
}
