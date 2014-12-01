package ch.unibe.ese2014.team4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.AccountService;

@Controller
public class TabBarController {

	
	@Autowired
	AdService adService;

	@RequestMapping(value = "/favorites", method = RequestMethod.GET)
	public ModelAndView favorites() {
		ModelAndView model = new ModelAndView("favorites");
		return model;
	}




}
