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
import ch.unibe.ese2014.team4.controller.exceptions.ProfileException;
import ch.unibe.ese2014.team4.controller.pojos.ProfileForm;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.service.AccountService;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.ProfileService;
import ch.unibe.ese2014.team4.controller.service.SearchService;
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
public class ProfileController {
	@Autowired
	UserService myPageService;
	@Autowired
	ProfileService profileService;
	@Autowired
	UserService userService;
	@Autowired
	AdService adService;
	@Autowired
	SearchService searchService;


	/**
	 * Used to display others profile.
	 * @param profileId
	 * @param principal
	 * @return
	 * @throws ProfileException
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView showProfile(@RequestParam(value="userId") Long userId) throws InvalidUserException{
		ModelAndView model = new ModelAndView("showProfile");
		try{
			model.addObject("user", userService.getUser(userId));
		}
		catch(InvalidUserException e){
			model.addObject("errorMessage", e.getMessage());
		}
			return model;
	}
	/**
	 * shows myProfile
	 */
	@RequestMapping(value = "/myProfile", method = RequestMethod.GET)
	public ModelAndView showMyProfile(Principal principal) throws InvalidUserException{
		ModelAndView model = new ModelAndView("myProfile");
		try{
			model.addObject("user", userService.getUserByUsername(principal.getName()));
		}
		catch(InvalidUserException e){
			model.addObject("errorMessage", e.getMessage());
		}
			return model;
	}
	@RequestMapping(value = "/modifyProfile", method = RequestMethod.GET)
	public ModelAndView modifyProfile(Principal principal) throws InvalidUserException {
		ModelAndView model = new ModelAndView("modifyProfile");
		model.addObject("profileForm",  new ProfileForm());
		model.addObject("user", userService.getUserByUsername(principal.getName()));
		return model;
	}


	@RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
	public ModelAndView saveProfile(ProfileForm profileForm, BindingResult result, Principal principal) throws Exception {
		ModelAndView model;
		User user = userService.getUserByUsername(principal.getName());
		if (!result.hasErrors()){
			if(userService.isPasswordCorrect(profileForm.getOldPassword(), user)){
				profileService.updateProfileFrom(profileForm, user); 
				return showMyProfile(principal);
			}
			else{
				model = new ModelAndView("modifyProfile");
				model.addObject("profileForm",  new ProfileForm());
				model.addObject("user",user);
				model.addObject("errorMessage", "Password wrong");
			}

		}
		else {model = new ModelAndView("myPage");}
		return model;
		
	}	
}