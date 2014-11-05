package ch.unibe.ese2014.team4.controller;

import java.io.IOException;
import java.net.URL;
import java.security.Principal;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.exceptions.ProfileException;
import ch.unibe.ese2014.team4.controller.pojos.ProfileForm;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.pojos.UploadForm;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.controller.service.NewAccountService;
import ch.unibe.ese2014.team4.controller.service.ProfileService;
import ch.unibe.ese2014.team4.model.Profile;
import ch.unibe.ese2014.team4.model.User;
/**
 * currently used as playground.
 *
 */
@Controller
public class UploadController {

	@RequestMapping(value = "/uploadPage", method = RequestMethod.GET)
	public ModelAndView myPage(Principal principal) {
		//URL url = this.getClass().getClassLoader().getResource("application.properties");
		//System.out.println(url.getPath());

		return new ModelAndView("uploadPage");
	}
	
	@RequestMapping(value = "/upload.form", method = RequestMethod.POST)
	public ModelAndView myPage(@RequestParam("uploadedFile") MultipartFile file, Principal principal) {
		try {
			byte[] fileByte = file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(file.getName());
		ModelAndView model = new ModelAndView("uploadPage");
		
		return model;
	}	
	

}
