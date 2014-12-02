package ch.unibe.ese2014.team4.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.SearchService;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.Address;
import ch.unibe.ese2014.team4.model.MapAddress;
import ch.unibe.ese2014.team4.model.SearchForm;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.SearchFormDao;

/**
 * Controls all pages / commands concerning ads.
 */

@Controller
public class SearchController {

	@Autowired
	SearchService searchService;

	@Autowired
	AdService adService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SearchFormDao searchFormDao;

	// simplify both search-methods, remove common stuff

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchOverview() {
		ModelAndView model = new ModelAndView("search");
		model.addObject("searchForm", new SearchForm());
		ArrayList<Ad> newestAdds = adService.getNewestAds();
		model.addObject("adList", newestAdds);
		model.addObject("whatToDisplay", "Newest Ads");
		List<MapAddress> addresses = getAddressesForMap(newestAdds);	
		model.addObject("addresses", addresses);
		return model;
	}
	@RequestMapping(params = "save", value = "/submitSearch", method = RequestMethod.POST)
	public ModelAndView saveSearch(@Valid SearchForm searchForm,BindingResult result, Principal principal) {
		ModelAndView model = new ModelAndView("myPage");
		User user = userService.getUserByUsername(principal.getName());
		searchForm.setOwner(user);
		searchService.saveSearchForm(searchForm);
		model.addObject("user", user);
		model.addObject("mySearchList", searchService.getMySavedSearchForms(user));
		model.addObject("adList", adService.getBookmarkedAds(user.getBookmarks()));
		model.addObject("myAdsList", adService.getAdsOfUserByUser(user));
		return model;
	}
	/**
	 * 
	 * @param searchForm
	 * @param result
	 * @return
	 */
	@RequestMapping(params = "search", value = "/submitSearch", method = RequestMethod.POST)
	public ModelAndView search(
			@Valid SearchForm searchForm) {
		ModelAndView model = new ModelAndView("search");
		List<Ad> adsToAdd = new ArrayList<Ad>();

		adsToAdd = searchService.getAdList(searchForm);
		if (!adsToAdd.isEmpty()) {
			model.addObject("adList", adsToAdd);
			model.addObject("whatToDisplay", "Search Results");
			List<MapAddress> addresses = getAddressesForMap(adsToAdd);	
			model.addObject("addresses", addresses);
		} else
			model.addObject("whatToDisplay", "No Ads found");
		
		return model;
	}
	
	@RequestMapping(params="search", value = "/restoreSavedSearch", method = RequestMethod.POST)
	public ModelAndView startSavedSearch(@RequestParam(value="id")Long searchFormId) {
		ModelAndView model = new ModelAndView("search");
		model.addObject("searchForm", searchFormDao.findById(searchFormId));
		ArrayList<Ad> newestAdds = adService.getNewestAds();
		model.addObject("adList", newestAdds);
		model.addObject("whatToDisplay", "Newest Ads");
		List<MapAddress> addresses = getAddressesForMap(newestAdds);	
		model.addObject("addresses", addresses);
		return model;

	}
	@RequestMapping(params = "delete", value = "/restoreSavedSearch", method = RequestMethod.POST)
	public ModelAndView deleteSavedSearch(@RequestParam(value="id")Long searchFormId, Principal principal) {
		searchFormDao.delete(searchFormId);
		ModelAndView model = new ModelAndView("myPage");
		User user = userService.getUserByUsername(principal.getName());

		model.addObject("user", user);
		model.addObject("mySearchList", searchService.getMySavedSearchForms(user));
		model.addObject("adList", adService.getBookmarkedAds(user.getBookmarks()));
		model.addObject("myAdsList", adService.getAdsOfUserByUser(user));
		return model;

	}
	@RequestMapping(value = "/getMap", method = RequestMethod.GET)
	public ModelAndView getMap() {
		ModelAndView model = new ModelAndView("searchResultsMapLocation");	
		List<Ad> newestAdds = adService.getNewestAds();
		List<MapAddress> addresses = getAddressesForMap(newestAdds);	
		model.addObject("addresses", addresses);
		
		return model;
	}


	private List<MapAddress> getAddressesForMap(List<Ad> adsToAdd) {
		List<MapAddress> addresses = new ArrayList<MapAddress>();
		for (Ad ad : adsToAdd) {
			MapAddress tmpMapAddress = ad.getAddressForMap();
			addresses.add(tmpMapAddress);
		}
		return addresses;
	}
}