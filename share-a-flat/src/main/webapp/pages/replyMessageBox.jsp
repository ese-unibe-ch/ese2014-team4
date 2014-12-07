<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>






<h4>Send a message to ${message.sender.username}</h4>

<form method="post" action="sendMessage?receiverName=${message.sender.username}"
	id="messageForm" Class="form-horizontal" autocomplete="off">
	
	<h4>Send a message to ${message.sender.username}</h4>

	<textarea required class="form-control" name="messageText"
		id="field-messageText" style="width: 100%; height: 80px; resize: none"
		tabindex="1" placeholder="Write your message here"></textarea>

	<div class="form-actions">
		<button type="submit" class="btn btn-primary" tabindex="13">Send</button>
	</div>
</form>

