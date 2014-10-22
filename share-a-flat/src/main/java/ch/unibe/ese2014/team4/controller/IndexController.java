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
import ch.unibe.ese2014.team4.controller.pojos.LoginForm;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.service.SampleService;
import ch.unibe.ese2014.team4.model.User;

@Controller
public class IndexController {

    @Autowired
    SampleService sampleService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
    	ModelAndView model = new ModelAndView("index");
    	model.addObject("signupForm", new SignupForm());
    	model.addObject("loginForm", new LoginForm());
        return model;
    }

    
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
    
   
}


