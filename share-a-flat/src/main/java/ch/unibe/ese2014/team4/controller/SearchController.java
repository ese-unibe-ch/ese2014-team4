package ch.unibe.ese2014.team4.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.unibe.ese2014.team4.controller.pojos.SearchForm;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.SearchService;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.Address;
import ch.unibe.ese2014.team4.model.MapAddress;

/**
 * Controls all pages / commands concerning ads.
 */

@Controller
public class SearchController {

	@Autowired
	SearchService searcher;

	@Autowired
	AdService adService;

	// simplify both search-methods, remove common stuff

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchOverview(
			@RequestParam(value = "resultType", required = false) String resultType) {
		ModelAndView model = new ModelAndView("search");
		model.addObject("searchForm", new SearchForm());
		ArrayList<Ad> newestAdds = adService.getNewestAds();
		model.addObject("adList", newestAdds);
		model.addObject("resultType", resultType);
		model.addObject("whatToDisplay", "Newest Ads");
		ArrayList<MapAddress> addresses = getAddressesForMap(newestAdds);	
		model.addObject("addresses", addresses);
		return model;
	}

	@RequestMapping(value = "/submitSearch", method = RequestMethod.POST)
	public ModelAndView search(
			@Valid SearchForm searchForm,
			BindingResult result,
			@RequestParam(value = "resultType", required = true) String resultType) {
		ModelAndView model = new ModelAndView("search");
		ArrayList<Ad> adsToAdd = new ArrayList<Ad>();

		adsToAdd = searcher.getAdList(searchForm);
		if (!adsToAdd.isEmpty()) {
			model.addObject("adList", adsToAdd);
			model.addObject("whatToDisplay", "Search Results");
			model.addObject("resultType", resultType);
			ArrayList<MapAddress> addresses = getAddressesForMap(adsToAdd);	
			model.addObject("addresses", addresses);
		} else
			model.addObject("whatToDisplay", "No Ads found");
		model.addObject("resultType", resultType);
		
		return model;
	}

	@RequestMapping(value = "/getMap", method = RequestMethod.GET)
	public ModelAndView getMap() {
		ModelAndView model = new ModelAndView("searchResultsMapLocation");	
		ArrayList<Ad> newestAdds = adService.getNewestAds();
		ArrayList<MapAddress> addresses = getAddressesForMap(newestAdds);	
		model.addObject("addresses", addresses);
		
		return model;
	}

	private ArrayList<MapAddress> getAddressesForMap(ArrayList<Ad> ads) {
		ArrayList<MapAddress> addresses = new ArrayList<MapAddress>();
		for (Ad ad : ads) {
			MapAddress tmpMapAddress = ad.getAddressForMap();
			addresses.add(tmpMapAddress);
		}
		return addresses;
	}
}