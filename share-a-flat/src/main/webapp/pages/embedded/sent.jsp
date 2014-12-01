<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!-- only used as imported part of other pages, therefore no header / footer. -->


<!-- <h2>Inbox</h2> -->


<br>
<!-- to insert space: &#160. will be improved -->
<c:forEach items="${sentList}" var="message">
	<b>To:</b> &#160&#160&#160&#160&#160 ${message.sender.username} 
	<br> <b>Sent:</b> &#160&#160 ${message.date}<br>
	<pre>${message.messageText}</pre>
	
<hr>
</c:forEach>
