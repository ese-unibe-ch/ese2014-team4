package ch.unibe.ese2014.team4.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.unibe.ese2014.team4.controller.pojos.SearchForm;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.model.Ad;

/**
 * Controls all pages / commands concerning ads.
 */

@Controller
public class SearchController {

	@Autowired
	AdService adService;

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@Valid SearchForm searchForm,
			BindingResult result, RedirectAttributes redirectAttributes) {
		ArrayList<Ad> adsToAdd = new ArrayList<Ad>();
		ModelAndView model = new ModelAndView("search-result");
		java.util.List<Ad> adsByCity = adService.getAdByCity(searchForm.getCity().trim().toLowerCase());
		adsToAdd = getRelevantAds(searchForm.getMinPrice(), searchForm.getMaxPrice(), adsByCity);

		model.addObject("adsToAdd", adsToAdd);
		return model;
	}
//useful to create queries: http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
	private ArrayList<Ad> getRelevantAds(int minPrice, int maxPrice, List<Ad> adsByCity) {
		ArrayList<Ad> tempAds = new ArrayList<Ad>();
		for (Ad ad: adsByCity){
			if ((minPrice <= ad.getPrice()) && (ad.getPrice() <= maxPrice))
				tempAds.add(ad);
		}
		return tempAds;
	}

}