package ch.unibe.ese2014.team4.controller;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.service.AccountService;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.model.SearchForm;
import ch.unibe.ese2014.team4.model.User;


/**
 * AccountController: Login process is routed via Spring Security. Controlls /,
 * /login (currently not needed), /createAccount: result page after account
 * creation.
 * 
 *
 */
@Controller
public class AccountController {
    @Autowired
    AccountService accountService;
    
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
	@RequestMapping(value="/validate")
	public ModelAndView getValidationForm(){
		return new ModelAndView("validate");
	}

	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public ModelAndView signIn(@Valid SignupForm signupForm,
			BindingResult result, HttpServletRequest request,
			Principal principal) {
		ModelAndView model;
		if (!result.hasErrors()) {
			try {
				accountService.saveFrom(signupForm);

				model = new ModelAndView("validate");
				
				String username = signupForm.getUsername();
				User user = userService.getUser(signupForm.getId());
				accountService.sendValidationMail(user, request.getLocalAddr());

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
	/**
	 * validation via validation link
	 * @param validationString
	 * @param userName
	 * @return
	 */	
	@RequestMapping(value="/submitValidationString", method = RequestMethod.GET)
	public ModelAndView validateAccount(@RequestParam(value="validationString") String validationString, @RequestParam(value="userName") String userName){
		User user = userService.getUserByUsername(userName);
		accountService.activateAccount(user, validationString);
		accountService.loginManually(user);
		return getSearchView(user);
	}
	/**
	 * validation via validation form
	 * @param validationString
	 * @param userName
	 * @return
	 */
	@RequestMapping(value="/submitValidationString", method = RequestMethod.POST)
	public ModelAndView validateAccount(@RequestParam(value="validationString") String validationString,Principal principal){
		User user = userService.getUserByUsername(principal.getName());
		accountService.activateAccount(user, validationString);
		return getSearchView(user);
	}
	
	private ModelAndView getSearchView(User user){
		ModelAndView model = new ModelAndView("search");
		model.addObject("whatToDisplay", "Newest Ads");

		model.addObject("user", user);
		model.addObject("searchForm", new SearchForm());
		return model;
	}
}