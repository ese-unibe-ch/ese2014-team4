package ch.unibe.ese2014.team4.controller;

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
import ch.unibe.ese2014.team4.controller.service.SampleService;

@Controller
public class TabBarController {
	
	
	    @RequestMapping(value = "/favorites", method = RequestMethod.GET)
	    public ModelAndView favorites() {
	    	ModelAndView model = new ModelAndView("favorites");
	        return model;
	    }
	    
	    @RequestMapping(value = "/home", method = RequestMethod.GET)
	    public ModelAndView home() {
	    	ModelAndView model = new ModelAndView("home");
	        return model;
	    }
	    
	    
	    @RequestMapping(value = "/search-list", method = RequestMethod.GET)
	    public ModelAndView searchList() {
	    	ModelAndView model = new ModelAndView("search-list");
	        return model;
	    }
	    
	    @RequestMapping(value = "/search-map", method = RequestMethod.GET)
	    public ModelAndView searchMap() {
	    	ModelAndView model = new ModelAndView("search-map");
	        return model;
	    }
	    
	    @RequestMapping(value = "/my-page", method = RequestMethod.GET)
	    public ModelAndView myPage() {
	    	ModelAndView model = new ModelAndView("my-page");
	    	model.addObject("signupForm", new SignupForm());    	
	        return model;
	    }
	    
	    @RequestMapping(value = "/profile", method = RequestMethod.GET)
	    public ModelAndView profile() {
	    	ModelAndView model = new ModelAndView("profile");
	        return model;
	    }
	        
	    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
	    public String securityError(RedirectAttributes redirectAttributes) {
	        redirectAttributes.addFlashAttribute("page_error", "You do have have permission to do that!");
	        return "redirect:/";
	    }


}
