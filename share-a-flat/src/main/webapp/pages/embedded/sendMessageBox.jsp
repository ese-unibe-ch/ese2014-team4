<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!-- only used as imported part of other pages, therefore no header / footer. -->

<c:set var="receiverName">
	<c:if test="${adData.owner.username!=null}">${adData.owner.username}</c:if>
	<c:if test="${userProfile.username!=null}">${userProfile.username}</c:if>
</c:set>

<c:set var="whereIAm" value="history.go(-1)"></c:set>

<h4>${message}</h4>
<span>${sendMessageResponse}</span>

<form method="post" action="sendMessage?receiverName=${receiverName}"
	id="messageForm" Class="form-horizontal" autocomplete="off">

	<textarea required class="form-control" name="messageText"
		id="field-messageText" style="width: 100%; height: 80px; resize: none"
		tabindex="1" placeholder="Send a message to ${receiverName}"></textarea>

	<div class="form-actions">
		<button type="submit" class="btn btn-primary" tabindex="13">Send</button>
	</div>
</form>
