package ch.unibe.ese2014.team4.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.Message;
import ch.unibe.ese2014.team4.model.User;

public interface MessageDao extends CrudRepository<Message,Long>  {
	
	Message findById(Long id);
	
	List<Message> findAllByReceiver(User receiver);
	
	List<Message> findAllBySender(User sender);

}
