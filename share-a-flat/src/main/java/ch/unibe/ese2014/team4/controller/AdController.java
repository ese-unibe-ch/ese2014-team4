package ch.unibe.ese2014.team4.controller;

import java.security.Principal;


import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.MessageForm;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.SearchService;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.controller.service.ZipCityService;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.User;



/**
 * Controls all pages / commands concerning ads, including the creation,
 * submission and showing ads.
 */
@Controller
public class AdController {

	@Autowired
	AdService adService;

	@Autowired
	UserService userService;
	
	@Autowired
	SearchService searchService;
	
	@Autowired
	ZipCityService zipCityService;

	
	@RequestMapping(value = "/createAd", method = RequestMethod.GET)
	public ModelAndView createAd(Principal principal) {
		
		ModelAndView model = new ModelAndView("create-ad");
		model.addObject("adCreationOrModification", "New Ad");
		model.addObject("zipCityAsArray", zipCityService.getZipCityAsList());
		model.addObject("adForm", new AdForm());
		model.addObject("user", userService.getUserByUsername(principal.getName()));

		return model;
	}

	/**
	 * Controls submission of newly created ad.
	 * 
	 * @param adForm
	 * @param result
	 * @param principal
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/submitAd", method = RequestMethod.POST)
	public ModelAndView submitAd(AdForm adForm, BindingResult result,
			Principal principal) throws Exception {
		try{
			adService.saveAdForm(adForm,
					userService.getUserByUsername(principal.getName()));
			return showAd(adForm.getId(), principal);
		}
		
		catch (ConstraintViolationException e) {
			ModelAndView model = new ModelAndView("create-ad");
			model.addObject("zipCityAsArray", zipCityService.getZipCityAsList());
			model.addObject("adForm", adForm);
			model.addObject("errorMessage", "one of your flatmates seems already to live in another flat!");

			return model;
		}
		// many possible exceptions, therefore juxt catch Exception
		catch (Exception e) {
			ModelAndView model = new ModelAndView("create-ad");
			model.addObject("zipCityAsArray", zipCityService.getZipCityAsList());
			model.addObject("adForm", adForm);
			model.addObject("errorMessage", e.getMessage());

			return model;
		}

	}
	
	/**
	 * Requires /showAd?adId=x.
	 * 
	 * @param adId
	 * @return ad-page containing ad with adId x.
	 */
	@RequestMapping(value = "/showAd", method = RequestMethod.GET)
	public ModelAndView showAd(
			@RequestParam(value = "adId", required = true) long adId, Principal principal) {
		
		ModelAndView model = new ModelAndView("ad");
		Ad ad = adService.getAd(adId);

		if ((ad.getOwner().getUsername()).equals(principal.getName())) {
			model.addObject("isMyAd", true);
		}
		model.addObject("user", userService.getUserByUsername(principal.getName()));
		model.addObject("isBookmarked", userService.isBookmarked(userService.getUserByUsername(principal.getName()),adId));
		model.addObject("adData", ad);
		model.addObject("visitList", adService.getVisitList(adId));
		model.addObject("messageForm", new MessageForm());
		
		User user=userService.getUserByUsername(principal.getName());
		model.addObject("user", user);
		
		return model;
	}
	
	@RequestMapping(params ="modify", value="/modifyAd", method=RequestMethod.POST)
	public ModelAndView modifyAd(@RequestParam(value = "adId", required = true) long adId, Principal principal) {
		
		ModelAndView model = new ModelAndView("create-ad");
		model.addObject("zipCityAsArray", zipCityService.getZipCityAsList());
		model.addObject("isMyAd", true);
		
		Ad ad = adService.getAd(adId);
		model.addObject("adCreationOrModification", "Modify Ad: " + ad.getTitle());
		model.addObject("adData", ad);
		model.addObject("adForm", adService.getAdFormForExistingAd(adId));
		
		return model;
	}
	
	@ResponseBody
	@RequestMapping(params ="delete", value="/modifyAd")
	public ModelAndView deleteAd(@RequestParam(value="adId")Long adId, Principal principal) {
		adService.deleteAd(adId);
		ModelAndView model = new ModelAndView("myPage");
		User user=userService.getUserByUsername(principal.getName());
		model.addObject("user", user);
		model.addObject("mySearchList", searchService.getMySavedSearchForms(user));
		model.addObject("adList", adService.getBookmarkedAds(user.getBookmarks()));
		
		//used for myAds and myVisitors
		model.addObject("myAdsList", adService.getAdsOfUserByUser(user));
		model.addObject("myVisitsList", adService.getVisitsUserRegistered(user));
		return model;
	}	
	
	/**
	 * @RequestParam /addToBookmarks?adId=x.
	 * 
	 * @param adId
	 * @return ad-page containing ad with adId x.
	 */
	@ResponseBody
	@RequestMapping(value = "/addToBookmarks", method = RequestMethod.GET)
	public ModelAndView addToBookmars(
			@RequestParam(value = "adId", required = true) long adId,
			Principal principal) {
		User user = userService.getUserByUsername(principal.getName());

		ModelAndView model = showAd(adId, principal);
		
		adService.bookMarkAdforUser(adId, user);
		model.addObject("isBookmarked", true);
		model.addObject("bookmarkResponse", "Bookmarked successfully!");

		return model;
	}
	
	@ResponseBody
	@RequestMapping(value = "/removeFromBookmarks", method = RequestMethod.GET)
	public ModelAndView removeFromBookmarks(
			@RequestParam(value = "adId", required = true) long adId,
			Principal principal, HttpServletRequest request) {
		
		User user = userService.getUserByUsername(principal.getName());
		ModelAndView model = showAd(adId, principal);
		
		adService.bookMarkAdforUser(adId, user);
		model.addObject("isBookmarked", false);
		model.addObject("bookmarkResponse", "Removed Bookmark successfully!");

		return model;
	}
	/**
	 * Saves current user as visitor of this ad. Visitor can only be registered for the same visit once.
	 * @param visitId
	 * @param principal
	 * @param request
	 * @param redirectAttributes
	 * @return
	 */

	@RequestMapping(value = "/registerForVisit", method = RequestMethod.POST)
	public String registerForVisit(
			@RequestParam(value = "selectedVisit", required = true) long visitId,
			Principal principal, HttpServletRequest request,RedirectAttributes redirectAttributes) {
		try{
			adService.registerUserForVisit(visitId, userService.getUserByUsername(principal.getName()));
			redirectAttributes.addFlashAttribute("message", "Successfully registered");
		}
		catch(InvalidDataAccessApiUsageException e){
			redirectAttributes.addFlashAttribute("message", "Could not register. You probably are already registered?");
		}	
		return  "redirect:" + request.getHeader("Referer");
	}
}