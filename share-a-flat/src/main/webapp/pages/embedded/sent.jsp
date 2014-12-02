<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- to format date and time -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!-- only used as imported part of other pages, therefore no header / footer. -->


<!-- <h2>Inbox</h2> -->


<br>
<!-- to insert space: &#160. will be improved -->
<c:forEach items="${sentList}" var="message">
	<b>To:</b> &#160&#160&#160&#160&#160 
		<a href="${pageContext.request.contextPath}/profile?userId=${message.receiver.id}">${message.receiver.username}</a> 
	<br> <b>Sent:</b> &#160&#160 
		<fmt:formatDate type="both" dateStyle="short" pattern="dd.MM.yyyy   HH:mm" value="${message.date}" />
	<pre>${message.messageText}</pre>
	
<hr>
</c:forEach>
