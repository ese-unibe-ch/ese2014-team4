package ch.unibe.ese2014.team4.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Message implements Serializable {
	
	
	@Id
	@GeneratedValue
	private Long id;  
	
	
	private String messageText;
	
	@ManyToOne
	@JoinColumn(name = "sender_id")
	private User sender;
	
	@ManyToOne
	@JoinColumn(name = "receiver_id")
	private User receiver;
	
	private Date date;
	
	//0 = show, 1 = do not show
	private int showInInbox = 0;
	private int showInSent = 0;

	
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
	public int getShowInInbox() {
		return showInInbox;
	}
	public void setShowInInbox(int showInInbox) {
		this.showInInbox = showInInbox;
	}
	public int getShowInSent() {
		return showInSent;
	}
	public void setShowInSent(int showInSent) {
		this.showInSent = showInSent;
	}


}
