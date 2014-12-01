/**
 * 
 */
package ch.unibe.ese2014.team4.controller.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.MessageForm;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.Message;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.AdDao;

/**
 * @author Zoyela
 *
 */
public interface MessageService {

	public void sendMessage(Message message, User sender);

}
