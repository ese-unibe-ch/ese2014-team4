/**
 * 
 */
package ch.unibe.ese2014.team4.controller.service;

import java.util.List;

import ch.unibe.ese2014.team4.controller.pojos.MessageForm;
import ch.unibe.ese2014.team4.model.Message;
import ch.unibe.ese2014.team4.model.User;

import java.util.ArrayList;
import java.util.Collection;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.MessageForm;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.dao.AdDao;

/**
 * @author Zoyela
 *
 */
public class MessageServiceImpl implements MessageService{
	
	public void sendMessage(Message message, User sender, User receiver){
		
		message.setSender(sender);
		message.setReceiver(receiver);
		
		List<Long> receiversInbox = receiver.getInbox();
		receiversInbox.add(message.getMessageId());
		receiver.setInbox(receiversInbox);
		
		List<Long> sendersSent = sender.getSent();
		sendersSent.add(message.getMessageId());
		sender.setSent(sendersSent);
		
	}

	

}
