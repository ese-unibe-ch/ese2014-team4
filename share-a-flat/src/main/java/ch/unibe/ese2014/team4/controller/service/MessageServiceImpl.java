package ch.unibe.ese2014.team4.controller.service;

import java.util.List;

import ch.unibe.ese2014.team4.controller.pojos.MessageForm;
import ch.unibe.ese2014.team4.model.Message;
import ch.unibe.ese2014.team4.model.User;

import java.util.ArrayList;
import java.util.Collection;
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
		
		Message message = new Message(); //wird ID selbst generiert?
		Date date = new Date();
		
		message.setDate(date);
		message.setSender(sender);
		message.setReceiver(receiver);
		message.setMessageText(messageText);
		messageDao.save(message);
	
//		adMessageToInbox(message.getId(), receiver);
//		adMessageToSent(message.getId(), sender);
		
	}
	
	public List<Message> getSentList(User user){
		return messageDao.findAllBySender(user);
	}
	
	public List<Message> getInboxList(User user){
		return messageDao.findAllByReceiver(user);
	}
	

//	public void adMessageToInbox(long messageId, User _receiver) {
//		List<Long> list = _receiver.getInbox();
//		if(!list.contains(messageId)){
//			list.add(messageId);
//			_receiver.setInbox(list);
//			userDao.save(_receiver);
//		}
////		else throw new MessageExeption("already added to inbox");
//	}
//	
//	
//	public void adMessageToSent(long messageId, User _sender) {
//		List<Long> list = _sender.getSent();
//		if(!list.contains(messageId)){
//			list.add(messageId);
//			_sender.setSent(list);
//			userDao.save(_sender);
//		
//		}
//
////		else throw new MessageException("already added to sent!");
//					
//	}
//
//	
//	public List<Message> getInboxMessages(List<Long> messages, User user) {
//		List<Message> list = new ArrayList<Message>();
//		for(Long id : messages){
//			Message message = messageDao.findById(id);
//			if (message.getReceiver() == user ) list.add(message);
//		}
//		return list;
//	}
//	
//	public List<Message> getSentMessages(List<Long> messages, User user) {
//		List<Message> list = new ArrayList<Message>();
//		for(Long id : messages){
//			Message message = messageDao.findById(id);
//			if (message.getSender() == user ) list.add(message);
//		}
//		return list;
//	}
	
}
