package ch.unibe.ese2014.team4.controller;


import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.service.LoginService;
import ch.unibe.ese2014.team4.controller.service.NewAccountService;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.model.Ad;
 /**
  * Controls all pages / commands concerning ads.
  */

@Controller

public class AdController {
	
	@Autowired
	AdService newAdService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/createAd", method = RequestMethod.GET)
    public ModelAndView createAd(){
    	ModelAndView model = new ModelAndView("create-ad");
    	model.addObject("adForm", new AdForm());
        return model;
    }
	@RequestMapping(value = "/submitAd", method = RequestMethod.POST)
    public ModelAndView submitAd(@Valid AdForm adForm, BindingResult result, RedirectAttributes redirectAttributes, Principal principal){
    	ModelAndView model = new ModelAndView("home");   
    	newAdService.saveAdForm(adForm, userService.getUserByUsername(principal.getName()));
    	Ad ad = newAdService.getAd(adForm.getId());
    	model.addObject("ad", ad);
        return model;
    }	
	/**
	 * Requires /showAd?adId=x.
	 * @param adId
	 * @return ad-page containing ad with adId x.
	 */
	@RequestMapping(value = "/showAd", method = RequestMethod.GET)
    public ModelAndView submitAd(@RequestParam(value = "adId", required  = true) long adId){
    	ModelAndView model = new ModelAndView("ad");   
    	Ad ad = newAdService.getAd(adId);
    	model.addObject("adData", ad);		//called adData, otherwise gets confused with "ad" page
        return model;
    }

}