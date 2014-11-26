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
import ch.unibe.ese2014.team4.controller.pojos.SearchForm;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.NewAccountService;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.MapAddress;
import ch.unibe.ese2014.team4.model.User;

@Controller
public class HomeController {

	@Autowired
	AdService adService;


	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(Principal principal) {
		ModelAndView model = new ModelAndView("search");
		model.addObject("resultType", "list");
		
		String username = principal.getName();
		model.addObject("username", username);
		
		ArrayList<Ad> newestAdds = adService.getNewestAds();
		model.addObject("adList", newestAdds);

		model.addObject("searchForm", new SearchForm());
		
		//provisorisch...
		model.addObject("whatToDisplay", "Newest Ads");
		ArrayList<MapAddress> addresses = getAddressesForMap(newestAdds);	
		model.addObject("addresses", addresses);
		
		return model;
	}
   
	//provisorisch...
	private ArrayList<MapAddress> getAddressesForMap(ArrayList<Ad> ads) {
		ArrayList<MapAddress> addresses = new ArrayList<MapAddress>();
		for (Ad ad : ads) {
			MapAddress tmpMapAddress = ad.getAddressForMap();
			addresses.add(tmpMapAddress);
		}
		return addresses;
	}
   
}


