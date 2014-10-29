package ch.unibe.ese2014.team4.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.service.NewAdService;
 /**
  * LoginController: Login process is routed via Spring Security.
  * Controlls /, /login (currently not needed), /createAccount: result page after account creation.
  * 
  *
  */
@Controller
public class AdController {
	

	@RequestMapping(value = "/createAd", method = RequestMethod.GET)
    public ModelAndView createAd(){
    	ModelAndView model = new ModelAndView("create-ad");
    	model.addObject("adForm", new AdForm());
        return model;
    }
	@RequestMapping(value = "/submitAd", method = RequestMethod.POST)
    public ModelAndView submitAd(){
    	ModelAndView model = new ModelAndView("home");    	
        return model;
    }	
}
