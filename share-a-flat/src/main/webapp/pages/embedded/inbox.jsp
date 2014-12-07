<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- to format date and time -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="functions/generalFunctions.jsp" />


<!-- only used as imported part of other pages, therefore no header / footer. -->


<!-- to insert space: &#160. will be improved -->
<span>${sendMessageResponse}</span>
<c:forEach items="${inboxList}" var="message" varStatus="loopIndex">

	<c:if test="${message.showInInbox eq 0}">
		<c:set var="messageId" value="${message.id}"></c:set>
		
		<form method="post" action="deleteMessage?messageId=${messageId}"
			id="messageForm" Class="form-horizontal" autocomplete="off">

			<b>From:</b> &#160&#160&#160&#160&#160&#160&#160&#160 <a
				href="${pageContext.request.contextPath}/profile?userId=${message.sender.id}">${message.sender.username}</a>
				
			<br>
			<a data-toggle="collapse" data-parent="#accordion" href="#collapseInbox${loopIndex.index}">
			<c:choose><c:when test="${message.isRead eq true}">Received: &#160</c:when><c:otherwise><b>Received: &#160</b></c:otherwise></c:choose>
			<fmt:formatDate type="both" dateStyle="short"
				pattern="dd.MM.yyyy   HH:mm" value="${message.date}" /></a>
				
			<br>
			<div id="collapseInbox${loopIndex.index}" class="panel-collapse collapse">
				<pre>${message.messageText}</pre>
			

			<button name="delete" type="submit" value="delete Message"
				onclick="return confirm('Are you sure you want to delete this message?')"
				class="btn btn-warning">delete</button>

			<button onclick="openReply()" type="button" class="btn btn-primary">Reply</button>

			</div>

			<hr>
			
		</form>
	</c:if>
</c:forEach>

<script>
function openReply() {
    var myWindow = window.open("${pageContext.request.contextPath}/replyMessageBox", "", "width=500, height=300 left=300 top=150");
}
</script>
