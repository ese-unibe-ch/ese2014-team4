<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!-- only used as imported part of other pages, therefore no header / footer. -->


<h4>Send a message to ${adData.owner.username}</h4>


<form:form enctype="multipart/form-data" method="post"
	modelAttribute="messageForm" action="sendMessage" id="messageForm"
	cssClass="form-horizontal" autocomplete="off">

	<textarea required="true" class="form-control" path="message"
		id="field-message" style="width: 100%; height: 121px; resize: none"
		tabindex="12" placeholder="Message"></textarea>
	<div class="form-actions">
		<button type="submit" class="btn btn-primary" tabindex="13">Send</button>
	</div>
	<br>
</form:form>

<script type="text/javascript">
	
</script>

