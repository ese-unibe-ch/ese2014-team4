package ch.unibe.ese2014.team4.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Message {
	
	
	@Id
	@GeneratedValue
	private Long messageId;
	
	
	private String aMessage;
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
	public String getaMessage() {
		return aMessage;
	}
	public void setaMessage(String aMessage) {
		this.aMessage = aMessage;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getMessageId() {
		return messageId;
	}
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

}
