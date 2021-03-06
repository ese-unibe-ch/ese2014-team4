package ch.unibe.ese2014.team4.controller.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

import ch.unibe.ese2014.team4.model.Address;
import ch.unibe.ese2014.team4.model.Message;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.Visit;



public class MessageForm {
	

	private Message message;
		

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message aMessage) {
		this.message = aMessage;
	}

	
}
