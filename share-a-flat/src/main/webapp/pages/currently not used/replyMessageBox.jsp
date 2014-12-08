<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>




<c:set var="newReceiver" value="${originalMessage.sender}"/>	

<form method="post" action="sendMessage?receiverName=${newReceiver.username}"
	id="messageForm" Class="form-horizontal" autocomplete="off" >
	
	<h4>Send a message to ${newReceiver.username}</h4>
	<span>${sendMessageResponse}</span>

	<textarea required class="form-control" name="messageText"
		id="field-messageText" style="width: 100%; height: 80px; resize: none"
		tabindex="1" placeholder="Write your message here"></textarea>

	<div class="form-actions">
		<button type="submit" class="btn btn-primary" tabindex="13" onclick="CloseAndRefresh()">Send</button>
	</div>
</form>

<script>
function CloseAndRefresh(){
	//window.close();
	//window.opener.history.go(0); 
   //opener.location.reload();
   window.opener.location.reload(true);
   window.close();
}


</script>