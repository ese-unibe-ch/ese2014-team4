package ch.unibe.ese2014.team4.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ch.unibe.ese2014.team4.controller.exceptions.BookmarkException;
import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.MessageForm;
import ch.unibe.ese2014.team4.controller.pojos.ProfileForm;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.MessageService;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.MapAddress;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.ZipCityList;
import ch.unibe.ese2014.team4.model.ZipCity;


/**
 * Controls all pages / commands concerning ads, including the creation,
 * submission and showing ads.
 */
@Controller
public class AdController {

	@Autowired
	AdService newAdService;

	@Autowired
	UserService userService;

	@Autowired
	AdService adService;


	private final String SWISS_ZIP_FILE = "src/main/resources/files/plzSwiss.csv";
	private ZipCityList zipCityListCh = new ZipCityList(SWISS_ZIP_FILE);
	private ArrayList<ZipCity> zipCityAsArray = zipCityListCh
			.getZipCityAsArrayList();

	@RequestMapping(value = "/createAd", method = RequestMethod.GET)
	public ModelAndView createAd() {
		
		ModelAndView model = new ModelAndView("create-ad");
		model.addObject("zipCityAsArray", zipCityAsArray);
		model.addObject("adForm", new AdForm());

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
		//try{
		System.out.println(adForm.getId());
			newAdService.saveAdForm(adForm,
					userService.getUserByUsername(principal.getName()));
			return showAd(adForm.getId(), principal);
//		}
//		
//		catch (ConstraintViolationException e) {
//			ModelAndView model = new ModelAndView("create-ad");
//			model.addObject("zipCityAsArray", zipCityAsArray);
//			model.addObject("adForm", adForm);
//			model.addObject("errorMessage", "one of your flatmates seems already to live in another flat!");
//
//			return model;
//		}
//		// many possible exceptions, therefore juxt catch Exception
//		catch (Exception e) {
//			ModelAndView model = new ModelAndView("create-ad");
//			model.addObject("zipCityAsArray", zipCityAsArray);
//			model.addObject("adForm", adForm);
//			model.addObject("errorMessage", e.getMessage());
//
//			return model;
//		}

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
		Ad ad = newAdService.getAd(adId);

		if ((ad.getOwner().getUsername()).equals(principal.getName())) {
			model.addObject("isMyAd", true);
		}
		
		MapAddress addressForMap = ad.getAddressForMap();
		List<String> list = adService.getImageList(adId);
		model.addObject("isBookmarked", userService.isBookmarked(userService.getUserByUsername(principal.getName()),adId));
		model.addObject("addressForMap", addressForMap);
		model.addObject("imageList", list);
		model.addObject("adData", ad);
		model.addObject("visitList", adService.getVisitList(adId));
		model.addObject("messageForm", new MessageForm());
		return model;
	}
	
	@RequestMapping(params ="modify", value="/modifyAd", method=RequestMethod.POST)
	public ModelAndView modifyAd(@RequestParam(value = "adId", required = true) long adId, Principal principal) {
		
		ModelAndView model = new ModelAndView("create-ad");
		model.addObject("isMyAd", true);
		Ad ad = newAdService.getAd(adId);
		model.addObject("adData", ad);
		model.addObject("visitList", ad.getVisitList());
		model.addObject("adForm", adService.getAdFormForExistingAd(adId));
		
		return model;
	}
	@ResponseBody
	@RequestMapping(params ="delete", value="/modifyAd")
	public void deleteAd(@RequestParam(value="adId")Long adId) {
		adService.deleteAd(adId);
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

	

	@RequestMapping(value = "/registerForVisit", method = RequestMethod.POST)
	public String registerForVisit(
			@RequestParam(value = "selectedVisit", required = true) long visitId,
			Principal principal, HttpServletRequest request) {
		
		adService.registerUserForVisit(visitId, userService.getUserByUsername(principal.getName()));
		
		return  "redirect:" + request.getHeader("Referer");
	}
	

}