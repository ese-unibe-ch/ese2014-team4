package ch.unibe.ese2014.team4.controller;

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
		ModelAndView model = new ModelAndView("search-result");
//		java.util.List<Ad> ads = adService.getAd(searchForm.getPrice());
		model.addObject("ads", adService.getAd(searchForm.getPrice()));

		return model;
	}

}