package ch.unibe.ese2014.team4.controller;

import java.security.Principal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ch.unibe.ese2014.team4.controller.exceptions.BookmarkException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.MessageForm;
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
			Principal principal, ModelAndView oldModel) throws Exception {

			newAdService.saveAdForm(adForm,
					userService.getUserByUsername(principal.getName()));
			return showAd(adForm.getId());
		
		// many possible exceptions, therefore juxt catch Exception
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
			@RequestParam(value = "adId", required = true) long adId) {
		ModelAndView model = new ModelAndView("ad");

		Ad ad = newAdService.getAd(adId);
		MapAddress addressForMap = ad.getAddressForMap();
		List<String> list = adService.getImageList(adId);
		model.addObject("addressForMap", addressForMap);
		model.addObject("imageList", list);
		model.addObject("adData", ad); // called adData, otherwise gets confused
										// with "ad" page
		model.addObject("messageForm", new MessageForm());
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

		ModelAndView model = showAd(adId);
		try {
			adService.bookMarkAdforUser(adId, user);
			model.addObject("bookmarkResponse", "Bookmarked successfully!");

		} catch (BookmarkException e) {
			model.addObject("bookmarkResponse", "Already bookmarked!");
		}

		return model;
	}

}