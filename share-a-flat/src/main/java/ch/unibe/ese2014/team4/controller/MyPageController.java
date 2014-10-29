package ch.unibe.ese2014.team4.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.service.MyPageService;
import ch.unibe.ese2014.team4.controller.service.NewAccountService;
import ch.unibe.ese2014.team4.model.Profile;
import ch.unibe.ese2014.team4.model.User;

@Controller
public class MyPageController {

	@Autowired
	MyPageService myPageService;





	@RequestMapping(value = "/my-page", method = RequestMethod.GET)
	public ModelAndView myPage() {
		ModelAndView model = new ModelAndView("my-page");
		Profile profile = myPageService.getMyProfile();
		model.addObject("myProfile", profile);
		
		return model;
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profile() {
		ModelAndView model = new ModelAndView("profile");
		return model;
	}

}
