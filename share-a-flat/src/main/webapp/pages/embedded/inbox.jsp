<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- to format date and time -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="functions/generalFunctions.jsp" />


<!-- only used as imported part of other pages, therefore no header / footer. -->


<!-- <h2>Inbox</h2> -->

<form method="post" action="deleteMessage?messageId=${messageId}" id="messageForm" Class="form-horizontal"
	autocomplete="off" >
	
<!-- to insert space: &#160. will be improved -->
<c:forEach items="${inboxList}" var="message">
<c:set var="messageId" value="${message.id}"></c:set>
	<b>From:</b> &#160&#160&#160&#160&#160&#160&#160&#160
		<a href="${pageContext.request.contextPath}/profile?userId=${message.sender.id}">${message.sender.username}</a>
	<br><b>Received:</b> &#160
		<fmt:formatDate type="both" dateStyle="short" pattern="dd.MM.yyyy   HH:mm" value="${message.date}" /><br>
	<pre>${message.messageText}</pre>
	<button type="submit" onclick="return deleteMessageAlert()"
		>Delete message</button>
<hr>
</c:forEach>

</form>
