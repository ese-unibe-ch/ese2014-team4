<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<script type="text/javascript">

sendTheMessage(){
	setReceiver();
	setSender();
	setMessageText();
	sendMessage(messageForm.getMessage());
}

//contactField in ad page: adData.owner, contactField in profile page: user
function setReceiver(){
	if(document.getElementById("${adData.owner}")!=0 )
		messageForm.message.setReceiver(document.getElementById("${adData.owner}"));
	else(messageForm.message.setReceiver(document.getElementById("${user}")));
}

function setSender(){
	messageForm.message.setSender(document.getElementById("${principal}"));
}

function setMessageText(){
	messageForm.message.setMessageText(document.getElementById("field-message").value);
}


</script>


<!-- only used as imported part of other pages, therefore no header / footer. -->
<h4>Send a message to ${adData.owner.username}${user.username}</h4>


<form:form method="post" modelAttribute="messageForm"
	action="sendMessage" id="messageForm" cssClass="form-horizontal"
	autocomplete="off" onsubmit="addReceiverIdToMessageForm()">


	<textarea required="true" class="form-control" path="message"
		id="field-message" style="width: 100%; height: 80px; resize: none"
		tabindex="1" placeholder="write your message here"
		></textarea>
	<div class="form-actions">
		<button type="submit" class="btn btn-primary" tabindex="13" onsubmit="sendTheMessage()">Send</button>


	</div>
	<br>


</form:form>

<script type="text/javascript">
	
</script>

