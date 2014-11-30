/**
 * 
 */
package ch.unibe.ese2014.team4.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ch.unibe.ese2014.team4.controller.exceptions.BookmarkException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.MessageForm;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.MessageService;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.MapAddress;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.ZipCityList;
import ch.unibe.ese2014.team4.model.ZipCity;

/**
 * @author Zoyela
 * Controls all concerning sending and receiving of messages.
 *
 */
@Controller
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	UserService userService;
	

	/**
	 * Controls submission of the message.
	 * 
	 * 
	 */
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public ModelAndView sendMessage(MessageForm messageForm,
			BindingResult result, Principal principal) throws Exception {

		messageService.sendMessage(messageForm.getMessage(),userService.getUserByUsername(principal.getName()));

		ModelAndView model = new ModelAndView("ad");
		return null;
	}
	
	
//	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
//	public ModelAndView sendMessageTwo(MessageForm messageForm,
//			BindingResult result, Principal principal) throws Exception {
//
//		messageService.sendMessage(messageForm.getMessage(),
//				userService.getUserByUsername(principal.getName()),
//				userService.getUser(messageForm.getReceiverId()));
//
//		ModelAndView model = new ModelAndView("ad");
//		return null;
//	}
}

	