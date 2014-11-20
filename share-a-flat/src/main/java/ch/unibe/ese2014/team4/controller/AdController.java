package ch.unibe.ese2014.team4.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.service.LoginService;
import ch.unibe.ese2014.team4.controller.service.NewAccountService;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.PlzCityList;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.Zip;


/**
 * Controls all pages / commands concerning ads, including the creation, submission and showing ads.
 */
@Controller
public class AdController {
	
	@Autowired
	AdService newAdService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	AdService adService;
	
	 private PlzCityList plzParserService = new PlzCityList();
	
	@RequestMapping(value = "/createAd", method = RequestMethod.GET)
    public ModelAndView createAd(){
    	ModelAndView model = new ModelAndView("create-ad");    	
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
    public ModelAndView submitAd(AdForm adForm, BindingResult result,  Principal principal) throws Exception{

    	newAdService.saveAdForm(adForm, userService.getUserByUsername(principal.getName()));

        return submitAd(adForm.getId());
    }	
	
	/**
	 * Requires /showAd?adId=x.
	 * 
	 * @param adId
	 * @return ad-page containing ad with adId x.
	 */
	@RequestMapping(value = "/showAd", method = RequestMethod.GET)
    public ModelAndView submitAd(@RequestParam(value = "adId", required  = true) long adId){
    	ModelAndView model = new ModelAndView("ad");   
    	
    	Ad ad = newAdService.getAd(adId);
    	
    	List<String> list =adService.getImageList(adId);	
    	model.addObject("imageList", list);
    	model.addObject("adData", ad);		//called adData, otherwise gets confused with "ad" page
        return model;
    }

}