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
						<b>Visit this place</b>
					</h3><br>
					<span>${message}</span>
				</div>
				<div class="panel-body">
				<c:choose><c:when test="${fn:length(adData.visitList) eq 0}">Visit by appointment only</c:when><c:otherwise>
					<form action="registerForVisit" method="post">
					<fieldset>
						<c:forEach items="${adData.visitList}" var="visit">
							<input type="radio" id="selectedVisit" name="selectedVisit" value="${visit.id}"/>${visit}
							<br>
						</c:forEach>
						<input type="submit" id="submitButton" value = "register for visit"/>
					</fieldset>
					</form> 
					</c:otherwise></c:choose>
				</div>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		  $('#submitButton').click(function() {
			  if(!$('#selectedVisit').is(':checked')) {
		       alert('Please chose a visit date before register!');
		        return false;
		    } else {
		    	return true;
		    }
		  }
		 );
		});	
</script>