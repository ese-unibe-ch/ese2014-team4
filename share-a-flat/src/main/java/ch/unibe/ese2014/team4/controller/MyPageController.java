package ch.unibe.ese2014.team4.controller;

import java.security.Principal;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.exceptions.ProfileException;
import ch.unibe.ese2014.team4.controller.pojos.ProfileForm;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.controller.service.NewAccountService;
import ch.unibe.ese2014.team4.controller.service.ProfileService;
import ch.unibe.ese2014.team4.model.Profile;
import ch.unibe.ese2014.team4.model.User;
/**
 * Controls Elements of MyPage and Profile
 *
 */
@Controller
public class MyPageController {

	@Autowired
	UserService myPageService;
	@Autowired
	ProfileService profileService;
	@Autowired
	UserService userService;
	@Autowired
	AdService adService;


	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public ModelAndView myPage(Principal principal)throws ProfileException {
		ModelAndView model = new ModelAndView("myPage");
		User user=userService.getUserByUsername(principal.getName());
		model.addObject("user", user);
		model.addObject("adList", adService.getBookmarkedAds(user.getBookmarks()));
		return model;
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profile(Principal principal)throws ProfileException {
		ModelAndView model = new ModelAndView("profile");


		return model;
	}
	
	@RequestMapping(value = "/modifyProfile", method = RequestMethod.GET)
	public ModelAndView modifyProfile(Principal principal) throws ProfileException {
		ModelAndView model = new ModelAndView("modifyProfile");
		ProfileForm profileForm = new ProfileForm();
		model.addObject("profileForm", profileForm);
		model.addObject("user", userService.getUserByUsername(principal.getName()));
		return model;
	}


	@RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
	public ModelAndView saveProfile(ProfileForm profileForm, BindingResult result, Principal principal) throws Exception {
		ModelAndView model;
		if (!result.hasErrors()){
				profileService.updateProfileFrom(profileForm, userService.getUserByUsername(principal.getName())); 
				return myPage(principal);

		}
		else {model = new ModelAndView("myPage");}
		return model;
		
	}	
	@RequestMapping(value = "/deleteProfile", method = RequestMethod.POST)
	public ModelAndView deleteProfile(Principal principal) throws ProfileException {
		return null;
	}

	
}