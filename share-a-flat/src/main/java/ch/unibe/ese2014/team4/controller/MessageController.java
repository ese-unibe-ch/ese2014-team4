/**
 * 
 */
package ch.unibe.ese2014.team4.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;


import ch.unibe.ese2014.team4.controller.service.MessageService;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.model.Message;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.MessageDao;

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
	
	@Autowired
	MessageDao messageDao;
	
	
	@RequestMapping(value = "/myMessages", method = RequestMethod.GET)

	public ModelAndView myMessages(Principal principal)  {

		ModelAndView model = new ModelAndView("myMessages");
		try{
			User user=userService.getUserByUsername(principal.getName());
					
			model.addObject("inboxList", messageService.getInboxList(user));
			model.addObject("sentList", messageService.getSentList(user));
			model.addObject("user", user);

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
	public String sendMessage(@RequestParam(value="receiverName", required=true) String receiverName, @RequestParam(value="messageText", required=true) String messageText,

		Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {

		messageService.sendMessage(messageText, userService.getUserByUsername(principal.getName()), userService.getUserByUsername(receiverName));
		//http://stackoverflow.com/questions/804581/spring-mvc-controller-redirect-to-previous-page
		
		redirectAttributes.addFlashAttribute("sendMessageResponse", "Message sent successfully!");
		
		return "redirect:" + request.getHeader("Referer");
	}
	
	
	/**
	 * Controls deletion of the message.
	 * 
	 */

	@RequestMapping(value = "/deleteMessage", method = RequestMethod.POST)
	public String deleteMessage(@RequestParam(value="messageId", required=true) long messageId, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
		ModelAndView model = new ModelAndView("myMessages");
		User user = userService.getUserByUsername(principal.getName());

		messageService.deleteMessage(messageId, user);
		
		model.addObject("inboxList", messageService.getInboxList(user));
		model.addObject("sentList", messageService.getSentList(user));
		redirectAttributes.addFlashAttribute("message", "message deleted");
		return "redirect:" + request.getHeader("Referer");
	}
	
}

	