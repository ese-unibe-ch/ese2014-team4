<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!-- only used as imported part of other pages, therefore no header / footer. -->


 

 <div class="panel panel-default">
				<div class="panel-heading">
					<h3>
						<b>My Visits</b>
					</h3>
				</div>
				<div class="panel-body">
				<c:choose><c:when test="${fn:length(myVisitsList) eq 0}">You have not registered for any visits</c:when><c:otherwise>
						<c:forEach items="${myVisitsList}" var="visit">
							${visit}
							<br>
						</c:forEach> 
					</c:otherwise></c:choose>
				</div>
</div>
 <div class="panel panel-default">
				<div class="panel-heading">
					<h3>
						<b>My Visitors</b>
					</h3>
				</div>
				<div class="panel-body">
				<c:choose><c:when test="${fn:length(myVisitsList) eq 0}">You have no visitors</c:when><c:otherwise>
						<c:forEach items="${myVisitsList}" var="visit">
							${visit}: <c:forEach items="${visit.visitorList}" var="user">${user.username} </c:forEach>
							<br>
						</c:forEach> 
					</c:otherwise></c:choose>
				</div>
</div>