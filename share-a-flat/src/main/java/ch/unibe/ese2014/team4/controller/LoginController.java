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
import ch.unibe.ese2014.team4.controller.service.NewAccountService;
import ch.unibe.ese2014.team4.model.User;
 /**
  * LoginController: Login process is routed via Spring Security.
  * 
  *
  */
@Controller
public class LoginController
{
    @Autowired
    NewAccountService sampleService;

/**
 * Probably never accessed currently. Should be captured by Spring Security in SpringSecurity.xml
 * @return
 */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
    	ModelAndView model = new ModelAndView("login");
    	model.addObject("signupForm", new SignupForm());
        return model;
    }

    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(){
    	ModelAndView model = new ModelAndView("login");
    	model.addObject("signupForm", new SignupForm());
        return model;
    }
    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
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
    
}