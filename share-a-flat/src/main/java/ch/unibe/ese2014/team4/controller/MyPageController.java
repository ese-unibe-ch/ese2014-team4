package ch.unibe.ese2014.team4.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.exceptions.ProfileException;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.SearchService;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.controller.service.ProfileService;
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
	@Autowired
	SearchService searchService;


	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public ModelAndView myPage(Principal principal)throws ProfileException {
		ModelAndView model = new ModelAndView("myPage");
		try{
			User user=userService.getUserByUsername(principal.getName());
			model.addObject("user", user);
			model.addObject("mySearchList", searchService.getMySavedSearchForms(user));
			model.addObject("adList", adService.getBookmarkedAds(user.getBookmarks()));
			//used for myAds and myVisitors
			model.addObject("myAdsList", adService.getAdsOfUserByUser(user));
			model.addObject("myVisitsList", adService.getVisitsUserRegistered(user));
		}
		catch(InvalidUserException e){
			
		}
			
		
		return model;
	}

	



	
}