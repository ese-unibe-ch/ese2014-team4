package ch.unibe.ese2014.team4.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.service.NewAccountService;
import ch.unibe.ese2014.team4.controller.service.NewAdService;
import ch.unibe.ese2014.team4.model.Ad;
 /**
  * LoginController: Login process is routed via Spring Security.
  * Controls /, /login (currently not needed), /createAccount: result page after account creation.
  */

@Controller

public class AdController {
	
	@Autowired
	NewAdService newAdService;

	@RequestMapping(value = "/createAd", method = RequestMethod.GET)
    public ModelAndView createAd(){
    	ModelAndView model = new ModelAndView("create-ad");
    	model.addObject("adForm", new AdForm());
        return model;
    }
	@RequestMapping(value = "/submitAd", method = RequestMethod.POST)
    public ModelAndView submitAd(@Valid AdForm adForm, BindingResult result, RedirectAttributes redirectAttributes){
    	ModelAndView model = new ModelAndView("home");   
    	newAdService.saveAdForm(adForm);
    	Ad ad = newAdService.getAd(adForm.getId());
    	model.addObject("ad", ad);
        return model;
    }	

}