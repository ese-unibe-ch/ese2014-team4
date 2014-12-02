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
import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.exceptions.ProfileException;
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

//TODO implement going back to the previous page when sending a message

/**
 * @author Zoyela
 * Controls all concerning sending, receiving  and displaying of messages.
 *
 */
@Controller
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "/myMessages", method = RequestMethod.GET)
	public ModelAndView myMessages(Principal principal)throws ProfileException {
		ModelAndView model = new ModelAndView("myMessages");
		try{
			User user=userService.getUserByUsername(principal.getName());
					
			model.addObject("inboxList", messageService.getInboxList(user));
			model.addObject("sentList", messageService.getSentList(user));
		}
		catch(InvalidUserException e){
			
		}

		return model;
	}
	

	/**
	 * Controls submission of the message.
	 * 
	 */
	//@ResponseBody
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public ModelAndView sendMessage(@RequestParam(value="receiverName", required=true) String receiverName, @RequestParam(value="messageText", required=true) String messageText,
		Principal principal) throws Exception {

		messageService.sendMessage(messageText, userService.getUserByUsername(principal.getName()), userService.getUserByUsername(receiverName));

//		ModelAndView model = new ModelAndView("ad");
		return null;
	}
	
	/**
	 * Controls deletion of the message.
	 * 
	 */
	//@ResponseBody
	@RequestMapping(value = "/deleteMessage", method = RequestMethod.POST)
	public ModelAndView deleteMessage(@RequestParam(value="messageId", required=true) long messageId, Principal principal) throws Exception {
		ModelAndView model = new ModelAndView("myMessages");

		messageService.deleteMessage(messageId, userService.getUserByUsername(principal.getName()));

		return model;
	}
	
}

	