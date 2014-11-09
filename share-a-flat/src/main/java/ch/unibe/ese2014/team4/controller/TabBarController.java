package ch.unibe.ese2014.team4.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.SearchForm;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.service.NewAccountService;
import ch.unibe.ese2014.team4.model.User;

@Controller
public class TabBarController {

	@Autowired
	NewAccountService sampleService;

	@RequestMapping(value = "/favorites", method = RequestMethod.GET)
	public ModelAndView favorites() {
		ModelAndView model = new ModelAndView("favorites");
		return model;
	}

//	@RequestMapping(value = "/my-page", method = RequestMethod.GET)
//	public ModelAndView myPage() {
//		ModelAndView model = new ModelAndView("my-page");
//		return model;
//	}

	@RequestMapping(value = "/search-list", method = RequestMethod.GET)
	public ModelAndView searchList() {
		ModelAndView model = new ModelAndView("search-list");
		model.addObject("searchForm", new SearchForm());
		return model;
	}

	@RequestMapping(value = "/search-map", method = RequestMethod.GET)
	public ModelAndView searchMap() {
		ModelAndView model = new ModelAndView("search-map");
		return model;
	}
	
	
	@RequestMapping(value = "/security-error", method = RequestMethod.GET)
	public String securityError(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("page_error",
				"You do have have permission to do that!");
		return "redirect:/";
	}

}
