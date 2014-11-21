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

/**
 * Controls all pages / commands concerning ads.
 */

@Controller
public class SearchController {
	
	@Autowired
	SearchService searcher;

	@Autowired
	AdService adService;
	//simplify both search-methods, remove common stuff
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchOverview( @RequestParam(value = "resultType", required=false) String resultType) {
		ModelAndView model = new ModelAndView("search");
		model.addObject("searchForm", new SearchForm());
		ArrayList<Ad> newestAdds = adService.getNewestAds();
		model.addObject("addList", newestAdds);
		model.addObject("resultType", resultType);
		return model;
	}


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@Valid SearchForm searchForm,
			BindingResult result,  @RequestParam(value = "resultType", required=true) String resultType) {
		ModelAndView model = new ModelAndView("search");
		ArrayList<Ad> adsToAdd = new ArrayList<Ad>();

		adsToAdd = searcher.getAdList(searchForm);
		if (!adsToAdd.isEmpty()){
			model.addObject("addList", adsToAdd);
			model.addObject("whatToDisplay", "Search Results");
			model.addObject("resultType", resultType);
		}
		else
			model.addObject("whatToDisplay", "No Ads found");
		model.addObject("resultType", resultType);
		
		return model;
	}
	
}