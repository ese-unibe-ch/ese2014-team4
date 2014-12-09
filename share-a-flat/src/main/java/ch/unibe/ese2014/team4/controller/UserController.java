package ch.unibe.ese2014.team4.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;

import ch.unibe.ese2014.team4.controller.pojos.ProfileForm;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.SearchService;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.model.User;


/**
 *Controlls user-related pages(profiles).
 *
 */
@Controller
public class UserController {
	@Autowired
	UserService myPageService;

	@Autowired
	UserService userService;
	@Autowired
	AdService adService;
	@Autowired
	SearchService searchService;


	/**
	 * Used to display the profile profile of user with userId.
	 * @param profileId
	 * @param principal
	 * @return
	 * @throws ProfileException
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView showProfile(@RequestParam(value="userId") Long userId, Principal principal) throws InvalidUserException{
		ModelAndView model = new ModelAndView("showProfile");
		try{
			User userProfile = userService.getUser(userId); //profile to be shown
			User user = userService.getUserByUsername(principal.getName()); //currently active user
			model.addObject("user", user);
			model.addObject("userProfile", userProfile);

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
			User user = userService.getUserByUsername(principal.getName()); //currently active user
			model.addObject("user", user);
			model.addObject("userProfile", user);
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
		if (!result.hasErrors()) {
			if(profileForm.getPassword().equals("") || userService.isPasswordCorrect(profileForm.getOldPassword(), user)){
				userService.updateUserFrom(profileForm, user); 
				return showMyProfile(principal);
			}
			else {
				model = new ModelAndView("modifyProfile");
				model.addObject("profileForm", new ProfileForm());
				model.addObject("user", user);
				model.addObject("errorMessage", "Password wrong");
			}			
		}
		else {
			model = new ModelAndView("myPage");
		}
		
		return model;	
	}	
}