package ch.unibe.ese2014.team4.controller;


import java.security.Principal;

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
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.model.User;


/**
 * LoginController: Login process is routed via Spring Security. Controlls /,
 * /login (currently not needed), /createAccount: result page after account
 * creation.
 * 
 *
 */
@Controller
public class LoginController {
    @Autowired
    NewAccountService newAccountService;
    
    @Autowired
    UserService userService;
    


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("register");
		model.addObject("signupForm", new SignupForm());
		return model;
	}


	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public ModelAndView signIn(@Valid SignupForm signupForm,
			BindingResult result, RedirectAttributes redirectAttributes,
			Principal principal) {
		ModelAndView model;
		if (!result.hasErrors()) {
			try {
				newAccountService.saveFrom(signupForm);
				model = new ModelAndView("myPage");
				String username = signupForm.getUsername();
				 User user = userService.getUser(signupForm.getId());
				 newAccountService.loginManually(user);
				model.addObject("username", username);
				model.addObject("user", user);
				model.addObject("searchForm", new SearchForm());
			} catch (InvalidUserException e) {

				model = new ModelAndView("register");
				model.addObject("signupForm", new SignupForm());
				model.addObject("page_error", e.getMessage());
				return model;
			}
		} else {
			model = new ModelAndView("index");
		}
		return model;
	}

}