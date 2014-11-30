package ch.unibe.ese2014.team4.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.Address;

import ch.unibe.ese2014.team4.model.Message;
import ch.unibe.ese2014.team4.model.User;

public interface MessageDao extends CrudRepository<Message,Long>  {
	
	Message findAllById(Long messageId);

}
