package ch.unibe.ese2014.team4.controller;

import java.security.Principal;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.SearchForm;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.NewAccountService;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.MapAddress;
import ch.unibe.ese2014.team4.model.User;

@Controller
public class AdminController {

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView home(Principal principal) {
		ModelAndView model = new ModelAndView("admin");

		
		String username = principal.getName();
		model.addObject("username", username);
		return model;
	}
	@RequestMapping(value = "/noAccess", method = RequestMethod.GET)
	public String securityError(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("page_error",
				"You do have have permission to do that!");
		return "redirect:/";
	} 
   
}


