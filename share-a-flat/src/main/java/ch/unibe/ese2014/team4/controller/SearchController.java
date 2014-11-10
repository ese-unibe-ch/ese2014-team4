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
import ch.unibe.ese2014.team4.model.ISearcher;
import ch.unibe.ese2014.team4.model.SearcherDefaultCity;

/**
 * Controls all pages / commands concerning ads.
 */

@Controller
public class SearchController {
	
	ISearcher searcher;

	@Autowired
	AdService adService;

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@Valid SearchForm searchForm,
			BindingResult result, RedirectAttributes redirectAttributes) {
		ModelAndView model = null;
		ArrayList<Ad> adsToAdd = new ArrayList<Ad>();
		searcher = new SearcherDefaultCity(searchForm, adService);
		adsToAdd = searcher.getAdList();
		if (!adsToAdd.isEmpty()){
		model = new ModelAndView("search-result");
		model.addObject("adsToAdd", adsToAdd);
		}
		else
			model = new ModelAndView("empty-search-result");
		return model;
	}


}