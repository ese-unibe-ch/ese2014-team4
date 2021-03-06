package ch.unibe.ese2014.team4.controller.service;

import java.util.List;

import ch.unibe.ese2014.team4.controller.pojos.MessageForm;
import ch.unibe.ese2014.team4.model.Message;
import ch.unibe.ese2014.team4.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.unibe.ese2014.team4.controller.exceptions.BookmarkException;
import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.MessageForm;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.dao.AdDao;
import ch.unibe.ese2014.team4.model.dao.MessageDao;
import ch.unibe.ese2014.team4.model.dao.UserDao;

/**
 * @author Zoyela
 * Controls everything that has to do with sending and receiving of messages from user to user
 *
 */

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	MessageDao messageDao;
	
	@Autowired
	UserDao userDao;
	
	public void sendMessage(String messageText, User sender, User receiver){
		
		Message message = new Message(); 
		Date date = new Date();
		
		message.setDate(date);
		message.setSender(sender);
		message.setReceiver(receiver);
		message.setMessageText(messageText);
		messageDao.save(message);
		
	}
	
	public List<Message> getSentList(User user){
		List<Message> messages = messageDao.findAllBySender(user);
		Collections.reverse(messages); 
		return messages;
	}
	
	public List<Message> getInboxList(User user){
		List<Message> messages = messageDao.findAllByReceiver(user);
		Collections.reverse(messages); 
		return messages;
	}

	/**
	 * Deletes the message from inbox or sent of the user. If it is deleted from the sender's sent and 
	 * the receiver's inbox it is deleted from the database.
	 */
	public void deleteMessage(long id, User user) {
		Message message = messageDao.findById(id);
		if (message.getReceiver().getId() == user.getId()){
			message.setShowInInbox(1);
			messageDao.save(message);
		}
		if (message.getSender().getId() == user.getId()){
			message.setShowInSent(1);
			messageDao.save(message);
		}
		if (((message.getShowInInbox()==1)&&(message.getShowInSent()==1))){
			messageDao.delete(id);
		}		
	}
	

}
