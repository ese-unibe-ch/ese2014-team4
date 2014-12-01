package ch.unibe.ese2014.team4.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message {
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	private String messageText;
	private User sender;
	private User receiver;
	private Date date;

	
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long messageId) {
		this.id = messageId;
	}

}
