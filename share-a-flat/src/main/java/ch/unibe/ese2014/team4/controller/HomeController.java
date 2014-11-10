package ch.unibe.ese2014.team4.controller;

import java.security.Principal;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.NewAccountService;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.User;

@Controller
public class HomeController {

	@Autowired
	AdService adService;


	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(Principal principal) {
		ModelAndView model = new ModelAndView("home");
		
		String username = principal.getName();
		model.addObject("username", username);
		
		ArrayList<Ad> newestAdds = adService.getNewestAds();
		model.addObject("newestAdds", newestAdds);
		
		return model;
	}
 /*   
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(){
    	ModelAndView model;
    	model = new ModelAndView("home");
    	//to do
    	System.out.println("to do: method");
    	return model;
    }
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public ModelAndView signIn(@Valid SignupForm signupForm, BindingResult result, RedirectAttributes redirectAttributes) {
    	ModelAndView model;    	
    	if (!result.hasErrors()) {
            try {
            	sampleService.saveFrom(signupForm);
            	model = new ModelAndView("home");
            	User user = sampleService.getUser(signupForm.getId());
				model.addObject("user", user);
            } catch (InvalidUserException e) {
            	model = new ModelAndView("index");
            	model.addObject("page_error", e.getMessage());
            }
        } else {
        	model = new ModelAndView("index");
        }   	
    	return model;
    }
    */
   
}


